package com.example.demo.repository;

import com.example.demo.vo.I18n;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface I18NRepository {
    List<I18n> findAll();
    int update(I18n i18N);
}
