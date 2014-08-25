<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="postMain">
	<c:forEach items="${postList}" var="post">
		<div class="postDiv">
			<div class="postDivHeader">
			<a href="${thisPagePath}/DetailPost?postId=${post.getId()}"><c:out
					value="${post.getTitle()}" /> (<c:out
					value="${post.getClass().getSimpleName()}"></c:out>)</a>
			<span class="dateLabel"><c:out value="${post.getDateToString()}"></c:out></span>
			</div>
			<div class="postDivContent">
			  <c:out value="${post.getContent()}"></c:out>
			</div>
		</div>
		
	</c:forEach>
</div>