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

                String timeLimit = rawObject.get("timeLimit").toString();
                if(StrUtil.isNotEmpty(timeLimit)){
                    List<TimeCondition> timeConditions = JSONArray.parseArray(timeLimit, TimeCondition.class);
                    for (TimeCondition timeCondition : timeConditions) {
                        timeCondition.setId(StrUtil.uuid());
                        timeCondition.setAnswerRestrictId(answerRestrictId);
                        timeCondition.setDataArea(dataArea);
                        timeCondition.setDeptId(deptId);
                        timeCondition.setCreateDate(new Date());
                    }
                    int[] ints = Db.batchSave(timeConditions, timeConditions.size());
                    if(ints.length<=0){
                        return false;
                    }
                }

                String answerLimit = rawObject.get("answerLimit").toString();
                if(StrUtil.isNotEmpty(answerLimit)){
                    List<FrequencyCondition> FrequencyConditions = JSONArray.parseArray(answerLimit, FrequencyCondition.class);
                    for (FrequencyCondition frequencyCondition : FrequencyConditions) {
                        frequencyCondition.setId(StrUtil.uuid());
                        frequencyCondition.setAnswerRestrictId(answerRestrictId);
                        frequencyCondition.setDataArea(dataArea);
                        frequencyCondition.setDeptId(deptId);
                        frequencyCondition.setCreateDate(new Date());
                    }
                    int[] ints = Db.batchSave(FrequencyConditions,FrequencyConditions.size());
                    if(ints.length<=0){
                        return false;
                    }
                }

                String consumerLimit = rawObject.get("consumerLimit").toString();
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