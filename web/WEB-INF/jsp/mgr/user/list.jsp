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
    
    <h3>유저관리</h3>
    <table>
        <tr>
            <td>ID</td>
            <td>이름</td>
            <td>나이</td>
            <td>전화번호</td>
            <td>유저타입</td>
            <td colspan="2"></td>
        </tr>
        <tr></tr>
        <c:forEach var="user" items="${list}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.phone}</td>
            <td>
                <c:if test="${user.type == 'M'}">관리자</c:if>
                <c:if test="${user.type == 'A'}">수강생</c:if>
            </td>
            <td><a href="editForm.nhn?id=${user.id}">수정</a></td>
            <td><a href="remove.nhn?id=${user.id}">삭제</a></td>
        </tr>
        </c:forEach>
        <tr></tr>
        <tr>
            <td colspan="7">
            	<a href="addForm.nhn">추가</a>
            	<a href="../manager.nhn">메뉴</a>
            </td>
        </tr>
    </table>
</body>
</html>