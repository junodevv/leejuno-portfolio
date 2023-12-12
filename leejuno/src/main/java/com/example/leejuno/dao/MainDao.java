package com.example.leejuno.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper // sqlmapper와 연결
public interface MainDao {

    List<Map<String, String>> getList();

}
