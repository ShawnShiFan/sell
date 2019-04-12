package com.shawn.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        return new ModelAndView("login/index");
    }

    @RequestMapping(value = "/seller/logout")
    public ModelAndView logout(){
        Map<String, Object> map=new HashMap<>();
        map.put("msg", "注销成功");
        map.put("url", "http://localhost:8080/sell");
        return new ModelAndView("common/success", map);
    }
}
