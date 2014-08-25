<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
	function postTypeSecildi(node) {
		var elm = document.getElementById('postUrl');
		elm.disabled = node.value == 'text'
		if (node.value == 'text') {
			elm.value = "";
		}
	}
</script>
<c:if test="${isLoggedin}">
	<form action="${pageContext.request.contextPath}/PostCreat"
		method="post">
		<input type="text" name="title" placeholder="Title" width="100"> <br>
		<select name="postType" onchange="postTypeSecildi(this)" placeholder="type" width="100">
			<option value="">-</option>
			<option value="text">Text</option>
			<option value="img">İmg</option>
			<option value="video">Video</option>
		</select></br>
		 <input type="text" name="url" id="postUrl" placeholder="url"  width="100"/></br>
		<textarea name="concent" rows="3" cols="" placeholder="Concent" width="100"></textarea>
		<button type="submit">Create a Post</button>
	</form>
</c:if>
<c:if test="${not isLoggedin}">
	Lütfen giriş Yapınız. <a href="${pageContext.request.contextPath}/Home">Go to home page</a>
</c:if>
<c:if test="${isSucces}">
	<span style="color:green"><c:out value="${message}"></c:out></span>
	<a href="${pageContext.request.contextPath}/Home">Go to home page</a>
</c:if>

<c:if test="${not isSucces}">
	<span style="color:red"><c:out value="${message}"></c:out></span>
</c:if>