package net.ninemm.upms.controller;

import com.google.common.collect.ImmutableMap;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;
import io.jboot.utils.StrUtil;
import io.jboot.web.controller.annotation.RequestMapping;
import io.jboot.web.cors.EnableCORS;
import net.ninemm.upms.service.api.DepartmentService;
import net.ninemm.upms.service.api.SellerService;
import net.ninemm.upms.service.model.Department;
import net.ninemm.upms.service.model.Seller;

import java.util.HashMap;
import java.util.Map;

/**
 * 账套设置
 *
 * @author yuanzhi
 * @date 2019-4-23 16:58
 **/

@RequestMapping(value = "/api/v1/admin/seller")
@EnableCORS(allowOrigin = "*", allowHeaders = "Content-Type,Jwt", allowMethods = "POST,OPTIONS,GET,PUT,DELETE", allowCredentials = "true")
public class SellerController extends BaseAppController {

    @Inject
    SellerService sellerService;

    @Inject
    DepartmentService departmentService;

    public void list() {
        String userId = getUserId();
        Department department = departmentService.findByUserId(userId);
        Map<String, Object> params = getAllParaMap();
        params.put("deptId",department.getId());
        Page<Seller> page = sellerService.paginate(getPageNumber(), getPageSize(), params);
        Map<String, Object> mapPage = ImmutableMap.of("total", page.getTotalRow(), "records", page.getList());
        Map<String, Object> map = new HashMap<>();
        map.put("state","ok");
        map.put("result",mapPage);
        renderJson(map);
    }

    public void delete(){
        String id = getPara(0);
        if (StrKit.isBlank(id)) {
            renderJson(Ret.fail());
            return;
        }
        sellerService.deleteById(id);
        renderJson(Ret.ok());
    }

    /**
     * @Description:  关闭与开启验证
     * @Param: String
     * @return: void
     * @Author: yz
     * @Date: 2019/4/18
     */
    public void employ(){
        String id = getPara(0);
        Seller seller = sellerService.findById(id);
        if (seller.getIsVerify()==1){
            seller.setIsVerify(0);
        }else{
            seller.setIsVerify(1);
        }
        sellerService.update(seller);
        renderJson(Ret.ok());
    }

    public void save(){
        Seller seller = getRawObject(Seller.class);
        if (StrKit.notBlank(seller.getId())){
            sellerService.update(seller);
            renderJson(Ret.ok());
            return;
        }
        seller.setId(StrUtil.uuid());
        sellerService.save(seller);
        renderJson(Ret.ok());
    }

}
