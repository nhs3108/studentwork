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

        <!-- Latest compiled and minified JavaScript -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/about.js"></script>
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
                    <!-- *************START ROW**************** -->
                </div>
            </div>
            <!-- *************END ROW**************** -->
            <!-- #######################################  -->
            <!-- *************END HEADER**************** -->
            <!-- Start WOWSlider.com BODY section -->
            <!-- add to the <body> of your page -->

            <div class="container" >
                <div class="row" >
                    <!-- LEFT BODY -->
                    <div class="col-sm-6 col-md-8">
                        <div class="thumbnail" align="left" style="background-color: #F2F5A9;">
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
                                                    <p><b>Ngày sinh : </b>1993</p>
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
                                            <nav class="navbar navbar-default ">
                                                <div class="container-fluid">
                                                    <div class="navbar-header">
                                                        <ul class="nav nav-pills">
                                                            <li role="presentation" class="active"><a href="#"><b>Tổng quan</b></a></li>
                                                            <li role="presentation"><a href="#"><b>Hình ảnh</b></a></li>
                                                            <li role="presentation"><a href="#"><b>Bạn bè</b></a></li>
                                                            <li role="presentation"><a href="#"><b>Mối quan tâm</b></a></li>
                                                            <li role="presentation" class="dropdown">
                                                                <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false"><b>Thêm</b> <span class="caret"></span></a>
                                                                <ul class="dropdown-menu" role="menu">
                                                                    <ul class="nav nav-pills">
                                                                        <li role="presentation"><a href="#"><b>Nhóm tham gia</b></a></li>
                                                                        <li role="presentation"><a href="#"><b>Sự kiện tham gia</b></a></li>
                                                                        <li role="presentation"><a href="#"><b>Cài đặt tài khoản</b></a></li>
                                                                        <li role="presentation"><a href="#"><b>Đăng xuất</b></a></li>
                                                                    </ul>
                                                                </ul>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </nav>
                                        </div>
                                    </div>
                                </li>

                                <li>
                                    <!-- Khung up status, ảnh -->
                                    <div class="row" align="left">
                                        <div class="col-sm-6 col-md-12">
                                            <form action="#" method="post" role="form" enctype="multipart/form-data" class="facebook-share-box" style="background-color:#FAFAFA;">
                                                <ul class="post-types">
                                                    <li class="post-type">
                                                        <img alt="status" src="<%=request.getContextPath()%>/images/share_post.png"  style="width: 20px;height: 20px" align="left"><a href="#"><b>Status</b></a>
                                                </li>
                                                <li class="post-type">
                                                    <img alt="Upload photo" src="<%=request.getContextPath()%>/images/photos_icon.png" style="width: 20px;height: 20px"><a href="#"><b>Add photos/Videos</b></a>
                                                </li>
                                            </ul>
                                            <div class="share">
                                                <div class="arrow"></div>
                                                <div class="panel panel-default">
                                                    <div class="panel-heading"><i class="fa fa-file"></i> Update Status</div>
                                                    <div class="panel-body">
                                                        <div class="">
                                                            <textarea name="message" cols="40" rows="10" id="status_message" class="form-control message" style="height: 62px; overflow: hidden;" placeholder="What's on your mind ?"></textarea> 
                                                        </div>
                                                    </div>
                                                    <div class="panel-footer">
                                                        <div class="row">
                                                            <div class="col-md-7">
                                                                <div class="form-group">
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default"><img alt="location" src="<%=request.getContextPath()%>/images/location.png" style="width: 20px" height="20px"> Location</button>
                                                                        <button type="button" class="btn btn-default"><img alt="location" src="<%=request.getContextPath()%>/images/photos_icon2.png" style="width: 20px" height="20px">Photo</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-md-5">
                                                                <div class="form-group">
                                                                    <select name="privacy" class="form-control privacy-dropdown pull-left input-sm">
                                                                        <option value="1" selected="selected">Public</option>
                                                                        <option value="2">Only my friends</option>
                                                                        <option value="3">Only me</option>
                                                                    </select>                                    
                                                                    <input type="submit" name="submit" value="Post" class="btn btn-primary">                               
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </li>


                            <!-- Các danh mục trong trang cá nhân -->
                            <li>
                                <div class="row">
                                    <!-- Các kĩ năng trội của sinh viên -->
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption " align="left">
                                                <img src="<%=request.getContextPath()%>/images/skills.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Kĩ năng</h3>
                                                <div class="comment">
                                                    <br>
                                                    Kĩ năng 1.
                                                    Kĩ năng 2. 
                                                    Kĩ năng 3.
                                                    Kĩ năng 4.
                                                    Kĩ năng 5.
                                                    Kĩ năng 6. 
                                                    Kĩ năng 7.
                                                    Kĩ năng 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Các gải thưởng mà sinh viên đạt được -->  
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption ">
                                                <img src="<%=request.getContextPath()%>/images/awards.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Giải thưởng</h3>
                                                <div class="comment">
                                                    <br>
                                                    Giải thưởng 1. 
                                                    Giải thưởng 2.
                                                    Giải thưởng 3.
                                                    Giải thưởng 4.
                                                    Giải thưởng 5. 
                                                    Giải thưởng 6.
                                                    Giải thưởng 7.
                                                    Giải thưởng 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </li>

                            <li>
                                <div class="row">
                                    <!-- Quá trình học tập của sinh viên -->
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption " align="left">
                                                <img src="<%=request.getContextPath()%>/images/studying.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Quá trình học tập</h3>
                                                <div class="comment">
                                                    <br>
                                                    Năm thứ 1.
                                                    Năm thứ 2.
                                                    Năm thứ 3.
                                                    Năm thứ 4.
                                                    Năm thứ 5.
                                                    Năm thứ 6.
                                                    Năm thứ 7.
                                                    Năm thứ 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Các hoạt động tình nguyện của sinh viên -->  
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption ">
                                                <img src="<%=request.getContextPath()%>/images/volunteer.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Tình nguyện</h3>
                                                <div class="comment">
                                                    <br>
                                                    Tình nguyện 1. 
                                                    Tình nguyện 2.
                                                    Tình nguyện 3.
                                                    Tình nguyện 4.
                                                    Tình nguyện 5.
                                                    Tình nguyện 6.
                                                    Tình nguyện 7.
                                                    Tình nguyện 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="row">
                                    <!-- Kinh nghiệm làm việc của sinh viên -->
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption " align="left">
                                                <img src="<%=request.getContextPath()%>/images/experiences.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Kinh nghiệm</h3>
                                                <div class="comment" align="left">
                                                    <br>
                                                    Kinh nghiệm 1.
                                                    Kinh nghiệm 2. 
                                                    Kinh nghiệm 3.
                                                    Kinh nghiệm 4.
                                                    Kinh nghiệm 5.
                                                    Kinh nghiệm 6. 
                                                    Kinh nghiệm 7.
                                                    Kinh nghiệm 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Dự án mà sinh viên đã tham gia --> 
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption" align="left">
                                                <img src="<%=request.getContextPath()%>/images/projects.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Dự án</h3>
                                                <div class="comment">
                                                    <br>
                                                    Dự án 1. 
                                                    Dự án 2.
                                                    Dự án 3.
                                                    Dự án 4.
                                                    Dự án 5. 
                                                    Dự án 6.
                                                    Dự án 7.
                                                    Dự án 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <div class="row">
                                    <!-- Bài viết -->
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption " align="left">
                                                <img src="<%=request.getContextPath()%>/images/post.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Bài viết</h3>
                                                <div class="comment">
                                                    <br>
                                                    Bài viết 1.
                                                    Bài viết 2. 
                                                    Bài viết 3.
                                                    Bài viết 4.
                                                    Bài viết 5.
                                                    Bài viết 6. 
                                                    Bài viết 7.
                                                    Bài viết 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Sở thích của sinh viên --> 
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption ">
                                                <img src="<%=request.getContextPath()%>/images/interest.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Sở thích</h3>
                                                <div class="comment">
                                                    <br>
                                                    Sở thích 1. 
                                                    Sở thích 2.
                                                    Sở thích 3.
                                                    Sở thích 4.
                                                    Sở thích 5. 
                                                    Sở thích 6.
                                                    Sở thích 7.
                                                    Sở thích 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>

                            <li>
                                <!-- Ngôn ngữ -->
                                <div class="row">
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption " align="left">
                                                <img src="<%=request.getContextPath()%>/images/languages.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Ngôn ngữ</h3>
                                                <div class="comment">
                                                    <br>
                                                    Ngôn ngữ 1.
                                                    Ngôn ngữ 2. 
                                                    Ngôn ngữ 3.
                                                    Ngôn ngữ 4.
                                                    Ngôn ngữ 5.
                                                    Ngôn ngữ 6. 
                                                    Ngôn ngữ 7.
                                                    Ngôn ngữ 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Khái quát về sinh viên -->  
                                    <div class="col-sm-6 col-md-6">
                                        <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                                            <div class="caption ">
                                                <img src="<%=request.getContextPath()%>/images/basic.png" class="img-rounded" alt="Skills" width="60" height="60" align="left">
                                                <h3>Sự kiện</h3>
                                                <div class="comment">
                                                    <br>
                                                    Sự kiện 1. 
                                                    Sự kiện 2.
                                                    Sự kiện 3.
                                                    Sự kiện 4.
                                                    Sự kiện 5. 
                                                    Sự kiện 6.
                                                    Sự kiện 7.
                                                    Sự kiện 8.
                                                </div>
                                                <script type="text/javascript">$(document).ready(function () {
                                                        $(".comment").shorten();
                                                    });</script>
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
                    <div class="thumbnail" style="overflow:auto;width:300px;height: 200px;left:0">
                        <div class="caption" align="left">
                            <img src="<%=request.getContextPath()%>/images/company.png" class="img-rounded" alt="Skills" width="80" height="80" align="left">
                            <h2 style="color: red;">Company</h2>
                            <div class="comment">
                                <br>
                                Công ty 1 
                                Công ty 2.
                                Công ty 3.
                                Công ty 4.
                                Công ty 5.
                                Công ty 6.
                                Công ty 7.
                                Công ty 8.
                            </div>
                        </div>
                    </div>
                </div>
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
        </script>
</html>
