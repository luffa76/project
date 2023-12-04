<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>상품 페이지</title>
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
        <section>
            <h3>상품 페이지</h3>
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
                    <c:set var="count" value="1"/>
                    <c:forEach items="${boardList}" var="item">
                        <tr onclick="window.location.href='boardInfoPage/${item.boardId}'">
                            <td><c:out value="${count}"/></td>
                            <td><c:out value="${item.title}"/></td>
                            <td><c:out value="${item.writerName}"/></td>
                            <td>
                                <fmt:parseDate value="${item.insertDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                                <fmt:formatDate value="${parsedDateTime}" pattern="yyyy년MM월dd일 hh:mm"/>
                            </td>
                        </tr>
                        <c:set var="count" value="${count+1}"/>
                    </c:forEach>
                </tbody>
            </table>

            <button type="button" onclick="window.location.href='boardInsertPage'">문의 등록</button>
        </section>
    </body>
</html>
