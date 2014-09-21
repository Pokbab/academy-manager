<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/mgr.css" />
    <title>관리자 페이지</title>
</head>
<body>
	<h1>관리자 페이지</h1>
    
    <h3>유저정보 변경</h3>
	<form action="edit.nhn" method="POST">
	<table>
        <tr>
            <td>아이디</td>
            <td><input type="hidden" name="id" value="${user.id}">${user.id}</td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>비밀번호 확인</td>
            <td><input type="password" name="pw_check"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="hidden" name="name" value="${user.name}">${user.name}</td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="text" name="age" value="${user.age}"></td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><input type="text" name="phone" value="${user.phone}"></td>
        </tr>
        <tr>
            <td>유저타입</td>
            <td>
                <c:if test="${user.type == 'M'}">
                    <input type="radio" name="type" value="M" checked>관리자
                    <input type="radio" name="type" value="A">수강생
                </c:if>
                <c:if test="${user.type == 'A'}">
                    <input type="radio" name="type" value="M">관리자
                    <input type="radio" name="type" value="A" checked>수강생
                </c:if>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="변경하기">
                <input type="button" value="뒤로" onclick="history.back();">
            </td>
        </tr>
    </table>
	</form>

</body>
</html>
