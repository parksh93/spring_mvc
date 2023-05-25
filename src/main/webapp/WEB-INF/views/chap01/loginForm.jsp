<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <form action="/chap01/login" method="POST">
            <input type="text" name="id" placeholder="아이디입력">
            <input type="password" name="pw" placeholder="비밀번호 입력">
            <input type="submit" value="로그인">
        </form>
    </body>
</html>