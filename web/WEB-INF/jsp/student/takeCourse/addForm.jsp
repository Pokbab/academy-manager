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
    
    <h3>수강 신청</h3>
	<form action="add.nhn" method="POST">
	<table>
	    <tr>
            <td>강의명</td>
            <td>학원명</td>
            <td></td>
        </tr>
        <c:forEach var="course" items="${list}">
        <tr>
            <td>${course.name}</td>
            <td>${course.academy.name}</td>
            <td><a href="add.nhn?code=${course.code}">등록하기</a></td>
        </tr>
        </c:forEach>
        <tr>
        	<td colspan="3">
        		<input type="button" value="뒤로" onclick="history.back();">
        	</td>
        </tr>
    </table>
	</form>

</body>
</html>
