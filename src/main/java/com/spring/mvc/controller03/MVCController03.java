package com.spring.mvc.controller03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap03")
public class MVCController03 {
    @RequestMapping("foodForm")
    public String foodForm(){
        return "/chap03/foodForm";
    }

    @RequestMapping(value = "/foodOrder",method = RequestMethod.GET)
    public ModelAndView foodOrder(String name , String tableNum, String foodName){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/chap03/foodresult");
        modelAndView.addObject("name",name);
        modelAndView.addObject("tableNum",tableNum);
        modelAndView.addObject("fName",foodName);
        return modelAndView;
    }

}
