package net.ninemm.upms.service.model;

import io.jboot.db.annotation.Table;
import net.ninemm.upms.service.model.base.BaseRole;

/**
 * Generated by Jboot.
 */
@Table(tableName = "upms_role", primaryKey = "id")
public class Role extends BaseRole<Role> {

    public static final String CACHE_NAME = "upms_role";
}
