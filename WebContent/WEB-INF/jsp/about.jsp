<%@page import="entities.*"%>
<%@page import="models.*"%>
<%@page import="features.MyTime"%>
<%@page import="models.UserModel"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.MessageModel"%>
<%@page import="entities.Messages"%>
<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
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

<link rel="stylesheet" type="text/css"
	href="style.css" />

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


<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<link href="assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
<link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="assets/css/print.css" rel="stylesheet" type="text/css" media="print"/>

<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>

<title>About me</title>
</head>
<body style="background: url('http://juliewight.com/wp-content/uploads/2013/11/colorful-backgrounds-for-desktop.jpg') fixed;">
	<jsp:include page="/WEB-INF/includes/navigatorBarAbout.jsp"></jsp:include>
	<!-- *************END HEADER**************** -->
	<!-- Start WOWSlider.com BODY section -->
	<!-- add to the <body> of your page -->
<%
Users requestUser = (Users)request.getAttribute("user");
Users sessionUser = (Users)session.getAttribute("user");
List<Messages> inbox = new MessageModel().getByOwnerAndSender(requestUser.getId(),sessionUser.getId());

java.util.List<StudentBasic> basicList = new StudentBasicModel().getByStudentId(requestUser.getId());
%>
		<div class="row">
			<!-- LEFT BODY -->
			<div class="col-sm-3 col-md-1"></div>
			<div class="col-sm-3 col-md-7">
				<div class="thumbnail" align="left">
					<ul style="list-style: none;">
						<li>
							<!-- Ảnh đại diện và 1 số thông tin cơ bản -->
							<div class="row" align="left">
								<div class="col-sm-6 col-md-12">
									<div class="row" align="center">
										<div class="col-sm-6 col-md-4">
											<br> <img
												src="<%=request.getContextPath()%>/images/0.jpg"
												class="img-rounded"
												alt="Ảnh đại diện của ${requestScope.user.fullname}"
												width="200" height="200" align="left">
										</div>
										<div class="col-sm-6 col-md-8" align="left">
											<h3>
												<c:out value="${requestScope.user.fullname}" default="GUEST"></c:out>
											</h3>
											<p>
												<b>Giới tính :</b> <%=(basicList.get(0).getGender().equals("male"))?"Nam":"Nữ" %>
											</p>
											<p>
												<b>Ngày sinh : </b> <%=basicList.get(0).getBirthday() %>
											</p>
											<p>
												<b>Trường : </b> <%=basicList.get(0).getCollege() %>
											</p>
											<p>
												<b>Chuyên ngành : </b><%=basicList.get(0).getMajor() %>
											</p>
											<span>
												<button type="button" class="btn btn-info" data-toggle="modal"
												data-target="#messageModel" data-whatever="">Tin nhắn</button>
												<jsp:include page="/WEB-INF/includes/msgForm.jsp"></jsp:include>
											</span> &nbsp &nbsp  &nbsp &nbsp &nbsp
												<%
											if(sessionUser.getId() != requestUser.getId()){
												%>
												<span class="btn btn-info">
												<%
												int relStatus = new RelationshipModel().getStatusOfRel(sessionUser.getId(), requestUser.getId());
												System.out.print("**************"+relStatus+"*************");
												if(relStatus==1){
													out.print("Bạn bè");
												}else if(relStatus == 0){
													out.print("Đã gửi lời kết bạn");
												}else if(relStatus == 2){
													out.print("<a href='friend?action=add&user1Id="+sessionUser.getId()+"&user2Id="+requestUser.getId()+"'>Đồng ý</a>");
												}else {
													out.print("<a href='friend?action=add&user1Id="+sessionUser.getId()+"&user2Id="+requestUser.getId()+"'>Kết bạn</a>");
												}
											}
											%>
											
											</span>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<!-- Thanh điều hướng dưới ảnh đại diện -->
							<div class="row" align="left">
								<div class="col-sm-6 col-md-12">
									<ul class="nav nav-tabs" role="tablist" id="myTab">
										<li role="presentation" class="active"><a href="#profile"
											aria-controls="profile" role="tab" data-toggle="tab">
												<span class="text-success"><b>Thông tin</b></span></a></li>
										<li role="presentation"><a href="#home"
											aria-controls="home" role="tab" data-toggle="tab"><span class="text-success"><b>Dòng
												thời gian</b></span></a></li>
										<li role="presentation"><a href="#friendList"
											aria-controls="friendList" role="tab" data-toggle="tab"><span class="text-success"><b>Bạn bè</b></span></a></li>
										<li role="presentation"><a href="#inbox"
											aria-controls="inbox" role="tab" data-toggle="tab"><span class="text-success"><b>Hộp thư</b></span></a></li>
										<li role="presentation"><a href="#photos"
											aria-controls="photos" role="tab" data-toggle="tab"><span class="text-success"><b>Hình
												ảnh</b></span></a></li>
										
									</ul>
									<div class="tab-content">
										<div role="tabpanel" class="tab-pane" id="home"><jsp:include
												page="/WEB-INF/includes/timeLine.jsp"></jsp:include>
										</div>
										<div role="tabpanel" class="tab-pane" id="friendList">
											<div>
											<h1 class="text-primary">Danh sách bạn bè</h1>
											<%
												
												List<Integer> friendList = new RelationshipModel().getFriends(requestUser.getId());
												for(int id : friendList){
													Users fr = new UserModel().getById(id);
											%>
												<a class="btn btn-link" href="about?username=<%=fr.getUsername()%>"><%=fr.getFullname()%></a>
												<br>
											<%
												}
											%>
										</div>
										</div>
											<!-- Đây là cái khung post status, ảnh -->
										<div role="tabpanel" class="tab-pane active" id="profile"><jsp:include
												page="/WEB-INF/includes/profile.jsp"></jsp:include>
										</div>
										<div role="tabpanel" class="tab-pane" id="inbox"><jsp:include
												page="/WEB-INF/includes/inbox.jsp"></jsp:include>
										</div>
										<div role="tabpanel" class="tab-pane" id="photos">C</div>
									</div>

								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<!-- END LEFT BODY -->

			<!-- RIGHT BODY -->
			<div class="col-sm-3 col-md-2">
				<jsp:include page="/WEB-INF/includes/company.jsp"></jsp:include>
			</div>
			<div class="col-sm-3 col-md-2">
			</div>
			<!-- END RIGHT BODY -->
		</div>



</body>

</html>


