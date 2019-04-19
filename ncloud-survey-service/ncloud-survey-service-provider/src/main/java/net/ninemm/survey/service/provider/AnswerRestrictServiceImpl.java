package net.ninemm.survey.service.provider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.service.JbootServiceBase;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.AnswerRestrictService;
import net.ninemm.survey.service.model.AnswerRestrict;
import net.ninemm.survey.service.model.ConsumerAttrCondition;
import net.ninemm.survey.service.model.FrequencyCondition;
import net.ninemm.survey.service.model.TimeCondition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Bean
public class AnswerRestrictServiceImpl extends JbootServiceBase<AnswerRestrict> implements AnswerRestrictService {
    @Override
    public boolean deleteBySurveyId(String surveyId) {
        boolean res = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                AnswerRestrict answerRestrict = findBySurveyId(surveyId);
                String sqlTimeCondition = "DELETE from survey_time_condition where answer_restrict_id=?";
                Db.delete(sqlTimeCondition, answerRestrict.getId());
                String sqlFrequencyCondition = "DELETE from frequency_condition where answer_restrict_id=?";
                Db.delete(sqlFrequencyCondition, answerRestrict.getId());
                String sqlConsumerCondition = "DELETE from consumer_attr_condition where answer_restrict_id=?";
                Db.delete(sqlConsumerCondition, answerRestrict.getId());
                DAO.deleteById(answerRestrict.getId());
                return true;
            }
        });
        return res;
    }

    @Override
    public Boolean saveAnswerLimit(AnswerRestrict answerRestrict, JSONObject rawObject, String deptId, String dataArea) {
        boolean res = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                answerRestrict.setDeptId(deptId);
                answerRestrict.setDataArea(dataArea);
                saveOrUpdate(answerRestrict);

                String answerRestrictId = answerRestrict.getId();

                String timeLimit = rawObject.getString("timeLimit");
                if(StrUtil.isNotEmpty(timeLimit)){
                    List<TimeCondition> timeConditions = JSONArray.parseArray(timeLimit, TimeCondition.class);
                    List<TimeCondition> timeConditionsSave = new ArrayList<TimeCondition>();
                    List<TimeCondition> timeConditionupdate = new ArrayList<TimeCondition>();
                    for (TimeCondition timeCondition : timeConditions) {
                        timeCondition.setAnswerRestrictId(answerRestrictId);
                        timeCondition.setDataArea(dataArea);
                        timeCondition.setDeptId(deptId);
                        timeCondition.setCreateDate(new Date());
                        if(timeCondition.getId()==null){
                            timeCondition.setId(StrUtil.uuid());
                            timeConditionsSave.add(timeCondition);
                        }else{
                            timeConditionupdate.add(timeCondition);
                        }
                    }

                    int[] ints = Db.batchSave(timeConditionsSave, timeConditionsSave.size());
                    int[] ints1 = Db.batchUpdate(timeConditionupdate, timeConditionupdate.size());
                    if(ints.length<=0 && ints1.length<=0){
                        return false;
                    }
                }

                String answerLimit = rawObject.getString("answerLimit");
                if(StrUtil.isNotEmpty(answerLimit)){
                    List<FrequencyCondition> FrequencyConditions = JSONArray.parseArray(answerLimit, FrequencyCondition.class);
                    List<FrequencyCondition> FrequencyConditionSave = new ArrayList<FrequencyCondition>();
                    List<FrequencyCondition> FrequencyConditionUpdate = new ArrayList<FrequencyCondition>();
                    for (FrequencyCondition frequencyCondition : FrequencyConditions) {
                        frequencyCondition.setAnswerRestrictId(answerRestrictId);
                        frequencyCondition.setDataArea(dataArea);
                        frequencyCondition.setDeptId(deptId);
                        frequencyCondition.setCreateDate(new Date());
                        if(frequencyCondition.getId()==null){
                            frequencyCondition.setId(StrUtil.uuid());
                            FrequencyConditionSave.add(frequencyCondition);
                        }else{
                            FrequencyConditionUpdate.add(frequencyCondition);
                        }
                    }
                    int[] ints = Db.batchSave(FrequencyConditionSave,FrequencyConditionSave.size());
                    int[] ints1 = Db.batchUpdate(FrequencyConditionUpdate,FrequencyConditionUpdate.size());
                    if(ints.length<=0 && ints1.length<=0){
                        return false;
                    }
                }

                String consumerLimit = rawObject.getString("consumerLimit");
                if(StrUtil.isNotEmpty(consumerLimit)){
                    List<ConsumerAttrCondition> ConsumerAttrConditions = JSONArray.parseArray(consumerLimit, ConsumerAttrCondition.class);
                    for (ConsumerAttrCondition consumerAttrCondition : ConsumerAttrConditions) {
                        consumerAttrCondition.setId(StrUtil.uuid());
                        consumerAttrCondition.setAnswerRestrictId(answerRestrictId);
                    }
                    int[] ints = Db.batchSave(ConsumerAttrConditions,ConsumerAttrConditions.size());
                    if(ints.length<=0){
                        return false;
                    }
                }
                return true;
            }
        });
        return res;
    }

    @Override
    public AnswerRestrict findBySurveyId(String surveyId) {
        String sql ="select * from survey_answer_restrict where survey_id=?";
        return DAO.findFirst(sql,surveyId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(AnswerRestrict.CACHE_NAME);
    }
}
