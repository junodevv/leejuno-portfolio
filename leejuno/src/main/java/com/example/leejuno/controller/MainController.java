package com.example.leejuno.controller;

import com.example.leejuno.service.MainService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String index(){
        List<Map<String, String>> list = mainService.getList();

        return "/index";
    }

    @GetMapping("/list")
    @ResponseBody
    public String doIndex(HttpServletRequest request){
        List<Map<String, String>> list = mainService.getList();
        log.info(list);

        JSONArray jsonArray = new JSONArray();
        for(Map<String, String> fmap : list){
            JSONObject jsonObject = new JSONObject(fmap);
            log.info(jsonObject);
            jsonArray.put(jsonObject);
        }
        String strArr = "{\"contents\":";
        strArr += String.valueOf(jsonArray);
        strArr += "}";
        log.info("strArr: " + strArr);
        return strArr ;
    }

//    @PostMapping("/")
//    @ResponseBody
//    public String doIndex(HttpServletRequest request){
//        List<Map<String, String>> list = mainService.getList();
//        log.info(list);
//
//        JSONArray jsonArray = new JSONArray();
//        for(Map<String, String> fmap : list){
//            JSONObject jsonObject = new JSONObject(fmap);
//            log.info(jsonObject);
//            jsonArray.put(jsonObject);
//        }
//        String strArr = "{\"contents\"}:";
//            strArr += String.valueOf(jsonArray);
//            strArr += "}";
//        log.info("strArr: " + strArr);
//        return strArr ;
//    }
}
