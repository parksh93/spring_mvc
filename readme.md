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