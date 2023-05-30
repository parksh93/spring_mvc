package com.spring.mvc.chap04.controller;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
@RequestMapping("/score")
//@AllArgsConstructor
@RequiredArgsConstructor    //final 필드에 대해서 초기화하는 생성자
public class ScoreController {
    //repository 기능을 이용해 데이터를 가져와야 화면에 요청 데이터를 양식에 맞춰서 전달할 수 있음
    //@Autowired
    private final ScoreRepository repository;
    // 스프링 4.0이후로 생성자가 하나인 경우에는 어노테이션 없이 자동주입

    // 1. 성적 등록 화면 띄우기 + 정보목록 조회
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        System.out.println("/score/list : GET");
        List<Score> scoreList = repository.findAll();
        model.addAttribute("sList",scoreList);

        return "chap04/score-list";
    }

    // 2. 성적 정보 등록 처리 요청
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Score score){
        System.out.println("/score/register : POST");
        repository.save(score);
        return "redirect:/score/list";
    }

    // 3. 성적 정보 삭제 요청
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public String remove(int studentNumber){
        System.out.println("/score/remove : POST");
        repository.deleteByStudentNumber(studentNumber);
        return "redirect:/score/list";
    }

    // 4. 성적정보 상세 요청
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detail(int studentNumber,Model model){
        System.out.println("/score/detail : GET");
       Score score = repository.findByStudentNumber(studentNumber);
       model.addAttribute("score",score);
        return "chap04/detail-score";
    }

}
