<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>${title}</h1>
        <form action="/chap03/foodOrder" method="get">
            주문자명 : <input name = "name" type="text"><br>
            주문테이블번호 : <input type="number" name="tableNum"><br>
            주문할 수 있는 음식<br>
            <input type="text" name = "foodName"><br> 
            <input type="submit" value="주문">
        </form>

    </body>
</html>