package com.github.bluecatlee.gs4d.cache.b;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.github.bluecatlee.gs4d.common.utils.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
@Scope("singleton")
public class b {

    @Value("${dubbo.zookeeper.host.port}")
    private String dubboZookeeperHostPort;
    @Value("${dubbo.service.port}")
    private Integer dubboServicePort;
    @Value("${rpc.invoke-type}")
    private String rpcInvokeType;
    @Resource(name = "msgcenterJdbcTemplate")
    private MyJdbcTemplate msgcenterJdbcTemplate;

    public static final String N = "ec_cache_method_dependence_series";
    public static final String O = "ec_cache_index_dependence_series";
    public static final String P = "ec_cache_table_record_series";
    public static final String Q = "ec_common_cache_dependence_series";

    public b() {
    }

    @PostConstruct
    public void a() {
//        if (!"hsf".equals(this.rpcInvokeType)) {
//            UniversalLiveDetectUtil.initSystemLiveDetect(this.dubboZookeeperHostPort, "ccache", this.msgcenterJdbcTemplate, this.dubboServicePort, "mysql");
//        }
//        SeqGetUtil.initeZkConfig(this.dubboZookeeperHostPort);
    }

//    public static String b(String var0, String var1) {
//        return SeqGetUtil.getSequence(var0, var1);
//    }

//    public static String e(String var0) {
//        return String.valueOf(SeqGetUtil.getNoSubSequence("ccache", var0));
//    }
}

