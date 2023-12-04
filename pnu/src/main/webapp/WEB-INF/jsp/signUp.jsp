<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            background-color: #f5f5dc; /* Beige background */
        }
		.form-container {
            width: 300px;
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
	<title>회원가입</title>
</head>
<body>
	<form action="signUp" method="post" id="signUpForm" class="form-container">
		<table>
			<thead>
				<tr class="fontsi">
					<th colspan="2">회원가입</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>아이디*</th>
					<td><input type="text" value="" name="userId" required="required"/></td>
				</tr>
				<tr>
					<th>비밀번호*</th>
					<td><input type="password" name="pwd" id="pwdInput" required="required"/></td>
				</tr>
				<tr>
					<th>비밀번호 확인*</th>
					<td><input type="password" id="pwdCheckInput" required="required"/></td>
				</tr>
				<tr>
					<th>이름*</th>
					<td><input type="text" value="" name="name" required="required"/></td>
				</tr>
				<tr>
					<th>부서*</th>
					<td>
						<select name="deptCd" required="required">
              <c:forEach items="${dept}" var="item">
                <option value="${item.deptCd}">${item.deptNm}</option>
              </c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<th>직급</th>
					<td><input type="text" value="" name="job"/></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" value="" name="phone"/></td>
				</tr>
				<tr>
					<th>메일</th>
					<td><input type="text" value="" name="email"/></td>
				</tr>
			</tbody>
		</table>
		
		<button type="button" onclick="window.history.back()">이전</button>
		<!-- <button type="button" id="okBtn">등록</button> -->
		<button type="submit">등록</button>
	</form>
</body>

<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script>
	
	window.onload = function(){
		
		$("#okBtn").click(function() {
			var pwd = $("#pwdInput").val();
			var pwdCheck = $("#pwdCheckInput").val();
			
			if(pwd == pwdCheck){
				$("#signUpForm").submit();
			} else {
				alert("비밀번호를 확인해주세요.");
			}
		});
	} 
	
</script>
</html>