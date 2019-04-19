package net.ninemm.survey.service.provider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;

import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import io.jboot.utils.StrUtil;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.Task;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;

import java.sql.SQLException;
import java.util.*;


@Bean
public class TaskServiceImpl extends JbootServiceBase<Task> implements TaskService {

	@Override
	public void deleteByProjectId(String projectId) {
		clearAllCache();
		String sql ="delete from survey_task where project_id=? ";
		Db.delete(sql,projectId);
	}
	
	@Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(Project.CACHE_NAME);
    }

    @Override
    public String saveTasks(JSONObject rawObject, Task task, UploadFile file, Kv kv) {
        boolean tx = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {
                if (!StrUtil.isNotEmpty(task.getId())) {
                    task.setId(StrUtil.uuid());
                }
                String dataArea = kv.getStr("dataArea");
                String deptId = kv.getStr("deptId");
                task.setDataArea(dataArea);
                task.setDeptId(deptId);
                task.setPublisherId(kv.getStr("userId"));
                task.setPublisherName(kv.getStr("userName"));
                task.setProjectId(StrUtil.uuid());
                task.setStage(1);
                if (!task.save()) {
                    return false;
                }
                String taskId = task.getId();
                List<TaskProcess> tpListAdd = new ArrayList<TaskProcess>();
                List<TaskProcess> tpListUpdate = new ArrayList<TaskProcess>();
                JSONArray taskAssign = rawObject.getJSONArray("taskAssign");
                for (Object o : taskAssign) {
                    TaskProcess taskProcess = new TaskProcess();
                    taskProcess.setTaskId(taskId);

                    JSONObject jo = JSONObject.parseObject(o.toString());

                    JSONObject accepter = jo.getJSONObject("accepter");
                    taskProcess.setAccepterId(accepter.getString("accepter_id"));
                    taskProcess.setAccepterName(accepter.getString("accepter_name"));

                    JSONObject tester = jo.getJSONObject("tester");
                    taskProcess.setTesterId(tester.getString("tester_id"));
                    taskProcess.setTesterName(tester.getString("tester_name"));

                    JSONObject auditer = jo.getJSONObject("auditer");
                    taskProcess.setAuditerId(auditer.getString("auditer_id"));
                    taskProcess.setAuditerName(auditer.getString("auditer_name"));

                    // types 处理阶段 1：题目制作 2：收集设置 3：问卷收集 4：数据整理
                    taskProcess.setStage(jo.getInteger("stage"));

                    //更新
                    if (StrUtil.isNotEmpty(jo.getString("id"))) {
                        tpListUpdate.add(taskProcess);
                    }else{
                        taskProcess.setId(StrUtil.uuid());
                        tpListAdd.add(taskProcess);
                    }
                    if (tpListUpdate.size()>0) {
                        int[] updates = Db.batchUpdate(tpListUpdate, tpListUpdate.size());
                        if (Arrays.asList(updates).contains(0)) {
                            return false;
                        }
                    }
                    if (tpListAdd.size()>0) {
                        int[] inserts = Db.batchSave(tpListAdd, tpListAdd.size());
                        if (Arrays.asList(inserts).contains(0)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        });
        if (!tx) {
            return null;
        }
        return task.getId();
    }

    @Override
    public Page<Record> findByUser(Integer pageNumber, Integer pageSize, String userId, String orderBy) {
        StringBuffer sqlNum =new StringBuffer();
        sqlNum.append("select count(0) from ( ")
        .append(" SELECT st.id FROM survey_task st INNER JOIN survey_task_process stp ON st.id = stp.task_id ")
        .append(" where st.publisher_id=? ")
        .append(" union ")
        .append(" SELECT st.id FROM survey_task st INNER JOIN survey_task_process stp ON st.id = stp.task_id and st.stage=stp.stage ")
        .append(" where (stp.accepter_id=? or stp.tester_id=? or stp.auditer_id=?)) a ");

	    StringBuffer sql =new StringBuffer();
        sql.append("SELECT st.*,stp.id processId,stp.accepter_id,stp.accepter_name,stp.tester_id,stp.tester_name,stp.auditer_id,stp.auditer_name,stp.stage processStage,stp.remark ")
        .append(" FROM survey_task st INNER JOIN survey_task_process stp ON st.id = stp.task_id ")
        .append(" where st.publisher_id=? ")
        .append(" union ")
        .append(" SELECT st.*,stp.id processId,stp.accepter_id,stp.accepter_name,stp.tester_id,stp.tester_name,stp.auditer_id,stp.auditer_name,stp.stage processStage,stp.remark ")
        .append(" FROM survey_task st INNER JOIN survey_task_process stp ON st.id = stp.task_id and st.stage=stp.stage ")
        .append(" where (stp.accepter_id=? or stp.tester_id=? or stp.auditer_id=? ) ");
        return Db.paginateByFullSql(pageNumber,pageSize, sqlNum.toString(), sql.toString(),userId,userId,userId,userId);
    }

}
