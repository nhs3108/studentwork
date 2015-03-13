<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Không tìm thấy trang</title>
</head>
<body>
	<div class="header">
		<jsp:include page="/WEB-INF/includes/navigatorBar.jsp"></jsp:include>
	</div>
	<div class="container bg-success">
		<div class=row>
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h3 class="text-warning">Không thể tìm thấy trang được yêu cầu! Vui lòng kiểm tra lại</h3>
			</div>
			<div class="col-md-3"></div>
			
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/includes/loginForm.html"></jsp:include>
	<jsp:include page="/WEB-INF/includes/signUpForm.html"></jsp:include>
</body>
</html>