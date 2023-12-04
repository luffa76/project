<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>고객센터</title>
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
            <h3>문의글 상세</h3>
            <table style="width: 50%;">
                <tr>
                    <th>제목</th>
                    <td><c:out value="${center.title }"></c:out></td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td><c:out value="${center.writerName }"></c:out></td>
                </tr>
                <tr>
                    <th>등록날짜</th>
                    <td>
                        <fmt:parseDate value="${center.insertDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                        <fmt:formatDate value="${parsedDateTime}" pattern="yyyy년MM월dd일 hh:mm"/>
                    </td>
                </tr>
                <c:if test="${not empty center.updateDate}">
                    <tr>
                        <th>최종 수정 날짜</th>
                        <td>
                            <fmt:parseDate value="${center.updateDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime2" type="both" />
                            <fmt:formatDate value="${parsedDateTime2}" pattern="yyyy년MM월dd일 hh:mm"/>
                        </td>
                    </tr>
                </c:if>
                <tr>
                    <th>내용</th>
                    <td style="width: 90%; height: 100px;"><c:out value="${center.contents }"></c:out></td>
                </tr>
            </table>
            <br>
            <div style="display: flex;">
                <button type="button" onclick="history.back(); return false;"> 이전 </button>
                
                <c:if test="${center.writerId == USER.userId }">
                    <form action="${pageContext.request.contextPath}/centerUpdatePage" method="post">
                        <input type="hidden" name="centerId" value="${center.centerId}"/>
                        <button type="submit">수정</button>
                    </form>

                    <form action="${pageContext.request.contextPath}/centerDelete" method="post">
                        <input type="hidden" name="centerId" value="${center.centerId}"/>
                        <button type="submit">삭제</button>
                    </form>
                </c:if>
            </div>
        </section>
    </body>
</html>