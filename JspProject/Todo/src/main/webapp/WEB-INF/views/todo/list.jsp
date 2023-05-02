<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Todo LIST</h1>

<ul>
	<!-- get 방식 -->
	<c:forEach items="${todoList}" var="todo">
	
		<li><a href="${pageContext.request.contextPath}/todo/read?no=${todo.tno}">
		<!-- todo.tno -> todo는 setAttribute한 이름, tno는 객체에서 getTno의 이름 -->
		${todo.tno}. ${todo.todo} </a> ${todo.duedate} ${todo.finished ? 'DONE' : 'NOT YET'}
		</li>
		
	</c:forEach>
</ul>


<a href="${pageContext.request.contextPath}/todo/register">Todo Register</a>

</body>
</html>