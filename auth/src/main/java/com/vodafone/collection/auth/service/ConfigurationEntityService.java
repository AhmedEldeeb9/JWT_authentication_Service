package com.vodafone.collection.auth.service;

import com.vodafone.collection.auth.entity.Configuration;
import com.vodafone.collection.auth.repo.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class ConfigurationEntityService {

    @Autowired
    private ConfigurationRepository configurationRepository;


    @Cacheable("configurations")
    public Configuration getByKey(String key) {
        return configurationRepository.getByKey(key);
    }


    @CacheEvict(value = "configurations", allEntries = true)
    public void evictgetByKey() {
    }
}
