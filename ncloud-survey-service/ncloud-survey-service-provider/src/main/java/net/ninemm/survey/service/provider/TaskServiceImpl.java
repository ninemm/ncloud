package net.ninemm.survey.service.provider;

import com.jfinal.plugin.activerecord.Db;

import io.jboot.Jboot;
import io.jboot.aop.annotation.Bean;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.Task;
import io.jboot.service.JbootServiceBase;


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

}