<%-- 
    Document   : about
    Created on : Feb 21, 2015, 8:53:56 AM
    Author     : HongSon
--%>

<%@page import="models.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Xin chao <c:out value="${requestScope.user.fullname}" default="GUEST"></c:out>  </h1>
	<%=(Object)request.getAttribute("user") %>
	<%
		
	%>
	<br /> ${requestScope.user.email}
	<br /> ${requestScope.user.password}
	<br /> ${requestScope.user.name}
	<br /> ${requestScope.user.birthday}
	<br /> ${requestScope.user.gender}
	<br /> ${requestScope.user.address}
	<br /> ${requestScope.user.avatar}
	<br /> ${requestScope.user.website}
</body>

</html>
