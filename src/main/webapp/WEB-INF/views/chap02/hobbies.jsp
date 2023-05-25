<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>
    <body>
        <h1>${name}의 취미 목록</h1>
        <p>${hList}</p>
        <ol>
            <c:forEach var="n" items = "${hList}">
                <li>${n}입니다.</li>
            </c:forEach>
        </ol>
    </body>
</html>