#sql("findOperationPermsByStationId")
SELECT
	so.operation_id, o.operation_name, o.url
FROM upms_station_operation_rel so
LEFT JOIN upms_operation o ON o.id = so.operation_id
WHERE so.station_id = #para(stationId)
#end