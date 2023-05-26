<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>submit방식</h1>
        <form action="https://search.naver.com/search.naver" method="get">
            검색어 : <input type="text" name="query">
            <input type="submit" value="검색" onkeypress="e => {e.keyCode == 13}">
        </form>
        <h1>리다이렉트 방식</h1>
        <form action="/chap03/research" method="get">
            검색어 : <input type="text" name="query">
            <input type="submit" value="검색" onkeypress="e => {e.keyCode == 13}">
        </form>
    </body>
</html>