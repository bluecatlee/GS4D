package com.github.bluecatlee.gs4d.cache.dao;

import javax.annotation.Resource;

import com.github.bluecatlee.gs4d.common.utils.MyJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MdmsSConfigDao {

    @Resource(name = "masterJdbcTemplate")
    private MyJdbcTemplate jdbcTemplate;

    public MdmsSConfigDao() {
    }

    public String getConfigValue(Long tenantNumId, Long dataSign, String configName) {
        String var4 = "select config_value from mdms_s_config where tenant_num_id=? and data_sign=? and config_name=? limit 1 ";
        return (String)this.jdbcTemplate.queryForObject(var4, new Object[]{tenantNumId, dataSign, configName}, String.class);
    }
}

