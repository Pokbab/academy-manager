<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/mgr.css" />
	<title>로그인 페이지</title>
</head>
<body>
    <h1>로그인</h1>
    <h4>${MESSAGE}</h4>
    <form id="loginForm" action="login.nhn" method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>PW</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="로그인">
                <input type="reset" value="취소">
            </td>
        </tr>
	</table>
	</form>
</body>
</html>