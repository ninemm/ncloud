package net.ninemm.upms.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDepartment<M extends BaseDepartment<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setDeptName(java.lang.String deptName) {
		set("dept_name", deptName);
	}
	
	public java.lang.String getDeptName() {
		return getStr("dept_name");
	}

	public void setDeptLevel(java.lang.Integer deptLevel) {
		set("dept_level", deptLevel);
	}
	
	public java.lang.Integer getDeptLevel() {
		return getInt("dept_level");
	}

	public void setDataArea(java.lang.String dataArea) {
		set("data_area", dataArea);
	}
	
	public java.lang.String getDataArea() {
		return getStr("data_area");
	}

	public void setParentId(java.lang.String parentId) {
		set("parent_id", parentId);
	}
	
	public java.lang.String getParentId() {
		return getStr("parent_id");
	}

	public void setIsParent(java.lang.Integer isParent) {
		set("is_parent", isParent);
	}
	
	public java.lang.Integer getIsParent() {
		return getInt("is_parent");
	}

	public void setOrderReviewerId(java.lang.String orderReviewerId) {
		set("order_reviewer_id", orderReviewerId);
	}
	
	public java.lang.String getOrderReviewerId() {
		return getStr("order_reviewer_id");
	}

	public void setPrincipalUserId(java.lang.String principalUserId) {
		set("principal_user_id", principalUserId);
	}
	
	public java.lang.String getPrincipalUserId() {
		return getStr("principal_user_id");
	}

	public void setChildIds(java.lang.String childIds) {
		set("child_ids", childIds);
	}
	
	public java.lang.String getChildIds() {
		return getStr("child_ids");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	public java.lang.String getDescription() {
		return getStr("description");
	}

	public void setOrderList(java.lang.Integer orderList) {
		set("order_list", orderList);
	}
	
	public java.lang.Integer getOrderList() {
		return getInt("order_list");
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