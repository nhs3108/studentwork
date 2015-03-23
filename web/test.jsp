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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/jsp/jquery.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>About me</title>
</head>
<body>
	
	<div class="header">
		<jsp:include page="/WEB-INF/includes/navigatorBar.jsp"></jsp:include>
		<!-- *************START ROW**************** -->
			
	</div>
		<!-- *************END ROW**************** -->
		<!-- #######################################  -->
	<!-- *************END HEADER**************** -->
	<!-- Start WOWSlider.com BODY section -->
	<!-- add to the <body> of your page -->
	
	<div class="container">
		<div class="row">
		<!-- LEFT BODY -->
  			<div class="col-sm-6 col-md-8">
    			<div class="thumbnail" align="left">
    				<ul style="list-style: none;">
	      				<li>
	      					<div class="row" align="left">
							  <div class="col-sm-6 col-md-12">
							  	<div class="row" align="center">
							  		<div class="avatar" align="left">
							  			<img src="images/0.jpg" alt="Avatar" align="left" width="200" height="200">
							  		</div>
							     	<div align="left">
  										<h2>
  											<c:out value="${requestScope.user.fullname}" default="GUEST"></c:out>
											<%=(Object)request.getAttribute("user") %>
  										</h2>
  										<p>Name,Age, University</p>
  										<p>Languages</p>
  										
  										<!-- Click show more information -->
  										<button id="showmenu_profile" class="btn btn-primary" role="button">See more</button>
											<div class="profile" style="display: none;">
											<ul style="list-style: none;">
												<li>Name: </li>
												<li>Age:</li>
												<li>Address:</li>
											</ul>
										</div>
										<script>
										$(document).ready(function() {
        									$("#showmenu_profile").click(function() {
                								$(".profile").slideToggle("fast");
        									});
   										});
										</script>
										<!-- End -->
									</div>
								</div>						     
							   </div>
							 </div>  
						</li>
						<br>
						<li>
							<div class="row">
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Summary</h3>
							        	<!-- Click to show more information -->
							        	<button id="showmenu_summary" class="btn btn-primary" role="button">See more</button>
											<div class="summary" style="display: none;">
											<ul>
												<li>Name: </li>
												<li>Age:</li>
												<li>Address:</li>
											</ul>
										</div>
										<script>
										$(document).ready(function() {
        									$("#showmenu_summary").click(function() {
                								$(".summary").slideToggle("fast");
        									});
   										});
										</script>
										
										<!-- Click add more ionformation -->
										<!-- Button trigger modal -->
										<button class="btn-primary btn" role="button" data-toggle="modal" data-target="#myModal">
										  Add more
										</button>
										
										<!-- Modal -->
										<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										        <h4 class="modal-title" id="myModalLabel">Add what?</h4>
										      </div>
										      <div class="modal-body">
												  <form role="form">
												    <div class="form-group">
												      <label for="comment">Add</label>
												      <textarea class="form-control" rows="5" id="comment"></textarea>
												    </div>
												  </form>									        
										      </div>
										      <div class="modal-footer">
										        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										        <button type="button" class="btn btn-primary">Save changes</button>
										      </div>
										    </div>
										  </div>
										</div>
							      </div>
							    </div>
							  </div>
							  <!-- End summary -->
							  
							  <!-- Skills -->
							  
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Skills</h3>
							        	<button id="showmenu2" class="btn btn-primary" role="button">See more</button>
											<div class="skills" style="display: none;">
											<ul>
												<li>Skill 1: </li>
												<li>Skill 2:</li>
												<li>Skill 3:</li>
											</ul>
										</div>
										<script>
										$(document).ready(function() {
        									$("#showmenu2").click(function() {
                								$(".skills").slideToggle("fast");
        									});
   										});
										</script>
							        
							      </div>
							    </div>
							  </div>
							  <!-- End skills -->
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Volunteer</h3>
							        	<button id="showmenu3" class="btn btn-primary" role="button">See more</button>
											<div class="volunteer" style="display: none;">
											<ul>
												<li>Experience 1 </li>
												<li>Experience 2 </li>
												<li>Experience 3 </li>
											</ul>
										</div>
										<script>
										$(document).ready(function() {
        									$("#showmenu3").click(function() {
                								$(".volunteer").slideToggle("fast");
        									});
   										});
										</script>					        
							      </div>
							    </div>
							  </div>
							</div>
						</li>
						<li>
							<div class="row">
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Thumbnail label</h3>
							        <p>...</p>
							        <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
							      </div>
							    </div>
							  </div>
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Thumbnail label</h3>
							        <p>...</p>
							        <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
							      </div>
							    </div>
							  </div>
							  <div class="col-sm-6 col-md-4">
							    <div class="thumbnail">
							      <img src="..." alt="...">
							      <div class="caption">
							        <h3>Thumbnail label</h3>
							        <p>...</p>
							        <p><a href="#" class="btn btn-primary" role="button">Button</a></p>
							      </div>
							    </div>
							  </div>
							</div>
						</li>
					</ul>
    			</div>
  			</div>
  			
  			<!-- END LEFT BODY -->
  			<!-- RIGHT BODY -->
  			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
      				<img src="..." alt="...">
      				<div class="caption">
       					<h3>Company</h3>
        					<p>List company</p>
        					<p><a href="#" class="btn btn-primary" role="button">See more</a>
      				</div>
    			</div>
  			</div>
  			<!-- END RIGHT BODY -->
  		</div>
	</div>
	
	
	
	
	<h2 align="center">Xin chao <c:out value="${requestScope.user.fullname}" default="GUEST"></c:out>  </h2>
	<%=(Object)request.getAttribute("user") %>
	<%
		
	%>
	<br /> ${requestScope.user.username}
	<br /> ${requestScope.user.email}
	<br /> ${requestScope.user.fullname}
	<br /> ${requestScope.user.phone}
	<br /> ${requestScope.user.address}
	<br /> ${requestScope.user.avatar}
	<br /> ${requestScope.user.lastLogin}
	<br /> ${requestScope.user.lastActivity}
	<br /> ${requestScope.user.activation}
</body>

</html>
