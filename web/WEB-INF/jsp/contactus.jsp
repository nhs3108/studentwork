<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<!-- Style for Slideshow -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/imageSliderData/engines/style.css" />
<!-- Latest compiled and minified JavaScript -->
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/jquery.js"></script>
	
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/seeMore.js"></script>
	
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>${initParam['indexTitle']}</title>
</head>

<body>
	<div class="header">
		<jsp:include page="/WEB-INF/includes/navigatorBar.jsp"></jsp:include>

		<!-- *************START ROW**************** -->
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
			<div class="col-md-3"></div>
		</div>
		<!-- *************END ROW**************** -->
		<!-- #######################################  -->



	</div>
	<!-- *************END HEADER**************** -->
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4" align="center">
			<p class="${requestScope.msgClass}">${requestScope.message}</p>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<form class="" action="postFeedback" method="post">
			  <label for="inputArea">Vui lòng đóng góp những ý kiến, thắc mắc</label>
			  <div class="form-group">
			    <textarea class="form-control" rows="6" id="content" name="content"></textarea>
			  </div>
			  <button type="submit" class="btn btn-success pull-right">Gửi</button>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	<div class="row">
		<jsp:include page="/WEB-INF/includes/footer.jsp"></jsp:include>
	</div>
	<!-- *************START LOGIN FORM, SIGN UP FORM  -->
	<!-- THEY WILL BE SHOW WHEN ITS LINK ON NAVIGATOR IS CLICKED -->
	<jsp:include page="/WEB-INF/includes/loginForm.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/includes/signUpForm.jsp"></jsp:include>
	<!-- ***********END LOGIN AND SIGN UP FORM****************** -->
	
</body>
</html>