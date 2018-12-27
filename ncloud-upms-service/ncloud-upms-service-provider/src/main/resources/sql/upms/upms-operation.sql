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