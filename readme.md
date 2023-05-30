## 커뮤니티버전 프로젝트 JDK 연결
1. File -> Project Structure 들어가기
2. Project Serrings의 SDK를 버전 맞게(17버전)
3. File -> Setting 들어가기
4. gradle 검색 후 build tools의 gradle항목에서
    맨 하단 gradle JVM을 2에서 설정한 버전으로 맞추기
5. 우측 상단 코끼리 모양 아이콘 누르기 (없으면 1시방향 녹색재생버튼)
---
## vscode에서 .jsp파일 템플릿 설정하기
1. vscode 좌측하단 톱니바퀴 모양 클릭
2. 사용자 코드 조각(user snipets) 클릭 후 html 입력
3. html.json 파일에 아래 코드 붙여놓고 저장
4. .jsp파일 생서 후 !jsp를 입력하면 템플릿이 자동완성됨
```
"JSP template": {
		"prefix": "!jsp",
		"body": [
			"<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>",
			"<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>",
			"<!DOCTYPE html>",
			"<html>",
			"<head>",
			"<meta charset=\"UTF-8\">",
			"<title>Insert title here</title>",
			"</head>",
			"<body>",
			"</body>",
			"</html>",
		],
		"description": "make jsp template"
	}
```

---
## 서버 포트 번호 변경
server.port = 바꿀 포트 번호

---
### ※ webapp 폴더는 톰캣 고정 폴더이다.

---
## TDD (테스트 주도 개발) 방법
1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해둔다.
2. 테스트 코드 내부에 원하는 기능대로 작성되었을때 어떤 결과가 나올지 단언해둔다.
3. 테스트가 통과될때까지 원본 클래스를 수정하면서 계속 테스트 해본다.
* GWT 패턴(AAA 패턴) 
  - GIVEN (테스트를 워해 사전에 설정해야 하는 데이터를 선언하는 구간)
* WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성)
* THEN (테스트 결과가 이렇게 나올것이다 하는 단언)
    - assertEquals(expected, actual);
### 사용 예시
```
    @Override
    public List<Score> findAll() {
        return null;
    }
    
   //Test Class 
       @Test
    public void findAllTest(){
        //GWT 패턴(AAA 패턴)
        //GIVEN (테스트를 워해 사전에 설정해야 하는 데이터를 선언하는 구간)
        //findAll은 특별한 조건 없이 전체 데이터를 가져오므로 GIVEN이 없음
        ScoreRepository repository = new ScoreRepositoryImpl();

        //WHEN (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성)
        List<Score> result = repository.findAll();

        //THEN (테스트 결과가 이렇게 나올것이다 하는 단언)
        // 나는 result 내부에 3개의 Score가 있다고 단언합니다.
        //ScoreMap에 사전설정으로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        //방식 1 (예전)
        System.out.println(result.size() == 3);
        //방식 2
        assertEquals(3, result.size());
        
        //현재결과 :  result가 null로 Exception발생
    }
```
위 방식으로 먼저 작성 후
findAll()을 작성하여 원하는 결과가 나올때까지 Test한다.
```
    @Override
    public List<Score> findAll() {
        List<Score> studentList = new ArrayList<>();
        for (Score score: scoreMap.values()) {
            studentList.add(score);
        }
        return studentList;
    }
    
    //결과 : true
```
true로 원하는 결과가 나왔기 때문에 해당 테스트 통과
---

MVC에서 DB의 변경이 있을 경우 POST로 전달해야한다