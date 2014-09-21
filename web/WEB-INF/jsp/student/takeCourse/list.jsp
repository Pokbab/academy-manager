<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css/mgr.css" />
	<title>학생 페이지</title>
</head>
<body>
    <h1>${USER.id}의 페이지</h1>
    
    <h3>현재 수강중인 강의</h3>
    <table>
        <tr>
            <td>강의명</td>
            <td>학원</td>
            <td></td>
        </tr>
        <tr></tr>
        <c:forEach var="takeCourse" items="${list}">
        <tr>
            <td>${takeCourse.course.name}</td>
            <td>${takeCourse.course.academy.name}</td>
            <td><a href="remove.nhn?code=${takeCourse.code}">삭제</a></td>
        </tr>
        </c:forEach>
        <tr></tr>
        <tr>
            <td colspan="7"><a href="addForm.nhn">수강신청</a></td>
        </tr>
    </table>
</body>
</html>