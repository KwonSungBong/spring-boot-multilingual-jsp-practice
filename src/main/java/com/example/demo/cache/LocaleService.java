package com.example.demo.cache;

import com.example.demo.repository.I18NRepository;
import com.example.demo.vo.I18n;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Slf4j
@Service
@CacheConfig(cacheNames = "locale")
public class LocaleService {

    @Autowired
    private I18NRepository i18NRepository;

    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }

    public String i18nText(String code) {
        try {
            return i18nByLocaleAndCode("ko_KR", code).getText();
        } catch (Exception e) {
            return code;
        }
    }

    public String i18nText(String locale, String code) {
        try {
            return i18nByLocaleAndCode(locale, code).getText();
        } catch (Exception e) {
            return code;
        }
    }

    public I18n i18nByLocaleAndCode(String locale, String code) {
        return i18nByLocale(locale).get(code);
    }

    public Map<String, I18n> i18nByLocale(String locale) {
        return i18n().get(locale);
    }

    @Cacheable(value = "i18n")
    public Map<String, Map<String, I18n>> i18n() {
        return i18NRepository.findAll().stream()
                .collect(groupingBy(I18n::getLocale, Collectors.toMap(I18n::getCode, Function.identity())));
    }

}