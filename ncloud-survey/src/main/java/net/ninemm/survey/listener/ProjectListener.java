package net.ninemm.survey.listener;

import cn.jpush.api.report.UsersResult;
import io.jboot.components.event.JbootEvent;
import io.jboot.components.event.JbootEventListener;
import io.jboot.components.event.annotation.EventConfig;
import net.ninemm.base.message.MessageAction;

/**
 * @author: lsy
 * @create: 2019-03-01 18:57
 **/
@EventConfig(action = {MessageAction.PROJECT_MANAGE_ADD,MessageAction.PROJECT_MANAGE_DEL})
public class ProjectListener implements JbootEventListener {
    @Override
    public void onEvent(JbootEvent event) {
        if(event.getAction().equals(MessageAction.PROJECT_MANAGE_ADD)){
            Object data = event.getData();
            System.out.println(data);
        }else if(event.getAction().equals(MessageAction.PROJECT_MANAGE_DEL)){

        }
    }
}
