package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class I18nConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver()
    {
        // 쿠키를 사용한 예제
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieName("lang");

        return resolver;
    }

//    @Bean(name = "localeResolver")
//    public LocaleResolver sessionLocaleResolver() {
//        // 세션 기준으로 로케일을 설정 한다.
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        // 쿠키 기준(세션이 끊겨도 브라우져에 설정된 쿠키 기준으로)
//        // CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//
//        // 최초 기본 로케일을 강제로 설정이 가능 하다.
//        localeResolver.setDefaultLocale(Locale.US);
//        return localeResolver;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        registry.addInterceptor(localeChangeInterceptor);
    }

}
