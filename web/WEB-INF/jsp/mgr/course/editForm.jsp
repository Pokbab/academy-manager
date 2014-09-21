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
    
    <h3>강의정보 수정</h3>
	<form action="edit.nhn" method="POST">
	<table>
        <tr>
            <td>강의명</td>
            <td><input type="text" name="name" value="${course.name}"></td>
        </tr>
        <tr>
            <td>학원</td>
            <td>
                <select name="academy.code">
                    <option value="s1">--선택해주세요--</option>
                    <c:forEach var="academy" items="${list}">
                        <c:if test="${course.academy.code == academy.code}">
                            <option value="${academy.code}" selected>${academy.name}</option>
                        </c:if>
                        <c:if test="${course.academy.code != academy.code}">
                            <option value="${academy.code}">${academy.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
        	<td colspan="2">
            	<input type="hidden" name="code" value="${course.code}">
            	<input type="submit" value="변경하기">
            	<input type="button" value="뒤로" onclick="history.back();">
            </td>
        </tr>
    </table>
	</form>

</body>
</html>
