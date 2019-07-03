package com.ehcache.controller.ehcache;

import com.ehcache.service.ehcache.EHCacheService;
import com.ehcache.vo.property.PropertyVO;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2019-04-10.
 */
@RestController
@RequestMapping("/ehcache")
public class EHCacheController {

    @Autowired
    private EHCacheService ehCacheservice;

    @RequestMapping(value = "/data/{type}", method = RequestMethod.GET)
    public String getData(@PathVariable("type") int type) throws InterruptedException{
        long start = System.currentTimeMillis();
        PropertyVO propertyVO = ehCacheservice.getData(type);
        long end = System.currentTimeMillis();

        String msg = "running time : " + (end - start) + " ms [" + propertyVO.toString() + "]";
        return msg;
    }

    @RequestMapping(value = "/data/delete/{type}", method = RequestMethod.GET)
    public String getExpireCache(@PathVariable("type") int type) throws InterruptedException{
        ehCacheservice.evictCache(type);
        return "clear cache~";
    }

    @RequestMapping(value = "/data/refresh", method = RequestMethod.GET)
    public String getRefreshCache() throws InterruptedException{
        PropertyVO propertyVO = ehCacheservice.refreshCache();
        return "refresh]]]" + propertyVO.toString();
    }
}
