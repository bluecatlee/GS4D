package com.github.bluecatlee.gs4d.cache.dao;

import com.github.bluecatlee.gs4d.cache.entity.a;
import com.github.bluecatlee.gs4d.cache.exception.CacheExceptionType;
import com.github.bluecatlee.gs4d.common.exception.DatabaseOperateException;
import com.github.bluecatlee.gs4d.common.utils.MyJdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CacheMethodSchemaDefineDao {

    @Resource(name = "commonDossierJdbcTemplate")
    private MyJdbcTemplate commonDossierJdbcTemplate;

    public CacheMethodSchemaDefineDao() {
    }

    public a a(String var1) {
        String var2 = "select series,tenant_num_id,data_sign,sub_system,method_name,sql_content,db,cache_method,cache_multi_col,ttl,list_sign,allow_list_empty_sign,create_dtme,last_updtme,create_user_id,last_update_user_id,description from ec_cache_method_schema_define where tenant_num_id=0 and data_sign= 0 and method_name= ? ";
        a var3 = (a)this.commonDossierJdbcTemplate.queryForObject(var2, new Object[]{var1}, new BeanPropertyRowMapper(a.class));
        if (var3 == null) {
            throw new DatabaseOperateException("ccache", CacheExceptionType.DOE30042, "获取缓存对应sql定义失败,方法名:" + var1);
        } else {
            return var3;
        }
    }

    public List<a> b(String var1) {
        String var2 = "select series,tenant_num_id,data_sign,sub_system,method_name,sql_content,db,cache_method,cache_multi_col,ttl,list_sign,create_dtme,last_updtme,create_user_id,last_update_user_id from ec_cache_method_schema_define where tenant_num_id=0 and data_sign= 0 and sub_system= ? ";
        List var3 = this.commonDossierJdbcTemplate.query(var2, new Object[]{var1}, new BeanPropertyRowMapper(a.class));
        return var3;
    }

}
