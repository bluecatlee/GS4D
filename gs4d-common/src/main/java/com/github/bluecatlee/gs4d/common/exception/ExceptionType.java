package com.github.bluecatlee.gs4d.common.exception;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum ExceptionType {
    VCE10000(-10000L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_MANAGE, "通用客户端校验异常"),
    VCE10001(-10001L, ExceptionTypeCategory.VALIDATE_CLIENT_EXCEPTION, ExceptionType.SubSystem.SUB_SYSTEM_MANAGE, "后台管理系统客户端验证异常"),
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

        private SubSystem() {
        }
    }
}

