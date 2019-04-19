package net.ninemm.survey.service.provider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import io.jboot.aop.annotation.Bean;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.QuestionService;
import net.ninemm.survey.service.model.Question;
import io.jboot.service.JbootServiceBase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Bean
public class QuestionServiceImpl extends JbootServiceBase<Question> implements QuestionService {

    @Override
    /** 
    * @Description:  
    * @Param: [surveyId] 
    * @return: void 
    * @Author: lsy 
    * @Date: 2019/3/11 
    */
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete from survey_question where survey_id=?";
        Db.delete(sql,surveyId);
    }

    @Override
    public List<Question> findBySurveyId(String surveyId) {
        String sql="select * from survey_question where survey_id=? order by question_index";
        return DAO.find(sql,surveyId);
    }

    @Override
    public Boolean saveQuestions(List<Question> questionsList, String surveyId) {
        for (Question question : questionsList) {
            question.setId(StrUtil.uuid());
            question.setSurveyId(surveyId);
            question.setCreateDate(new Date());
        }
        boolean res = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                int[] ints = Db.batchSave(questionsList, questionsList.size());
                if(Arrays.asList(ints).contains(0)){
                    return false;
                }
                return true;
            }
        });

        return res;
    }

    @Override
    public Boolean saveQuestion(JSONArray pages, String surveyId) {
        List<Question> questionsList = new ArrayList<Question>();
        int i=0;
        for (Object page : pages) {
            JSONObject jo = JSONObject.parseObject(page.toString());
            String pageName = jo.getString("name");
            JSONArray elements = jo.getJSONArray("elements");
            for (Object element : elements) {
                i=i+1;
                JSONObject ejo = JSONObject.parseObject(element.toString());
                String questionId = StrUtil.uuid();
                String questionType = ejo.getString("type");
                if(questionType.equals("panel")){
                    JSONArray els = ejo.getJSONArray("elements");
                    JSONArray newEls = new JSONArray();
                    for (int j=els.size()-1; j>=0 ; j--) {
                        JSONObject el = JSONObject.parseObject(els.get(j).toString());
                        el.put("question_id",questionId);
                        el.put("question_index",i);
                        newEls.add(el);
                    }
                    ejo.put("elements",newEls);
                }else{
                    ejo.put("question_id",questionId);
                    ejo.put("question_index",i);
                }
                Question question = new Question();
                question.setId(questionId);
                question.setQuestionName(ejo.getString("name"));
                question.setQuestionTitle(StrUtil.isNotEmpty(ejo.getString("title"))?ejo.getString("title"):ejo.getString("name"));
                question.setSurveyId(surveyId);
                question.setPageName(pageName);
                question.setQuestionIndex(i);
                question.setQuestionInfo(ejo.toString());
                question.setType(questionType);
                question.setCreateDate(new Date());
                questionsList.add(question);
            }
        }
        boolean res = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                String sql ="delete from survey_question where survey_id= ?";
                Db.delete(sql,surveyId);
                int[] ints = Db.batchSave(questionsList, questionsList.size());
                if(Arrays.asList(ints).contains(0)){
                    return false;
                }
                return true;
            }
        });

        return res;
    }
}
