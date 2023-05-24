package com.spring.mvc.controller01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //해당 어노테이션이 있어야, 스프링 코러가 관리하는 컨트롤러가 됨
public class MVCController01 {

    //특정 주소로 접속했을대 처리할 로직을 작성
    @RequestMapping("/hello")   //localhost:8080이 기본주소고, 뒤에 hello룰 붙여 접속시 실행
    public String hello(){
        System.out.println("/hello 접속 감지");
        //어떤 .jsp파일과 연동할지 return 구문에 문자열ㄹ 파일이름을 적어줌
        // /main/resources/applicatuin.properties파일에 prefix였던 /WEB-INF/views와 sufix였던 .jsp를 앞뒤로 붙여서
        //최종적으로 열리는 파일은 /WEB-INF/views/hello.jsp
        return "hello";
    }

    @RequestMapping("/bye")
    public String bye(){
        System.out.println("bye~~~~~");
        return "bye";
    }

    @GetMapping("/getreq")  // localhost:8080/getreq 접속 허용
    public String getReq(){
        System.out.println("get방식 요청 감지");
        return "reqView";
    }
    @PostMapping("/postreq")  // localhost:8080/getreq 접속 허용
    public String postReq(){
        System.out.println("post방식 요청 감지");
        return "reqView";
    }
}
