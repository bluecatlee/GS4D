package com.github.bluecatlee.gs4d.cache.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;

import com.github.bluecatlee.gs4d.cache.entity.b;
import com.github.bluecatlee.gs4d.cache.exception.CacheExceptionType;
import com.github.bluecatlee.gs4d.common.exception.DatabaseOperateException;
import com.github.bluecatlee.gs4d.common.utils.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EcCommonCacheDependenceDao {
    @Value("${db.annotate.prefix}")
    private String dbAnnotatePrefix;
    @Resource(
            name = "msgcenterJdbcTemplate"
    )
    private MyJdbcTemplate msgcenterJdbcTemplate;

    public EcCommonCacheDependenceDao() {
    }

    public void a(final List<b> var1) {
        String var2 = "insert into ec_common_cache_dependence(series,tenant_num_id,data_sign,method_name,db,cache_key,params,table_name,table_series,create_dtme,last_updtme,create_user_id,last_update_user_id,dubbo_group) values (?,?,?,?,?,?,?,?,?,now(),now(),?,?,?)";
        int[] var3 = this.msgcenterJdbcTemplate.batchUpdate(var2, new BatchPreparedStatementSetter() {
            public int getBatchSize() {
                return var1.size();
            }

            public void setValues(PreparedStatement var1x, int var2) throws SQLException {
                b var3 = (b)var1.get(var2);
                byte var4 = 1;
//                var3.setSERIES(com.gb.soa.omp.ccache.b.b.e("ec_common_cache_dependence_series"));
                int var5 = var4 + 1;
                var1x.setString(var4, var3.getSERIES());
                var1x.setLong(var5++, var3.getTENANT_NUM_ID());
                var1x.setLong(var5++, var3.getDATA_SIGN());
                var1x.setString(var5++, var3.getMETHOD_NAME());
                var1x.setString(var5++, var3.getDB());
                var1x.setString(var5++, var3.getCACHE_KEY());
                var1x.setString(var5++, var3.getPARAMS());
                var1x.setString(var5++, var3.getTABLE_NAME());
                var1x.setString(var5++, var3.getTABLE_SERIES());
                var1x.setLong(var5++, var3.getCREATE_USER_ID());
                var1x.setLong(var5++, var3.getLAST_UPDATE_USER_ID());
                var1x.setString(var5++, var3.getDUBBO_GROUP());
            }
        });
        if (var3.length != var1.size()) {
            throw new DatabaseOperateException("ccache", CacheExceptionType.DOE30042, "批量插入缓存方法值关联表记录失败!");
        }
    }

    public List<b> a(Long var1, Long var2, String var3, String var4, Long var5) {
        String var6 = "select series,tenant_num_id,data_sign,method_name,db,cache_key,params,table_name,table_series,create_dtme,last_updtme,create_user_id,last_update_user_id,dubbo_group from ec_common_cache_dependence where data_sign=? and table_name=? and table_series=? and db=? ";
        if (!var1.equals(0L)) {
            var6 = var6 + String.format(" and tenant_num_id=%s  ", var1);
        }

        return this.msgcenterJdbcTemplate.query(var6, new Object[]{var2, var4, var5, var3}, new BeanPropertyRowMapper(b.class));
    }

    public void a(Long var1, Long var2, String var3, String var4) {
        String var5 = "delete from ec_common_cache_dependence where tenant_num_id =? and data_sign =? and cache_key=? and method_name=? ";
        int var6 = this.msgcenterJdbcTemplate.update(var5, new Object[]{var1, var2, var4, var3});
        if (var6 < 1) {
            throw new DatabaseOperateException("ccache", CacheExceptionType.DOE30042, "删除已过期缓存方法值关联表记录失败!方法名:" + var3 + ",缓存键值:" + var4);
        }
    }

    public List<String> a(Long var1, Long var2, String var3, String var4, String var5) {
        String var6 = this.dbAnnotatePrefix + "select series from ec_common_cache_dependence where tenant_num_id =? and data_sign =? and cache_key=? and method_name=? and dubbo_group=? ";
        List var7 = this.msgcenterJdbcTemplate.queryForList(var6, new Object[]{var1, var2, var4, var3, var5}, String.class);
        return var7;
    }

    public List<String> b(Long var1, Long var2, String var3, String var4) {
        String var5 = this.dbAnnotatePrefix + "select series from ec_common_cache_dependence where tenant_num_id =? and data_sign =? and cache_key=? and method_name=? ";
        List var6 = this.msgcenterJdbcTemplate.queryForList(var5, new Object[]{var1, var2, var4, var3}, String.class);
        return var6;
    }

    public void b(Long var1, Long var2, String var3, String var4, String var5) {
        String var6 = "delete from ec_common_cache_dependence where tenant_num_id =? and data_sign =? and cache_key=? and method_name=? and series=? ";
        int var7 = this.msgcenterJdbcTemplate.update(var6, new Object[]{var1, var2, var4, var3, var5});
        if (var7 < 0) {
            throw new DatabaseOperateException("ccache", CacheExceptionType.DOE30042, "删除已过期缓存方法值关联表记录失败!方法名:" + var3 + ",缓存键值:" + var4);
        }
    }
}

