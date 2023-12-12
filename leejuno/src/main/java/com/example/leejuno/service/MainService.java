package com.example.leejuno.service;

import com.example.leejuno.dao.MainDao;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    @Autowired
    MainDao mainDao;

    public List<Map<String, String>> getList() {
        List<Map<String, String>> list = mainDao.getList();
        return list;
    }
}
