package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import io.jboot.aop.annotation.Bean;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.QuestionService;
import net.ninemm.survey.service.model.Question;
import io.jboot.service.JbootServiceBase;

import java.sql.SQLException;
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
        String sql="select * from survey_question where survey_id=?";
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
}