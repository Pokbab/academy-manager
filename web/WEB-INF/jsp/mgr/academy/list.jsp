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
    
    <h3>학원관리</h3>
    <table>
        <tr>
            <td>이름</td>
            <td>전화번호</td>
            <td>주소</td>
            <td colspan="2"></td>
        </tr>
        <tr></tr>
        <c:forEach var="academy" items="${list}">
        <tr>
            <td>${academy.name}</td>
            <td>${academy.phone}</td>
            <td>${academy.address}</td>
            <td><a href="editForm.nhn?code=${academy.code}">수정</a></td>
            <td><a href="remove.nhn?code=${academy.code}">삭제</a></td>
        </tr>
        </c:forEach>
        <tr></tr>
        <tr>
            <td colspan="5">
            	<a href="addForm.nhn">추가</a>
            	<a href="../manager.nhn">메뉴</a>
            </td>
        </tr>
    </table>
</body>
</html>