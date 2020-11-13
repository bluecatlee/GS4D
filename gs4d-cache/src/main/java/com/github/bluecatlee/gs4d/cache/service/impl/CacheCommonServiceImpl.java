package com.github.bluecatlee.gs4d.cache.service.impl;

import com.github.bluecatlee.gs4d.cache.service.CacheCommonService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CacheCommonServiceImpl implements CacheCommonService {

    @Resource(name = "dataSource")
    DynamicDataSource dataSource;

    public JdbcTemplate getJdbcTemplate(String var1) {
        DataSourceContextHolder.setDataSourceType(var1);
        JdbcTemplate var2 = new JdbcTemplate(this.dataSource);
        return var2;
        return null;
    }

}
