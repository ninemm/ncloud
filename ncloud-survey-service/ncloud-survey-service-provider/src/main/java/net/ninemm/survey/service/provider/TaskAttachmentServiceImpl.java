package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;
import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskAttachmentService;
import net.ninemm.survey.service.model.TaskAttachment;
import io.jboot.service.JbootServiceBase;
import net.ninemm.survey.service.model.TaskProcess;


@Bean
public class TaskAttachmentServiceImpl extends JbootServiceBase<TaskAttachment> implements TaskAttachmentService {

    @Override
    public void deleteByTaskId(String taskId) {
        String sql ="delete from survey_task_attachment where task_id=?";
        Db.delete(sql,taskId);
    }

    @Override
    public void clearAllCache() {
        Jboot.getCache().removeAll(TaskAttachment.CACHE_NAME);
    }
}