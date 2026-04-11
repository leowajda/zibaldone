package com.tutego.ch_04.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@CacheConfig(cacheNames = "json-hot-profiles") // avoids code duplication
public class HotProfileToJsonConverter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Cacheable(
            condition = "#ids.size() > 1",
            unless = "#result.length() == 100",
            keyGenerator = "simpleKeyGenerator" // name of the bean that implements KeyGenerator
            // key = "#ids.hashCode()"
    )
    public String hotAsJson(List<Long> ids) {
        logger.info("Generating JSON for list {}", ids);
        return ids.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    @CacheEvict
    public void removeHotAsJson(List<Long> ids /* manual cache eviction of individual entries */) {}

    @CacheEvict(allEntries = true /*  purges the entire cache */)
    public void removeAllHotAsJson() {}

}
