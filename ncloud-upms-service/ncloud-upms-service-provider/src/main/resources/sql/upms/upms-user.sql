#sql("findUserList")
select
  u.id, u.realname
FROM `user` u
WHERE 1 = 1
  #if(userId) AND u.id = #para(userId) #end
  #if(dataArea) AND u.data_area LIKE #para(dataArea) #end
#end