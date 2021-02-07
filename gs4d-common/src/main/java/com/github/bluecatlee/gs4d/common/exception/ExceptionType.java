package com.github.bluecatlee.gs4d.common.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ExceptionType {
    VCE10000(-10000L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_MANAGE, "通用客户端校验异常"),
    VCE10001(-10001L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_MANAGE, "后台管理系统客户端验证异常"),
    VCE10007(-10007L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_CBASEINFO, "基础资料客户端验证异常"),
    VCE10030(-10030L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, SubSystem.SUB_SYSTEM_CACHE, "缓存系统客户端验证异常"),

    VBE20007(-20007L, ExceptionTypeCategory.VALIDATE_BUSINESS_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_CBASEINFO, "基础资料业务验证异常"),
    VBE20030(-20030L, ExceptionTypeCategory.VALIDATE_BUSINESS_EXCEPTION, SubSystem.SUB_SYSTEM_CACHE, "缓存服务验证异常"),

    BE40071(-40071L, ExceptionTypeCategory.BUSINESS_EXCEPTION, SubSystem.SUB_SYSTEM_CACHE, "数据库中无指定资料，获取缓存失败！"),
    BE40072(-40072L, ExceptionTypeCategory.BUSINESS_EXCEPTION, SubSystem.SUB_SYSTEM_CACHE, "数据库中存在多比指定资料，获取缓存失败！"),
    BE40073(-40073L, ExceptionTypeCategory.BUSINESS_EXCEPTION, SubSystem.SUB_SYSTEM_CACHE, "从本地内存缓存中获取数据源信息出错！"),
    BE40144(-40144L, ExceptionTypeCategory.BUSINESS_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_CBASEINFO, "探测系统时发现系统停止！"),


    ;


    /**
     * 异常码
     */
    private long code;
    /**
     * 子系统名称
     */
    private String subSystem;
    /**
     * 异常信息
     */
    private String description;
    /**
     * 异常类型分类
     */
    private ExceptionTypeCategory category;

    private static final Map<Long, ExceptionType> lookup = new HashMap();

    private ExceptionType(long code, ExceptionTypeCategory category, String subSystem, String description) {
        this.code = code;
        this.category = category;
        this.subSystem = subSystem;
        this.description = description;
    }

    public long getCode() {
        return this.code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getSubSystem() {
        return this.subSystem;
    }

    public void setSubSystem(String subSystem) {
        this.subSystem = subSystem;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExceptionTypeCategory getCategory() {
        return this.category;
    }

    public void setCategory(ExceptionTypeCategory category) {
        this.category = category;
    }

    public static ExceptionType getExceptionTypeByCode(long code) {
        return (ExceptionType)lookup.get(code);
    }

    static {
        Iterator var0 = EnumSet.allOf(ExceptionType.class).iterator();

        while(var0.hasNext()) {
            ExceptionType et = (ExceptionType)var0.next();
            lookup.put(et.getCode(), et);
        }

    }

    /**
     * 定义各子系统名称
     */
    private static class SubSystem {
        public static String SUB_SYSTEM_MANAGE = "manage";
        public static String SUB_SYSTEM_CBASEINFO = "baseinfo";
        public static String SUB_SYSTEM_CACHE = "cache";

        private SubSystem() {
        }
    }
}

