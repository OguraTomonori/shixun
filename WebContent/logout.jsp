<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="${pageContext.request.contextPath }/js/cookie.js"></script>
<script>
	delCookie("userID");
	delCookie("sessionID");
	delCookie("permission");
	delCookie("username");
	document.location.href="index.jsp";
</script>
</body>
</html>