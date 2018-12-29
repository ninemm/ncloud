#sql("findByUserId")
select
  r.*
from `role` r
left join `group_role_rel` gr on gr.role_id = r.id
where gr.group_id in (SELECT ug.group_id FROM user_group_rel ug where ug.user_id = ?)
#end

#sql("findAllRoleCodeByUserId")
SELECT
	r.id, r.role_code
FROM upms_user_group_rel ugl
LEFT JOIN upms_group_role_rel grr ON grr.group_id = ugl.group_id
LEFT JOIN upms_role r ON r.id = grr.role_id
WHERE ugl.user_id = ?
#end