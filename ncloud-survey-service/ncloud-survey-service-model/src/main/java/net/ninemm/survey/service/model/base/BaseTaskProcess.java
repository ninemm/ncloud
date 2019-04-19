package net.ninemm.survey.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTaskProcess<M extends BaseTaskProcess<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setTaskId(java.lang.String taskId) {
		set("task_id", taskId);
	}
	
	public java.lang.String getTaskId() {
		return getStr("task_id");
	}

	public void setAccepterId(java.lang.String accepterId) {
		set("accepter_id", accepterId);
	}
	
	public java.lang.String getAccepterId() {
		return getStr("accepter_id");
	}

	public void setAccepterName(java.lang.String accepterName) {
		set("accepter_name", accepterName);
	}
	
	public java.lang.String getAccepterName() {
		return getStr("accepter_name");
	}

	public void setTesterId(java.lang.String testerId) {
		set("tester_id", testerId);
	}
	
	public java.lang.String getTesterId() {
		return getStr("tester_id");
	}

	public void setTesterName(java.lang.String testerName) {
		set("tester_name", testerName);
	}
	
	public java.lang.String getTesterName() {
		return getStr("tester_name");
	}

	public void setAuditerId(java.lang.String auditerId) {
		set("auditer_id", auditerId);
	}
	
	public java.lang.String getAuditerId() {
		return getStr("auditer_id");
	}

	public void setAuditerName(java.lang.String auditerName) {
		set("auditer_name", auditerName);
	}
	
	public java.lang.String getAuditerName() {
		return getStr("auditer_name");
	}

	public void setStage(java.lang.Integer stage) {
		set("stage", stage);
	}
	
	public java.lang.Integer getStage() {
		return getInt("stage");
	}

	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	public void setDeptId(java.lang.String deptId) {
		set("dept_id", deptId);
	}
	
	public java.lang.String getDeptId() {
		return getStr("dept_id");
	}

	public void setDataArea(java.lang.String dataArea) {
		set("data_area", dataArea);
	}
	
	public java.lang.String getDataArea() {
		return getStr("data_area");
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
