<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<style>
		fieldset {
			width: 400px;
			height: 150px;
            padding: 0 10px;
            box-sizing: border-box;
            margin-bottom: 16px;
            border-radius: 6px;
            background-color: #F8F8F8;
		}
		
		legend {
			font-weight: bold;
		}
		h1{
            text-align: center;
        }
		#center {
            width: 100%;
            height: 30%; 
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .t{
            font-style: italic;
            text-align: center;
        }
	</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
</head>
<body>
	<div>
		<h1>Login Page</h1>
	</div>
	<form action="login" method="post" id="center">
		<fieldset>
			<legend>Login</legend>
			<table style="text-align: center;">
				<tr>
					<th>ID</th>
					<td><input type="text" id="user_id" name="userId" placeholder="ID를 입력해주세요"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id="user_pw" name="pwd" placeholder="비밀번호를 입력해주세요"></td>
				</tr>
			</table>
			<br>
			<div>
				<button type="button" onclick="window.location.href='signUpPage'">회원가입</button>
				<button type="submit">로그인</button>
			</div>
		</fieldset>
	</form>
</body>
</html>