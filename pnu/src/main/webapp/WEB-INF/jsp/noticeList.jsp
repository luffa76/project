<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>공지사항</title>
    </head>
    <body>
        <section>
            <h3>공지사항</h3>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>등록날짜</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${noticeList}" var="item">
                        <tr>
                            <td><c:out value="${item.noticeId}"/></td>
                            <td><c:out value="${item.noticetitle}"/></td>
                            <td><c:out value="${item.writerName}"/></td>
                            <td><fmt:formatDate value="${item.insertDate}" pattern="yyyy년MM월dd일 hh:mm"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
    </body>
</html>
