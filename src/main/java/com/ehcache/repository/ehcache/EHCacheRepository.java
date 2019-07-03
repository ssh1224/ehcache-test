package com.ehcache.repository.ehcache;

import com.ehcache.vo.property.PropertyVO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 2019-04-11.
 */
@Repository
public class EHCacheRepository {

    @Cacheable(value="property")
    public PropertyVO getData(int type) throws InterruptedException {
        Thread.sleep(3000);

        PropertyVO propertyVO = new PropertyVO();
        propertyVO.setType1(type);
        propertyVO.setType2(type);
        propertyVO.setType3(type);
        propertyVO.setType4(type);
        propertyVO.setType5(type);
        propertyVO.setType6(type);
        propertyVO.setType7(type);
        propertyVO.setType8(type);
        propertyVO.setType9(type);
        return propertyVO;
    }

    @CacheEvict(value="property", allEntries=true)
    public void evictCache(int type) {
        System.out.println("delete cache all");
    }

    @CachePut(value="property")
    public PropertyVO refreshCache(){

        PropertyVO propertyVO = new PropertyVO();
        propertyVO.setType1(0);
        propertyVO.setType2(0);
        propertyVO.setType3(0);
        propertyVO.setType4(0);
        propertyVO.setType5(0);
        propertyVO.setType6(0);
        propertyVO.setType7(0);
        propertyVO.setType8(0);
        propertyVO.setType9(0);

        return propertyVO;
    }
}