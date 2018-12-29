package net.ninemm.upms.service.model;

import io.jboot.db.annotation.Table;
import net.ninemm.upms.service.model.base.BaseStation;

/**
 * Generated by Jboot.
 * @author eric
 */
@Table(tableName = "upms_station", primaryKey = "id")
public class Station extends BaseStation<Station> {

    public static final String CACHE_NAME = "upms_station";
}
