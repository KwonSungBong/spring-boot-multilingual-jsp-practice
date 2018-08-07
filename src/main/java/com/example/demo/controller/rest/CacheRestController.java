package com.example.demo.controller.rest;

import com.example.demo.cache.LocaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rest")
public class CacheRestController {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private LocaleService cacheService;

    @RequestMapping("/cache")
    public String test() {
        log.info("Spring Boot Ehcache 2 Caching Example Configuration");
        log.info("using cache manager: " + cacheManager.getClass().getName());

        cacheService.clearCache();

        play("trombone");
        play("guitar");
        play("trombone");
        play("bass");
        play("trombone");
        return "test";
    }

    private void play(String instrument){
        log.info("Calling: " + LocaleService.class.getSimpleName() + ".play(\"" + instrument + "\");");
        cacheService.play(instrument);
    }

}
