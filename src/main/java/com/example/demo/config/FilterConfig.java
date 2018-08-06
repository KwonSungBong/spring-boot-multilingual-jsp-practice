package com.example.demo.config;

import com.example.demo.filter.AccessMenuFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

//    @Bean
    public AccessMenuFilter accessMenuFilter(){
        AccessMenuFilter accessMenuFilter = new AccessMenuFilter();
        accessMenuFilter.setPatterns(new String[]{
                "/**/*"
        });
        return accessMenuFilter;
    }

}
