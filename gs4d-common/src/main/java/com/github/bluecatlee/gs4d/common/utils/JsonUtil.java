package com.github.bluecatlee.gs4d.common.utils;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class JsonUtil {
    private static JsonMapper snakeCaseMapper = new JsonMapper();
    private static JsonMapper camelMapper = JsonMapper.nonEmptyMapper();

    public JsonUtil() {
    }

    public static String toJson(Object object) {
        return snakeCaseMapper.toJson(object);
    }

    public static String toJsonCamel(Object object) {
        return camelMapper.toJson(object);
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return snakeCaseMapper.fromJson(jsonString, clazz);
    }

    public static <T> T fromJsonCamel(String jsonString, Class<T> clazz) {
        return camelMapper.fromJson(jsonString, clazz);
    }

    static {
        snakeCaseMapper.getMapper().setPropertyNamingStrategy(PropertyNamingStrategy.LowerCaseStrategy.SNAKE_CASE);
    }

}
