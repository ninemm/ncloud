#sql("findAllParentDeptByCurDeptId")
SELECT
  d2.id, d2.dept_name, d2.dept_level, d2.parent_id, d2.data_area, s.id as seller_id,
  s.seller_name, s.seller_code, s.has_store, s.seller_type
FROM (
  SELECT @r as _id, (SELECT @r := parent_id FROM department WHERE id = _id) AS p_id, @l := @l + 1 AS lvl
  FROM (SELECT @r := ?, @l := 0) vars, department h
  WHERE @r > '0'
) d1
JOIN department d2 ON d1._id = d2.id
JOIN cc_seller s on d2.id = s.dept_id
ORDER BY d2.dept_level desc
#end