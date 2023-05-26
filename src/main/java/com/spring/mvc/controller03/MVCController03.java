package com.spring.mvc.controller03;

import com.oracle.wls.shaded.org.apache.xpath.objects.XString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    @RequestMapping("/naver")
    public String naver(){
        //리다이렉트는 'redirect:보낼주소;" 형식으로 문자를 작성하면 실행됨
        //마치 a태그를 클릭하는 것처럼 자동으로 페이지를 보낸주소로 이동시킴
        // 이 과정에서 포워딩과 달리 model.addAtribute()처럼 자료를 첨부해 이동시킬수 없음
        // 하지만 get방식으로 이동하는 만큼 쿼리스트링을 붙여서 보내는것은 가능
        return "redirect:https://www.naver.com";    //응답코드는 300번대를 받음

        //포워딩 방식은 return시 jsp파일로 이동하지만 리다이렉트 방식은 내가 가지고 있는 주소가 아니라도 보낼 수 있다.
    }

    @RequestMapping("/gofoodform")
    public String getFoodForm(Model model){
        //리다이렉션은 model.addAtribute()를 통한 데이터 전송이 불가능
        model.addAttribute("title","음식 주문 키오스크");
//        return "redirect:/chap03/foodForm";    //목적 파일로 포워딩하지 않고 목적 메서드 주소로 리다이렉트
                                                //redirect는 주소(http://localhost8181/chap03/foodForm.jsp로
                                                //포워딩은 특정 파일(WEB-INF/views/chap03/foodForm.jsp)을 찾는다
                                                // -> 포워딩은 내가 가지고 있는 파일만, 리다이렉트는 그렇지 않은 주소로도 이동가능
        return "/chap03/foodForm";
    }

    //리다이렉트로 데이터 전달
    //GET방식은 url에 쿼리스트링읗 붙여서 데이터를 전송하기 때문에
    //리다이렉트 타겟 url에 쿼리스트링을 붙여 리다이렉트를 수정하면 전달 가능
    @RequestMapping("/searchform")
    public String searchForm(){
        return "/chap03/searchForm";
    }

    @RequestMapping("/research")
    public String reSearch(String query) throws UnsupportedEncodingException {
        String encodedParam = URLEncoder.encode(query, "UTF-8");
        String resultPage = "redirect:https://search.naver.com/search.naver?query=" + encodedParam;
        return resultPage;
    }
}
