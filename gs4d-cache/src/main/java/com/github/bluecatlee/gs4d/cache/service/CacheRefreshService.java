package com.github.bluecatlee.gs4d.cache.service;

import com.github.bluecatlee.gs4d.cache.request.CommonCacheRefreshRequest;
import com.github.bluecatlee.gs4d.cache.response.CommonCacheRefreshResponse;

public interface CacheRefreshService {
    CommonCacheRefreshResponse refreshCommonCache(CommonCacheRefreshRequest request);
}

