<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<c:out value="${message}"></c:out>
<c:if test="${isUserRegistry}">
	<a href="${pageContext.request.contextPath}/Home">Go to Home Page</a>
</c:if>