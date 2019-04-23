package net.ninemm.upms.service.model.base;

import com.jfinal.plugin.activerecord.IBean;
import io.jboot.db.model.JbootModel;

public class BaseSeller<M extends BaseSeller<M>> extends JbootModel<M> implements IBean {

    public void setId(java.lang.String id) {
        set("id", id);
    }

    public java.lang.String getId() {
        return getStr("id");
    }

    public void setDeptId(java.lang.String deptId) {
        set("dept_id", deptId);
    }

    public java.lang.String getDeptId() {
        return getStr("dept_id");
    }

    public void setDeptName(java.lang.String deptName) {
        set("dept_name", deptName);
    }

    public java.lang.String getDeptName() {
        return getStr("dept_name");
    }

    public void setSellerName(java.lang.String sellerName) {
        set("seller_name", sellerName);
    }

    public java.lang.String getSellerName() {
        return getStr("seller_name");
    }

    public void setsellerType(java.lang.String sellerType) {
        set("seller_type", sellerType);
    }

    public java.lang.String getsellerType() {
        return getStr("seller_type");
    }

    public void setContact(java.lang.String contact) {
        set("contact", contact);
    }

    public java.lang.String getContact() {
        return getStr("contact");
    }

    public void setPhone(java.lang.String phone) {
        set("phone", phone);
    }

    public java.lang.String getPhone() {
        return getStr("phone");
    }

    public void setDomainName(java.lang.String domainName) {
        set("domain_name", domainName);
    }

    public java.lang.String getDomainName() {
        return getStr("domain_name");
    }

    public void setIsEnabled(java.lang.Integer isEnabled) {
        set("is_enabled", isEnabled);
    }

    public java.lang.Integer getIsEnabled() {
        return getInt("is_enabled");
    }

    public void setIsVerify(java.lang.Integer isVerify) {
        set("is_verify", isVerify);
    }

    public java.lang.Integer getIsVerify() {
        return getInt("is_verify");
    }

    public void setRemark(java.lang.String remark) {
        set("remark", remark);
    }

    public java.lang.String getRemark() {
        return getStr("remark");
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

    public void setSellerNumber(java.lang.String sellerNumber) {
        set("seller_number", sellerNumber);
    }

    public java.lang.String getSellerNumber() {
        return getStr("seller_number");
    }

    public void setSellerPassword(java.lang.String sellerPassword) {
        set("seller_password", sellerPassword);
    }

    public java.lang.String getSellerPassword() {
        return getStr("seller_password");
    }

    public void setSellerId(java.lang.String sellerId) {
        set("seller_id", sellerId);
    }

    public java.lang.String getSellerId() {
        return getStr("seller_id");
    }
}
