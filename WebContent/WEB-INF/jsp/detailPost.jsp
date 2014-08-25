<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<c:if test="${post == null}">
	<span>Post Bulunamadı..</span>
</c:if>
<c:if test="${post != null}">
	<div class="postDiv">
		<div class="postDivHeader">
			<span><c:out value="${post.getTitle()}" />
			(<c:out value="${post.getClass().getSimpleName()}"></c:out>)</span>
			<span class="dateLabel"><c:out value="${post.getDateToString()}"></c:out></span>
		</div>
		<div class="postDivContent">
			<c:out value="${post.getContent()}"></c:out>
		</div>
	</div>
	<c:if test="${post.getClass().getSimpleName() eq 'ImagePost'}">
		<img src="${post.getUrl()}" />
	</c:if>
	<c:if test="${post.getClass().getSimpleName() eq 'VideoPost'}">
		<video width="320" height="240" controls>
			<source src="${post.getUrl()}" type="video/mp4">
		</video>
	</c:if>
</c:if>