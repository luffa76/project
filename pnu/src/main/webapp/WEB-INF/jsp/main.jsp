<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <style>
    body{
      background-color: beige;
      display: flex;
      justify-content: center; /* Center horizontally */
      align-items: center; /* Center vertically */
      height: 100%; /* Set the height of the body to the viewport height */
      margin: 0; /* Remove default margin */
      font-family: Arial, sans-serif; /* Optional: Set a font */
    }
    .form-container {
        width: 400px;
        padding: 10px;
        border-radius: 15px; /* Rounded corners */
        background-color: white;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Adding a shadow effect */
        margin-top: 30px;
      }
    .fontsi {
        text-align: center;
        font-size: 25px;
      }
  </style>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>메인화면</title>
</head>
<body>
  <div class="form-container">
    <h1>[<c:out value="${USER.name}"></c:out>]님 반갑습니다.</h1>
    <h1>id : <c:out value="${USER.userId}"></c:out></h1>
    <h1>deptNm : <c:out value="${USER.deptNm}"></c:out></h1>
    <h1>email : <c:out value="${USER.email}"></c:out></h1>
    <h1>job: <c:out value="${USER.job}"></c:out></h1>
    <h1>phone: <c:out value="${USER.phone}"></c:out></h1>
  
    <button type="button" onclick="window.location='logout'">로그아웃</button>
    <button type="button" onclick="window.location='userUpdatePage'">회원정보 수정</button>
    <button type="button" onclick="window.location='boardListPage'">게시판</button>
    <button type="button" onclick="window.location='noticeListPage'">공지사항</button>
  </div>
</body>
</html>