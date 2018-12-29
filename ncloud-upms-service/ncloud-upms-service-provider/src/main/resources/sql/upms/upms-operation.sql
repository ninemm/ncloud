#sql("findOperationPermsByUserId")
select
  o.url
from `role_operation_rel` r
left join `operation` o on r.operation_id = o.id where r.role_id in
  (SELECT gr.role_id FROM group_role_rel gr where gr.group_id in
    (SELECT ug.group_id FROM user_group_rel ug where ug.user_id = ?)
  )
UNION ALL
select o.url from `station_operation_rel` r
left join `operation` o on r.operation_id = o.id
WHERE LOCATE(?, r.station_id) > 0
#end

#sql("findOperationPermissionByUserId")
  SELECT o.url
  FROM `upms_role_operation_rel` ro
  LEFT JOIN `upms_operation` o ON ro.operation_id = o.id
  WHERE LOCATE(#para(roleIds), ro.role_id) > 0
  #if(stationIds)
  UNION
  SELECT o.url
  FROM `upms_station_operation_rel` s
  LEFT JOIN `upms_operation` o ON s.operation_id = o.id
  WHERE LOCATE(#para(stationIds), s.station_id) > 0
  #end
#end
