package net.ninemm.upms.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseGroupRoleRel<M extends BaseGroupRoleRel<M>> extends JbootModel<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}

	public void setGroupId(java.lang.String groupId) {
		set("group_id", groupId);
	}
	
	public java.lang.String getGroupId() {
		return getStr("group_id");
	}

	public void setRoleId(java.lang.String roleId) {
		set("role_id", roleId);
	}
	
	public java.lang.String getRoleId() {
		return getStr("role_id");
	}

}
