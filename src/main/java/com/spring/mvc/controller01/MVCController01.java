package com.spring.mvc.controller01;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@Controller //해당 어노테이션이 있어야, 스프링 코러가 관리하는 컨트롤러가 됨
@RequestMapping("/chap01")
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
//    @RequestMapping(value = "getreq", method = RequestMethod.GET)
    //get과 post 모두 설정시
//    @RequestMapping(value = "getreq", method = {RequestMethod.GET,RequestMethod.POST})
    public String getReq(){
        System.out.println("get방식 요청 감지");
        return "reqView";
    }
    @PostMapping("/postreq")  // localhost:8080/getreq 접속 허용
    public String postReq(){
        System.out.println("post방식 요청 감지");
        return "reqView";
    }
    /*
        요청  파라미터 읽어오기(Query String = Get방식, RequestBody = POST방식)
        1. HttpSevleRequest사용하기(원시적인 JSP에서 쓰는 방법)
        /peson?name = ki&age = 30
     */
    @RequestMapping("/person")
    public String person(HttpServletRequest request){
        String name = request.getParameter("name");
        //http 전송 방식에서는 모든 파라미터의 자료형이 문자로 통일됨, 그래서 나이도 문자
        String age = request.getParameter("age");

        System.out.println("name : " + name + " age : " + age);
        return "person";
    }

    /*
        2. @RequestParam 사용하기
        /major?stu=kim&major=computerscience&gpa=3.4
        메서드 선언부 파라미터와 자료형을 입력하고, 왼쪽에 @RequestParam("가져올 변수명") 입력
         - 자료형을 자동으로 바꿔줌
    */
    @RequestMapping("/major")                      // 기본값 설정
    public String major(String stu, @RequestParam(defaultValue = "0.0") double gpa, @RequestParam("major") String 전공){
        System.out.println("stu : " + stu);
        System.out.println("gpa : " + gpa);
        System.out.println("만점까지 몇점 모자른지 : " + (4.5 - gpa));
        System.out.println("major라는 명칭으로 전달된 '전공' 변수 : " + 전공);

        return "";
    }
    /*
        3. 커멘드 객체 이용하기
        연관된 자료를 한 번에 처리해야 하는 경우 외부에 class를 하나 만들고 그 클래스를 파라미터로 주면
        외부 클래스의 내부 멤버변수명이 전부 매핑되어 주입됨
     */
    @RequestMapping("notebook")   // NotebookDTO의 멤버변수명칭으로 들어오는 파라미터를 자동대입
    // modelName, price, ram, ssd 명칭으로 들어오는걸 받아줌.
    public String notebook(NotebookDTO notebook){
        System.out.println("파라미터로 전달받은 NotebookDTO 내부 : " + notebook);
        return "";
    }

    @RequestMapping("/dog")
    public String dogSelect(DogDTO dog){
        System.out.println("이름 : " + dog.getName());
        System.out.println("나이 : " + dog.getAge());
        System.out.println("품종 : " + dog.getKind());
        return "";
    }

    /*
        4. URL에 경로로 붙어있는 데이터 읽어오기
        /board/103
        게시판의 103번 글을 읽고 싶음
     */
    @RequestMapping("/board/{bNo}")    //패턴과 동일한 이름의 변수를 파라미터 선언부에 선언해줘야한다
    public String board(@PathVariable int bNo){
        System.out.println(bNo);
        return "";
    }

    @RequestMapping("/member/{mName}/{mNo}")
    public String memberSearch(@PathVariable String mName, @PathVariable String mNo){
        System.out.println("이름 : " + mName);
        System.out.println("번호 : " + mNo);
        return "";
    }

    @RequestMapping("/catForm")
    public String catForm(){
        System.out.println("고양이를 등록할 수 있는 폼으로 연결");
        // WEB-INF/views/chap01/catForm.jsp
        return "/chap01/catForm";
    }

    @RequestMapping(value = "/cat",method = RequestMethod.POST)
    public ModelAndView cat(String name, int age, String kind){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chap01/cat");
        mv.addObject("name",name);
        mv.addObject("age",age);
        mv.addObject("kind",kind);

        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("품종 : " + kind);

        return mv;
    }

    @RequestMapping(value = "/loginForm")
    public String loginForm(){
        return "/chap01/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(String id, String pw){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chap01/login");
        mv.addObject("id", id);
        mv.addObject("pw", pw);
        return mv;
    }
}
