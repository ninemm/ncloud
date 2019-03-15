package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.QuestionAttrService;
import net.ninemm.survey.service.model.QuestionAttr;
import io.jboot.service.JbootServiceBase;

import java.util.List;


@Bean
public class QuestionAttrServiceImpl extends JbootServiceBase<QuestionAttr> implements QuestionAttrService {

    @Override
    public List<QuestionAttr> findByQurstionId(String qurstionId) {
        String sql ="select * from survey_question_attr where survey_question_id=?";
        return DAO.find(sql,qurstionId);
    }

    @Override
    public void deleteByQuestionId(String questionId) {
        String sql ="delete from survey_question_attr where survey_question_id= ?";
        Db.delete(sql,questionId);
    }

    @Override
    public List<QuestionAttr> findBySurveyId(String surveyId) {
        String sql ="select * from survey_question_attr where survey_id=?";
        return DAO.find(sql,surveyId);
    }

    @Override
    public void deleteBySurveyId(String surveyId) {
        String sql ="delete from survey_question_attr where survey_id= ?";
        Db.delete(sql,surveyId);
    }
}