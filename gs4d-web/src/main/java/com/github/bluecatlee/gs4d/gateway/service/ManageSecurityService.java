package com.github.bluecatlee.gs4d.gateway.service;

import com.github.bluecatlee.gs4d.common.bean.MessagePack;
import com.github.bluecatlee.gs4d.common.bean.MethodAndRequestClass;
import com.github.bluecatlee.gs4d.gateway.bean.UserIdAndSalt;
import com.github.bluecatlee.gs4d.gateway.model.ServiceRequest;

public interface ManageSecurityService {

    /**
     * 验证前端参数并转换成服务请求参数 （登陆用）
     * @param cmd       命令名称
     * @param method    方法名称
     * @param appKey    应用秘钥 适用于多租户系统来区分租户，也可以用来区分多应用
     * @param params    请求参数(base64加密)
     * @return
     */
    //用户及密码换sid及salt或router/plain入参解析
    ServiceRequest getServiceRequestForLogin(String cmd, String method, String appKey, String params);

    /**
     * 验证前端参数并转换成服务请求参数
     * @param cmd       命令名称
     * @param method    方法名称
     * @param params    请求参数(base64加密)
     * @param timestamp 时间戳
     * @param sign      签名
     * @param sid       会话id
     * @return
     */
    ServiceRequest getServiceRequest(String cmd, String method, String params, String timestamp, String sign, String sid);

    /**
     * 根据sid获取租户、测试标识、用户编号、salt
     * @param sid 会话标识sessionId
     * @return
     */
    UserIdAndSalt getUserIdAndSaltBySid(String sid);

    /**
     * 封装请求class类和方法
     * @param clazz serviceBean的Class类型
     * @param name
     * @return
     */
    MethodAndRequestClass getMethodAndRequestClass(Class<?> clazz, String name);

    MessagePack callMethodForGateway(ServiceRequest serviceRequest);

}
