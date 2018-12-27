#sql("findByUserId")
select
  r.*
from `role` r
left join `group_role_rel` gr on gr.role_id = r.id
where gr.group_id in (SELECT ug.group_id FROM user_group_rel ug where ug.user_id = ?)
#end