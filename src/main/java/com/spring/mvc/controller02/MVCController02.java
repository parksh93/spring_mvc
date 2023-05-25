package com.spring.mvc.controller02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/chap02")
public class MVCController02 {
    @RequestMapping("/hobbies")
    public String hobbies(Model model){
        String name = "룰루";
        List<String> hobbies = List.of("밥먹기","낮잠자기","쥐잡기"); //List 자료형 생성 및 자료 저장

        model.addAttribute("name",name);
        model.addAttribute("hList",hobbies);

        return "/chap02/hobbies";
    }

    @RequestMapping(value = "/hobbies2",method = RequestMethod.GET)
    public ModelAndView hobbies2(){
        ModelAndView modelAndView = new ModelAndView();
        String name = "참참이";
        List<String> hList = List.of("전깃줄에서 꾸벅꾸벅 졸기","쌀주워먹기","짹짹소리내기");
        //포워딩 방식
        String viewName = "/chap02/hobbies";

        modelAndView.setViewName(viewName);
        modelAndView.addObject("name", name);
        modelAndView.addObject("hList",hList);

        return modelAndView;
    }
}
