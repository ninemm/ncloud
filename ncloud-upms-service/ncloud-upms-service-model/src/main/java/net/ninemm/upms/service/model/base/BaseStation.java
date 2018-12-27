package net.ninemm.upms.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStation<M extends BaseStation<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setStationName(java.lang.String stationName) {
		set("station_name", stationName);
	}
	
	public java.lang.String getStationName() {
		return getStr("station_name");
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

	public void setOrderList(java.lang.Integer orderList) {
		set("order_list", orderList);
	}
	
	public java.lang.Integer getOrderList() {
		return getInt("order_list");
	}

	public void setDescription(java.lang.String description) {
		set("description", description);
	}
	
	public java.lang.String getDescription() {
		return getStr("description");
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
