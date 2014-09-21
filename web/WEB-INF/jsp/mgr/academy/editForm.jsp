<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/mgr.css" />
    <title>관리자 페이지</title>
</head>
<body>
	<h1>관리자 페이지</h1>
    
    <h3>학원정보 수정</h3>
	<form action="edit.nhn" method="POST">
	<table>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${academy.name}"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" value="${academy.phone}"></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="address" value="${academy.address}"></td>
        </tr>
        <tr>
            <td colspan="2">
            	<input type="hidden" name="code" value="${academy.code}">
            	<input type="submit" value="변경하기">
            	<input type="button" value="뒤로" onclick="history.back();">
            </td>
        </tr>
    </table>
	</form>

</body>
</html>
