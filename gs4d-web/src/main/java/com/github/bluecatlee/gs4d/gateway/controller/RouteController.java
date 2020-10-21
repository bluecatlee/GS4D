package com.github.bluecatlee.gs4d.gateway.controller;

import com.github.bluecatlee.gs4d.common.bean.MessagePack;
import com.github.bluecatlee.gs4d.gateway.model.ServiceRequest;
import com.github.bluecatlee.gs4d.gateway.service.ManageSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 路由控制器
 */
@Controller
public class RouteController {

    private static final Logger log = LoggerFactory.getLogger(RouteController.class);

    // 登陆方法名
    private static final String loginMethod1 = "manage.username.password.login";

    private List<String> whiteList;

    public List<String> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }

    @Resource
    private ManageSecurityService manageSecurityService;

    @RequestMapping(
            value = {"/gateway"},
            method = {RequestMethod.POST, RequestMethod.GET},
            produces = {"application/json;charset=UTF-8"}
    )
    public ResponseEntity gateway(@RequestParam(value = "cmd",required = false) String cmd,
                                  @RequestParam(value = "method",required = false) String method,
                                  @RequestParam(value = "app_key",required = false) String appKey,
                                  @RequestParam(value = "sign",required = false) String sign,
                                  @RequestParam(value = "timestamp",required = false) String timestamp,
                                  @RequestParam(value = "params",required = false) String params,
                                  @RequestParam(value = "sid",required = false) String sid) {

        ServiceRequest serviceRequest = new ServiceRequest();
        MessagePack messagePack = null;

        // 登陆请求
        if (loginMethod1.equals(method)) {
            serviceRequest = this.manageSecurityService.getServiceRequestForLogin((String)null, method, appKey, params);
//            messagePack = this.manageSecurityService.callMethodForGateway(serviceRequest);
        } else {
            // 其他请求
            serviceRequest = this.manageSecurityService.getServiceRequest(cmd, method, params, timestamp, sign, sid);
            messagePack = this.manageSecurityService.callMethodForGateway(serviceRequest);
        }

        // todo

        return null;
    }

}
