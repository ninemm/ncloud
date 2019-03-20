package net.ninemm.survey.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseQuestionAttr<M extends BaseQuestionAttr<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setSurveyId(java.lang.String surveyId) {
		set("survey_id", surveyId);
	}
	
	public java.lang.String getSurveyId() {
		return getStr("survey_id");
	}

	public void setSurveyQuestionId(java.lang.String surveyQuestionId) {
		set("survey_question_id", surveyQuestionId);
	}
	
	public java.lang.String getSurveyQuestionId() {
		return getStr("survey_question_id");
	}

	public void setIsShowBarchart(java.lang.Integer isShowBarchart) {
		set("is_show_barchart", isShowBarchart);
	}
	
	public java.lang.Integer getIsShowBarchart() {
		return getInt("is_show_barchart");
	}

	public void setIsShowVoteNum(java.lang.Integer isShowVoteNum) {
		set("is_show_vote_num", isShowVoteNum);
	}
	
	public java.lang.Integer getIsShowVoteNum() {
		return getInt("is_show_vote_num");
	}

	public void setIsShowPercentage(java.lang.Integer isShowPercentage) {
		set("is_show_percentage", isShowPercentage);
	}
	
	public java.lang.Integer getIsShowPercentage() {
		return getInt("is_show_percentage");
	}

	public void setMaxStayTime(java.lang.Integer maxStayTime) {
		set("max_stay_time", maxStayTime);
	}
	
	public java.lang.Integer getMaxStayTime() {
		return getInt("max_stay_time");
	}

	public void setMinStayTime(java.lang.Integer minStayTime) {
		set("min_stay_time", minStayTime);
	}
	
	public java.lang.Integer getMinStayTime() {
		return getInt("min_stay_time");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}
	
	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public void setModifyDate(java.util.Date modifyDate) {
		set("modify_date", modifyDate);
	}
	
	public java.util.Date getModifyDate() {
		return get("modify_date");
	}

}