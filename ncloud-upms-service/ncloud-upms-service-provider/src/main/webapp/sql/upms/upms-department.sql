#sql("findAllParentDeptByDeptId")
SELECT
  d2.id, d2.dept_name, d2.dept_level, d2.parent_id, d2.data_area
FROM (
  SELECT @r as _id, (SELECT @r := parent_id FROM upms_department WHERE id = _id) AS p_id, @l := @l + 1 AS lvl
  FROM (SELECT @r := #para(0), @l := 0) vars, upms_department h
  WHERE @r > '0'
) d1
JOIN upms_department d2 ON d1._id = d2.id
ORDER BY d2.dept_level desc
#end

