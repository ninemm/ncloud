package net.ninemm.upms.interceptor;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import io.jboot.utils.CookieUtil;
import io.jboot.utils.RequestUtil;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.JbootController;
import net.ninemm.base.common.Consts;
import net.ninemm.upms.service.api.SystemLogService;
import net.ninemm.upms.service.model.SystemLog;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志监听器
 *
 * @author Eric.Huang
 * @date 2018-12-10 00:31
 **/

public class LogInterceptor implements Interceptor {

    @Inject
    SystemLogService systemLogService;

    @Override
    public void intercept(Invocation inv) {

        Controller controller = inv.getController();
        HttpServletRequest request = controller.getRequest();

        String method = request.getMethod().toLowerCase();
        if (method.equals(Consts.FILTER_OPTIONS_METHOD)) {
            inv.getController().renderJson(Ret.ok());
            return;
        }

        SystemLog log = new SystemLog();
        log.setId(StrUtil.uuid());
        log.setIp(RequestUtil.getIpAddress(controller.getRequest()));
        log.setAccept(controller.getRequest().getRequestURI());
        log.setReferer(RequestUtil.getReferer(controller.getRequest()));

        log.setMethod(request.getMethod());
        log.setCookie(request.getHeader("Cookie"));
        log.setHost(request.getHeader("Host"));
        log.setUserAgent(request.getHeader("User-Agent"));

        log.setConnection(request.getHeader("Connection"));
        log.setAcceptLang(request.getHeader("Accept-Language"));
        log.setAcceptEncoding(request.getHeader("Accept-Encoding"));
        log.setXrequestedwith(request.getHeader("X-Requested-With"));

        String uid = CookieUtil.get(controller, Consts.COOKIE_USER_ID);
        if (StrKit.notBlank(uid)) {
            log.setUserId(uid);
        } else if (controller instanceof JbootController) {
            JbootController c = (JbootController) controller;
            String userId = c.getJwtAttr(Consts.JWT_USER_ID);
            if (StrKit.notBlank(userId)) {
                log.setUserId(userId);
            }
        }

        systemLogService.save(log);

        inv.invoke();
    }
}
