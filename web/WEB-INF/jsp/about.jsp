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
              href="<%=request.getContextPath()%>/css/style.css" />

        <link rel="stylesheet" type="text/css"
              href="<%=request.getContextPath()%>/css/form_status.css" />

        <link rel="stylesheet" type="text/css"
              href="<%=request.getContextPath()%>/css/users-activity.css" />

        <!-- Latest compiled and minified JavaScript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>

        <script type="text/javascript" src="<%=request.getContextPath()%>/js/seemore.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
        <title>About me</title>
    </head>
    <body style="background: url('http://juliewight.com/wp-content/uploads/2013/11/colorful-backgrounds-for-desktop.jpg') fixed;">

        <div class="header container">
            <div class="row">
                <div class="col-sm-6 col-md-12">
                    <jsp:include page="/WEB-INF/includes/navigatorBar1.jsp"></jsp:include>
                    </div>
                </div>
            </div>
            <!-- *************END HEADER**************** -->
            <!-- Start WOWSlider.com BODY section -->
            <!-- add to the <body> of your page -->

            <div class="container" >
                <div class="row" >
                    <!-- LEFT BODY -->
                    <div class="col-sm-6 col-md-8">
                        <div class="thumbnail" align="left">
                            <ul style="list-style: none;">
                                <li>
                                    <!-- Ảnh đại diện và 1 số thông tin cơ bản -->
                                    <div class="row" align="left">
                                        <div class="col-sm-6 col-md-12">
                                            <div class="row" align="center">
                                                <div class="col-sm-6 col-md-4">
                                                    <br>
                                                    <img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="200" height="200" align="left">
                                            </div>
                                            <div class="col-sm-6 col-md-8" align="left">
                                                <h3><c:out value="${requestScope.user.fullname}" default="GUEST"></c:out></h3>
                                                    <p><b>Giới tính :</b> Nam</p>
                                                    <p><b>Ngày sinh : </b>1994</p>
                                                    <p><b>Trường : </b>Đại học Công Nghệ - ĐHQGHN</p>
                                                    <p><b>Chuyên ngành : </b>Khoa học máy tính </p>
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
                                                <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Dòng thời gian</a></li>
                                                <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab"> Thông tin</a></li>
                                                <li role="presentation"><a href="#photos" aria-controls="photos" role="tab" data-toggle="tab">Hình ảnh</a></li>
                                                <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Tin nhắn</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div role="tabpanel" class="tab-pane active" id="home"><jsp:include page="/WEB-INF/includes/post_status_frame.jsp"></jsp:include> <!-- Đây là cái khung post status, ảnh --></div>
                                            <div role="tabpanel" class="tab-pane" id="profile"><jsp:include page="/WEB-INF/includes/profile.jsp"></jsp:include></div>
                                                <div role="tabpanel" class="tab-pane" id="photos">C</div>
                                                <div role="tabpanel" class="tab-pane" id="settings">D</div>
                                            </div>

                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- END LEFT BODY -->
                <jsp:include page="/WEB-INF/includes/company.jsp"></jsp:include>
                <!-- RIGHT BODY -->

                <!-- END RIGHT BODY -->
            </div>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('.status').click(function () {
                    $('.arrow').css("left", 0);
                });
                $('.photos').click(function () {
                    $('.arrow').css("left", 146);
                });
            });
            $('#myTab a').click(function (e) {
                e.preventDefault()
                $(this).tab('show')
            });
            $('#myTab a[href="#profile"]').tab('show') // Select tab by name
            $('#myTab a:first').tab('show') // Select first tab

        </script>

    </body>

</html>


