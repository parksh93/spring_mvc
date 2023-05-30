<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            a {
                text-decoration:none;
                color:black;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>전체 학생 성적 목록</h1>
            <table class="table table-hover">
                <thead>
                    <tr class=" table-primary">
                        <th scope="col">학번</th>
                        <th scope="col">이름</th>
                        <th scope="col">국어</th>
                        <th scope="col">수학</th>
                        <th scope="col">영어</th>
                        <th scope="col">총점수</th>
                        <th scope="col">평균점수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${sList}">
                        <tr>
                            <th scope="row">${i.studentNumber}</th>
                            <td><a href="/score/detail?studentNumber=${i.studentNumber}">${i.name}</a></td>
                            <td>${i.korScore}</td>
                            <td>${i.mathScore}</td>
                            <td>${i.engScore}</td>
                            <td>${i.korScore + i.mathScore + i.engScore}</td>
                            <td>${(i.korScore + i.mathScore + i.engScore) / 3}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr>
            <h1>성적 등록 폼</h1>
            <div class="mb-3">
                <form action="/score/register" method="POST">
                    <label for="username" class="form-label">이름</label>
                    <input type="text" class="form-control" id="username" name = "name">
                    <label for="user-kor" class="form-label">국어 성적</label>
                    <input type="text" class="form-control" id="user-kor" name = "korScore" min="0">
                    <label for="user-math" class="form-label">수학 성적</label>
                    <input type="text" class="form-control" id="user-math" name = "mathScore" min="0">
                    <label for="user-eng" class="form-label">영어 성적</label>
                    <input type="text" class="form-control" id="user-eng" name = "engScore" min="0"> 
                    <br>
                    <input type="submit" value="등록" class="btn btn-primary">   
                </form>
            </div>
        </div>
    </body>
    </html>