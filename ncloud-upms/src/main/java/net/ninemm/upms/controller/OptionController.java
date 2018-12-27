package net.ninemm.upms.controller;

import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;

/**
 * 配置管理
 *
 * @author Eric.Huang
 * @date 2018-12-10 10:16
 **/

@RequestMapping(value = "/api/v1/admin/option")
@EnableCORS(allowOrigin = "http://localhost:8080", allowHeaders = "Content-Type,Jwt", allowCredentials = "true")
public class OptionController extends BaseAppController {

    public void list() {}

    public void findById() {}

    public void save() {}

    public void update() {}

    public void delete() {}
}
