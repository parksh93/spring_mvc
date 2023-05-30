<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <style>
            li{
                font-size: 20px;
            }
            .container{
                border: 1px solid black;
                margin-top: 30px;
                padding: 20px;
                width: 600px;
            }
            h1{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form name="form">
                <h1>${score.name}의 상세 정보</h1>
                <ol>
                    <li>학번 : ${score.studentNumber}</li>
                    <li>국어점수 : ${score.korScore}</li>
                    <li>수학점수 : ${score.mathScore}</li>
                    <li>영어점수 : ${score.engScore}</li>
                    <li>총 점수 : ${score.korScore + score.mathScore + score.engScore}</li>
                    <li>평균 점수 : ${(score.korScore + score.mathScore + score.engScore)/3}</li>
                </ol>
                <button class="btn btn-primary" onclick="deleteCheck()">삭제</button>   
                <button class="btn btn-primary" onclick="returnList()">목록</button>   
            </form>
        </div>
            
            <script>
                function deleteCheck(){
                    let check = confirm("해당 정보를 삭제하시겠습니까?");
                    let form = document.form;
                    if(check){
                        form.action = "/score/remove"
                        form.method = "POST"
                        var hiddenField = document.createElement('input');
                        hiddenField.setAttribute('type', 'hidden');
                        hiddenField.setAttribute('name', "studentNumber");
                        hiddenField.setAttribute('value', `${score.studentNumber}`);
                        form.appendChild(hiddenField);
                    }else{
                        form.action = "/score/detail"
                        form.method = "GET"
                        var hiddenField = document.createElement('input');
                        hiddenField.setAttribute('type', 'hidden');
                        hiddenField.setAttribute('name', "studentNumber");
                        hiddenField.setAttribute('value', `${score.studentNumber}`);
                        form.appendChild(hiddenField);
                    }
                    form.submit();
                }
                function returnList(){
                    let form = document.form;
                    form.action = "/score/list"
                    form.method = "GET"
                    form.submit();
                }
                </script>
        </body>
    </html>