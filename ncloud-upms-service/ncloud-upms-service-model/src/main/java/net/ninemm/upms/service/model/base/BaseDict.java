package net.ninemm.upms.service.model.base;

import io.jboot.db.model.JbootModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by Jboot, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDict<M extends BaseDict<M>> extends JbootModel<M> implements IBean {

	public void setId(java.math.BigInteger id) {
		set("id", id);
	}
	
	public java.math.BigInteger getId() {
		return get("id");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}

	public void setIcon(java.lang.String icon) {
		set("icon", icon);
	}
	
	public java.lang.String getIcon() {
		return getStr("icon");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}
	
	public java.lang.String getType() {
		return getStr("type");
	}

	public void setKey(java.lang.String key) {
		set("key", key);
	}
	
	public java.lang.String getKey() {
		return getStr("key");
	}

	public void setValue(java.lang.String value) {
		set("value", value);
	}
	
	public java.lang.String getValue() {
		return getStr("value");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}
	
	public java.util.Date getCreateDate() {
		return get("create_date");
	}

}
