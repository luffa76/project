<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>문의 등록</title>
    </head>
    <body>
        <header>
            <div style="display: flex; border-bottom: 1px solid black">
                <h5>[<c:out value="${USER.name}"></c:out>]님 반갑습니다.</h5>
                <div style="margin: auto;">
                    <button type="button" onclick="window.location.href='${pageContext.request.contextPath}/logout'"> 로그아웃 </button>
                </div>
            </div>
        </header>
        <form action="boardInsert" method="post">
            <input type="hidden" name="writerId" value="${USER.userId}"/>
            <table>
                <tr>
                    <th>작성자</th>
                    <td>${USER.name}</td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="contents" required></textarea></td>
                </tr>
            </table>
            <button type="button" onclick="history.back(); return false;"> 이전 </button>
            <button type="submit">등록</button>
        </form>
    </body>
</html>