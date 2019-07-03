package com.ehcache.service.ehcache;

import com.ehcache.repository.ehcache.EHCacheRepository;
import com.ehcache.vo.property.PropertyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2019-04-11.
 */
@Service
public class EHCacheService {

    @Autowired
    private EHCacheRepository ehCacheRepository;

    public PropertyVO getData(int type) throws InterruptedException {
        return ehCacheRepository.getData(type);
    }

    public void evictCache(int type) throws InterruptedException{
        ehCacheRepository.evictCache(type);
    }

    public PropertyVO refreshCache() throws InterruptedException{
        return ehCacheRepository.refreshCache();
    }
}
