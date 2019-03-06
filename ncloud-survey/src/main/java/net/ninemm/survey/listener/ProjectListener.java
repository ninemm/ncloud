package net.ninemm.survey.listener;

import com.jfinal.aop.Inject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import io.jboot.components.event.JbootEvent;
import io.jboot.components.event.JbootEventListener;
import io.jboot.components.event.annotation.EventConfig;
import net.ninemm.base.message.MessageAction;
import net.ninemm.survey.service.api.TaskService;
import net.ninemm.survey.service.model.Project;
import net.ninemm.survey.service.model.Task;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author: lsy
 * @create: 2019-03-01 18:57
 **/
@EventConfig(action = {MessageAction.Task.PROJECT_MANAGE_ADD,MessageAction.Task.PROJECT_MANAGE_DEL})
public class ProjectListener implements JbootEventListener {
	@Inject
    private TaskService taskService;
	
	@Override
    public void onEvent(JbootEvent event) {
    	Object data = event.getData();
    	if(data!=null && (data instanceof Project)){
    		Project project = (Project) data;
    		if(event.getAction().equals(MessageAction.Task.PROJECT_MANAGE_ADD)){
        		String createrId = project.getCreaterId();
        		String name = project.getRealname();
        		Task task =new Task();
                task.setProjectId(project.getId());
                task.setDeptId(project.getDeptId());
                task.setDataArea(project.getDataArea());
                task.setPublisherId(createrId);
                task.setPublisherName(name);
                task.setViewerId(createrId);
                task.setViewerName(name);
                task.setReviewerId(createrId);
                task.setReviewerName(name);
                task.setAccepterId(createrId);
                task.setAccepterName(name);
                task.setModifyDate(new Date());
                task.setAcceptTime(new Date());
                
                task.setTitle(project.getProjectName());
                task.setStatus(1);
                task.setType(2);
                taskService.save(task);
	        }else if(event.getAction().equals(MessageAction.Task.PROJECT_MANAGE_DEL)){
	        	String projectId = project.getId();
	        	Db.tx(new IAtom() {
					@Override
					public boolean run() throws SQLException {
			        	taskService.deleteByProjectId(projectId);
						return true;
					}
				});

	        }
    	}	
    }
}
