package com.spring.mvc.chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    학생의 성적정보를 조회하고
    등록하고, 삭제할 수 있는 시스템

    요청 url 종류

    1. 학생 성적 정보 등록화면을 보여주고, 성적정보 목록조회 처리
    /score/list : GET
    2. 성적 정보 등록 처리 요청
    /score/register : POST(DB변경)
    3. 성적 정보 삭제 요처
    /score/remove : POST (DB변경)
    4. 성적정보 상세 요청
    /score/detail : GET

    - DB 변경이 일어난다면 POST로 받는다.
     -> 이유 : GET 방식으로 할경우 form을 통해서뿐만 아니라 url을 통해서도 DB변경이 일어날 수 있기 때문에 DB테러가 발생할 수 있다
 */
@Controller
@RequestMapping("score")
public class ScoreController {
    // 1. 성적 등록 화면 띄우기 + 정보목록 조회
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(){
        System.out.println("/score/list : GET");
        return "";
    }

    // 2. 성적 정보 등록 처리 요청
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(){
        System.out.println("/score/register : POST");
        return "";
    }

    // 3. 성적 정보 삭제 요청
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public String remove(){
        System.out.println("/score/remove : POST");
        return "";
    }

    // 4. 성적정보 상세 요청
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail(){
        System.out.println("/score/detail : GET");
        return "";
    }

}
