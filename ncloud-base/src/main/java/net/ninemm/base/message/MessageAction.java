package net.ninemm.base.message;

/**
 * @author: lsy
 * @create: 2019-03-01 19:06
 **/
public class MessageAction {

    public class Task {
        public static final String PROJECT_MANAGE_ADD = "project_manage:add";
        public static final String PROJECT_MANAGE_DEL = "project_manage:del";
    }

    public class Survey{
        public static final String SURVEY_DEL = "survey:del";
        public static final String SURVEY_ANSWER_RESTRICT_DEL = "survey_answer_restrict:del";
    }

    public class SendSurvey{
        public static final String SURVEY_SEND = "survey:send";
        public static final int MOBILE=3;
        public static final int WEIXIN=2;
        public static final int EMAIL=1;
    }

}
