package net.ninemm.survey.controller.survey;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.ImmutableBiMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.db.model.Columns;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import io.swagger.annotations.Api;
import net.ninemm.base.interceptor.NotNullPara;
import net.ninemm.survey.controller.BaseAppController;
import net.ninemm.survey.service.model.Category;
import net.ninemm.survey.service.api.CategoryService;
import net.ninemm.upms.service.api.UserService;
import net.ninemm.upms.service.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @Description
 * @author lsy
 * @version V1.0
 * @Date 2019-04-16 17:29:52
 */
@RequestMapping(value = "/category")
@Api(description = "", basePath = "/category", tags = "", position = 0)
@EnableCORS
public class CategoryController extends BaseAppController {
    @Inject
    private CategoryService categoryService;
    @Inject
    UserService userService;

    public void index() {
        String userId = getUserId();
        Columns columns = Columns.create("user_id", userId);
        Page<Category> page= categoryService.paginateByColumns(getPageNumber(), getPageSize(), columns);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    @NotNullPara(value = "id")
    public void findById() {
        Category category  = categoryService.findById(getPara("id"));
        renderJson(category);
    }

    public void findAll() {
        List<Category> categoryList = categoryService.findAll();
        renderJson(categoryList);
    }

    public void findByColum() {
        JSONObject rawObject = getRawObject();

        Columns columns = Columns.create();
        columns.eq("", rawObject.get(""));
        columns.likeAppendPercent("", rawObject.get(""));
        columns.like("data_area",rawObject.get("dataArea"));
        columns.ge("create_date",rawObject.get("startDate"));
        columns.le("create_date",rawObject.get("endDate"));

        String orderBy = rawObject.getString("orderBy");
        if(StrUtil.isBlank(orderBy)){
            orderBy=" create_date desc ";
        }
        Page<Category> page = categoryService.paginateByColumns(getPageNumber(), getPageSize(), columns, orderBy);
        Map<String, Object> map = ImmutableBiMap.of("total", page.getTotalRow(), "records", page.getList());
        renderJson(Ret.ok("result",map));
    }

    public void saveOrUpdate() {
        Category category = getRawObject(Category.class);
        String userId = getUserId();
        User user = userService.findById(userId);
        if (StrUtil.isBlank(category.getId())) {
            category.setCreaterId(userId);
            category.setCreaterName(user.getRealname());
            category.setCreateDate(new Date());
            category.setDataArea(user.getDataArea());
        }else{
            category.setModifyDate(new Date());
            category.setModifyUserId(userId);
            category.setModifyUserName(user.getRealname());
        }
        categoryService.saveOrUpdate(category);
        renderJson(Ret.ok().set("id", category.getId()));
    }

    @NotNullPara(value = "id")
    public void delete() {
        if(categoryService.deleteById(getPara("id"))){
            renderJson(Ret.ok());
            return ;
        }else{
            renderJson(Ret.fail());
        }
    }

    public void findByDataArea(){
        String userId = getUserId();
        User user = userService.findById(userId);
        List<Category>  categoryList = categoryService.findByDataArea(user.getDataArea());
        renderJson(Ret.ok("result",categoryList));
    }

    @NotNullPara(value = "surveyId")
    public void findBySurveyId(){
        /*WxRedpackConfig wxRedpackConfig = wxRedpackConfigService.findBySurveyId(getPara("surveyId"));
        renderJson(Ret.ok("result",wxRedpackConfig));*/
    }
}
