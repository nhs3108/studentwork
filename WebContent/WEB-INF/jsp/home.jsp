<%@page import="entities.*"%>
<%@page import="models.*"%>
<%@page import="features.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/form_status.css" />
<link type="text/css" rel="stylesheet"
	href="dreamcodes/comment_boxes/css/tsc_comment_boxes.css" />

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/users-activity.css" />

<!-- Latest compiled and minified JavaScript -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/seemore.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>

<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>


<title>Home</title>
</head>
<body style="background-color: #F2F2F2">
<%
	Users sessionUser = (Users)session.getAttribute("user");
%>
	<jsp:include page="/WEB-INF/includes/navigatorBarAbout.jsp"></jsp:include>

	<!-- *************END HEADER**************** -->
	<!-- Start WOWSlider.com BODY section -->
	<!-- add to the <body> of your page -->
	<div class="container">
		<div class="row">
			<!-- LEFT BODY -->
			<div class="col-md-2"  >
				<ul style="list-style: none;" align="left">
					<li><a href="/${initParam['websiteName']}/about"><img alt="" src="assets/img/avatar1_small.jpg" /><b style="font-size: 13px">Trang cá nhân</b></a></li>
					<br>
					<li><span class="glyphicon glyphicon-globe" aria-hidden="true">&nbsp<a href="#"><b>Thông báo</b></a></span></li>
					<li><span class="glyphicon glyphicon-envelope" aria-hidden="true">&nbsp<a href="#"><b>Tin nhắn</b></a></span></li>
					<li><span class="glyphicon glyphicon-picture" aria-hidden="true">&nbsp<a href="#"><b>Hình ảnh</b></a></span></li>
					<li><span class="glyphicon glyphicon-list-alt" aria-hidden="true"><b>La gi chua biet</b></a></span></li>
				</ul>
			</div>
			<!-- END LEFT BODY -->
			<!-- BODY -->
			<div class="col-md-6">
				<div class="thumbnail">
					<div class="tab-content">
						<div role="tab panel" class="tab-pane active" id="home"><jsp:include
								page="/WEB-INF/includes/postNewStatus.jsp"></jsp:include></div>
					</div>
				</div>
				<div>
					<%
						List<Integer> friendList = new RelationshipModel().getFriends(sessionUser.getId());
						List<StudentPosts> postList = new StudentPostModel().getAll();
						for(StudentPosts sp: Reversed.reversed(postList)){
							if(friendList.contains(sp.getStudentId())){
								out.print("<b>"+new UserModel().getById(sp.getStudentId()).getFullname()+"</b>");
								out.println("<i>"+sp.getContent()+"</i>");
								out.println("<i>"+sp.getTime()+"</i>");
								out.println("<br>");
							}
							out.println("<br>");
							out.println("<br>");
						}
						
					%>
				</div>
			</div>
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/includes/listPeopleMayKnow.jsp"></jsp:include>
			</div>
			<!-- END OF BODY -->

			<!-- RIGHT BODY -->
			<div class="col-md-2">
				<jsp:include page="/WEB-INF/includes/company.jsp"></jsp:include>
			</div>
			<!-- END RIGHT BODY -->

		</div>
	</div>

</body>

</html>


