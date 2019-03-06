package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskProcessService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.TaskProcess;
import io.jboot.service.JbootServiceBase;


@Bean
public class TaskProcessServiceImpl extends JbootServiceBase<TaskProcess> implements TaskProcessService {

    @Override
    public void deleteByTaskId(String taskId) {
        String sql ="delete from survey_task_process where task_id=?";
        Db.delete(sql,taskId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(TaskProcess.CACHE_NAME);
    }
}