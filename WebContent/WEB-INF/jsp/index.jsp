<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:set var="thisPagePath" scope="application"
	value="${pageContext.request.contextPath}" />
<c:if test="${includePageName != null}">
	<c:set var="includePageName" scope="page" value="${includePageName}" />
</c:if>
<c:if test="${includePageName == null}">
	<c:set var="includePageName" scope="page" value="postList.jsp" />
</c:if>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:if test="${not isLoggedin}">
	</c:if> <c:if test="${isLoggedin}">
		<c:out value="${user.getUserName()}"></c:out>
	</c:if></title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="userPanel" class="panel">

		<c:if test="${not isLoggedin}">
			<form action="Login" method="post">
				<input name="username" type="text" placeholder="User Name" /></br> <input
					name="password" type="password" placeholder="Password" /></br>
				<button type="submit">Login</button>
				<a href="${thisPagePath}/UserRegistry">Sign in</a>
			</form>
			<span style="color: red;"><c:out value="${message}"></c:out></span>
		</c:if>
		<c:if test="${isLoggedin}">
		Welcome, <c:out value="${user.getUserName()}"></c:out>
			<div>
				<img src="${user.getProfilePhotoUrl()}" width="200" height="300" style="border: 1px solid gray" />
			</div>
			</br>
			<div>
				<ul class="menu">
					<li><a href="${thisPagePath}/Home">Home Page </a></li>
					<li><a href="#">My Profile </a></li>
					<li><a href="#">My List Of Post</a></li>
					<li><a href="${thisPagePath}/PostCreat">Create Post</a></li>
					<li><a href="${thisPagePath}/Logout">Logout</a></li>
				</ul>
			</div>
		</c:if>
	</div>
	<div id="mainPanel" class="panel">
		</br>
		<jsp:include page="${includePageName}">
			<jsp:param name="fromMasterPage" value="true" />
		</jsp:include>
	</div>
</body>
</html>