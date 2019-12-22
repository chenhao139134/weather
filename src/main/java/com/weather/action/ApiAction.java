package com.weather.action;

import com.weather.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: MainAction.java
 * Author:   chenhao
 * Date:     2019/12/1 10:43
 * Description:
 */
@Controller
public class ApiAction {


    @Autowired
    IService service;

    @RequestMapping(name = "/api/{param}/")
    @ResponseBody
    public Object china(Integer province, Integer city){
        List list = new ArrayList<>();
        try {
            if(city != null && city > 0){
                list = service.districts(city);
            }else if(province != null && province > 0){
                list = service.cities(province);
            }else{
                list = service.provinces();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /*@RequestMapping(name = "/weather")
    @ResponseBody
    public String weather(Integer cityid){
        String str = "";
        try {
            if(cityid != null && cityid > 0){
                str = service.result(cityid);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }*/
}