<%@page import="features.MyTime"%>
<%@page import="entities.*"%>
<%@page import="models.*"%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8" />
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="assets/plugins/gritter/css/jquery.gritter.css"
	rel="stylesheet" type="text/css" />
<link
	href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/fullcalendar/fullcalendar/fullcalendar.css"
	rel="stylesheet" type="text/css" />
<link href="assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet"
	type="text/css" />
<link
	href="assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css"
	rel="stylesheet" type="text/css" />
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" />
<%
	Users sessionUsers = (Users)session.getAttribute("user");
	int sessionUserId = sessionUsers.getId();
%>
<nav class="navbar navbar-default navbar-fixed-top" style="color: black">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand " href="/${initParam['websiteName']}"> <img
				alt="Student Work"
				src="http://www.firebirdsql.org/file/about/ds-firebird-logo-500.png"
				height="30"> <strong style="size: 80px;">StudentWork</strong>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav" >
				<li><a href="/${initParam['websiteName']}/home"><b class="text-info" style="font-size: 15px">Trang chủ</b></a>
				<li><a href="/${initParam['websiteName']}/contactus"><b class="text-info" style="font-size: 15px">Liên hệ</b></a></li>
				<li><a href="/${initParam['websiteName']}/recruitment"><b class="text-info" style="font-size: 15px">Về chúng tôi</b></a></li>
			</ul>
			<ul class="nav navbar-nav pull-right">
				
				<!-- BEGIN NOTIFICATION DROPDOWN -->
								<li>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group" align="center">
							<input type="text" class="form-control" placeholder="Từ khóa tìm kiếm">
						</div>
						<button type="submit"class="btn btn-info glyphicon glyphicon-search" aria-label="Left Align"></button>
					</form>
				</li>
				<li class="dropdown" id="header_notification_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"><img alt="addFriends" src="<%=request.getContextPath()%>/images/icons/addfriend.png">
					<span class="badge"> <%=new RelationshipModel().getNumberRequest(sessionUserId) %> </span>
				</a>
					<ul class="dropdown-menu extended notification">
						<li>
							<p>Bạn có <%=new RelationshipModel().getNumberRequest(sessionUserId) %> lời mời kết bạn</p>
						</li>
						<li>
							
							<ul class="dropdown-menu-list scroller" style="height: 250px;">
								<%
									List<Integer> requestList = new RelationshipModel().getFriendRequests(sessionUserId);
									for(int id : requestList){
								%>
									<li><span
												class="label label-sm label-icon label-success"> <i
													class="fa fa-plus"></i>
													 
											</span> Nhét ảnh <%=new UserModel().getById(id).getFullname() %>
											<a href="friend?action=add" class="btn btn-info">Chấp nhận</a>
													 <a href="friend?action=del" class="btn btn-info">Xóa</a>
									</li>
								<%
									}
								%>
								
							</ul>
						</li>
						<li class="external"><a href="#"> Xem toàn bộ <i
								class="m-icon-swapright"></i>
						</a></li>
					</ul></li>
				<!-- END NOTIFICATION DROPDOWN -->
				<!-- BEGIN INBOX DROPDOWN -->
				<li class="dropdown" id="header_inbox_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> <img alt="messages" src="<%=request.getContextPath()%>/images/icons/message.png"> 
					<span class="badge"> <%=new MessageModel().getNumberOfUnread(sessionUserId)%> </span>
				</a>
					<ul class="dropdown-menu extended inbox">
						<%
						List<Messages> readList = new MessageModel().getReadAlready(sessionUserId);
						List<Messages> unreadList = new MessageModel().getUnread(sessionUserId);
						List<Messages> msgList = new MessageModel().getByOwnerId(sessionUserId);
							
						%>
						<li>
							<p>Bạn có <%=unreadList.size()%> tin nhắn mới</p>
						</li>
						<li>
							<ul class="dropdown-menu-list scroller" style="height: 250px;">
							
							<%
								for(Messages msg:unreadList){
							%>
								<li><a href="inbox.html?a=view"> <span class="photo">
											<img src="./assets/img/avatar2.jpg" alt="" />
									</span> <span class="subject"> <span class="from"> <%=new UserModel().getById(msg.getSenderId()).getFullname() %> </span> <span class="time"><%=MyTime.getTimePeriodFromNow(msg.getSendTime()) %></span>
									</span>
									<span class="message text-danger"><%=msg.getContent() %></span>
								</a></li>
							<%
								}
							for(Messages msg:readList){
								%>
									<li><a href="inbox.html?a=view"> <span class="photo">
												<img src="./assets/img/avatar2.jpg" alt="" />
										</span> <span class="subject"> <span class="from"> <%=new UserModel().getById(msg.getSenderId()).getFullname() %> </span> <span class="time"><%=MyTime.getTimePeriodFromNow(msg.getSendTime()) %></span>
										</span>
										<span class="message text-info"><%=msg.getContent() %></span>
									</a></li>
								<%
								}
							%>
							</ul>
						</li>
						<li class="external"><a href="inbox.html"> See all
								messages <i class="m-icon-swapright"></i>
						</a></li>
					</ul></li>
				<!-- END INBOX DROPDOWN -->
				<!-- BEGIN TODO DROPDOWN -->
				<li class="dropdown" id="header_task_bar"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"
					data-hover="dropdown" data-close-others="true"> <img alt="events" src="<%=request.getContextPath()%>/images/icons/event.png"><span class="badge"> 5 </span>
				</a>
					<ul class="dropdown-menu extended tasks">
						<li>
							<p>You have 12 pending tasks</p>
						</li>
						<li>
							<ul class="dropdown-menu-list scroller" style="height: 250px;">
								<li><a href="#"> <span class="task"> <span
											class="desc"> New release v1.2 </span> <span class="percent">
												30% </span>
									</span> <span class="progress"> <span style="width: 40%;"
											class="progress-bar progress-bar-success" aria-valuenow="40"
											aria-valuemin="0" aria-valuemax="100"> <span
												class="sr-only"> 40% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> Application deployment </span> <span
											class="percent"> 65% </span>
									</span> <span class="progress progress-striped"> <span
											style="width: 65%;" class="progress-bar progress-bar-danger"
											aria-valuenow="65" aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only"> 65% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> Mobile app release </span> <span
											class="percent"> 98% </span>
									</span> <span class="progress"> <span style="width: 98%;"
											class="progress-bar progress-bar-success" aria-valuenow="98"
											aria-valuemin="0" aria-valuemax="100"> <span
												class="sr-only"> 98% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> Database migration </span> <span
											class="percent"> 10% </span>
									</span> <span class="progress progress-striped"> <span
											style="width: 10%;" class="progress-bar progress-bar-warning"
											aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only"> 10% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> Web server upgrade </span> <span
											class="percent"> 58% </span>
									</span> <span class="progress progress-striped"> <span
											style="width: 58%;" class="progress-bar progress-bar-info"
											aria-valuenow="58" aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only"> 58% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> Mobile development </span> <span
											class="percent"> 85% </span>
									</span> <span class="progress progress-striped"> <span
											style="width: 85%;" class="progress-bar progress-bar-success"
											aria-valuenow="85" aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only"> 85% Complete </span>
										</span>
									</span>
								</a></li>
								<li><a href="#"> <span class="task"> <span
											class="desc"> New UI release </span> <span class="percent">
												18% </span>
									</span> <span class="progress progress-striped"> <span
											style="width: 18%;"
											class="progress-bar progress-bar-important"
											aria-valuenow="18" aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only"> 18% Complete </span>
										</span>
									</span>
								</a></li>
							</ul>
						</li>
						<li class="external"><a href="#"> See all tasks <i
								class="m-icon-swapright"></i>
						</a></li>
					</ul></li>
				<!-- END TODO DROPDOWN -->
				<!-- BEGIN USER LOGIN DROPDOWN -->
				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" data-hover="dropdown"
					data-close-others="true"> <img alt=""
						src="assets/img/avatar1_small.jpg" /> <span class="username">
							Bob Nilson </span> <i class="fa fa-angle-down"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="extra_profile.html"> <i class="fa fa-user"></i>
								Trang cá nhân
						</a></li>
						<li><a href="inbox.html"> <i class="fa fa-envelope"></i>
								Tin nhắn <span class="badge badge-danger"> 3 </span>
						<li><a href="logout"> <i class="fa fa-key"></i> Đăng xuất
						</a></li>
					</ul></li>
				<!-- END USER LOGIN DROPDOWN -->
			</ul>
			<!-- END TOP NAVIGATION MENU -->
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<br>
<br>
<br>
<br>
