package com.github.bluecatlee.gs4d.cache.service;


import com.github.bluecatlee.gs4d.cache.request.CacheDeleteRequest;
import com.github.bluecatlee.gs4d.cache.request.CacheGetRequest;
import com.github.bluecatlee.gs4d.cache.request.CacheKeyGenerateRuleByMethodNameGetRequest;
import com.github.bluecatlee.gs4d.cache.request.CacheKeyGenerateRuleBySubSystemGetRequest;
import com.github.bluecatlee.gs4d.cache.response.CacheDeleteResponse;
import com.github.bluecatlee.gs4d.cache.response.CacheGetResponse;
import com.github.bluecatlee.gs4d.cache.response.CacheKeyGenerateRuleByMethodNameGetResponse;
import com.github.bluecatlee.gs4d.cache.response.CacheKeyGenerateRuleBySubSystemGetResponse;

public interface CacheStoreService {

    CacheGetResponse getCache(CacheGetRequest request);

    CacheKeyGenerateRuleBySubSystemGetResponse getCacheKeyGenerateRuleBySubSystem(CacheKeyGenerateRuleBySubSystemGetRequest request);

    CacheKeyGenerateRuleByMethodNameGetResponse getCacheKeyGenerateRuleByMethodName(CacheKeyGenerateRuleByMethodNameGetRequest request);

    CacheDeleteResponse deleteCache(CacheDeleteRequest request);

}
