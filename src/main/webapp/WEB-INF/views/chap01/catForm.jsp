<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>고양이 정보 등록</h1>
        <form action="/chap01/cat" method="POST">
            <input type="text" placeholder="고양이 이름" name = "name">
            <input type="number" placeholder="고양이 나이" name = "age">
            <input type="text" placeholder="고양이 품종" name = "kind">
            <input type="submit" value="등록">
        </form>
    </body>
</html>