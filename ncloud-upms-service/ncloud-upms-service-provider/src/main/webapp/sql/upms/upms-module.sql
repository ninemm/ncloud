#sql("pagination")
SELECT
	m.id, s.`name` as system_name, pm.module_name as parent_module_name, m.module_name, m.module_code,
	m.parent_id, m.system_id, m.order_list, m.create_date
FROM upms_module m
LEFT JOIN upms_systems s on s.id = m.system_id
LEFT JOIN upms_module pm on m.parent_id = pm.id
WHERE m.parent_id IS NOT NULL
#if(systemId)AND m.system_id = #para(systemId) #end
#if(moduleName)AND m.module_name LIKE concat('%', #para(moduleName), '%') #end
ORDER BY s.`name` asc, m.order_list ASC
#end