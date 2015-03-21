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
        <script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>${initParam['indexTitle']}</title>
    </head>

    <body>
        <div class="header">
            <jsp:include page="WEB-INF/includes/navigatorBar.jsp"></jsp:include>

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
        <!-- Start WOWSlider.com BODY section -->
        <!-- add to the <body> of your page -->
        <div id="wowslider-container1">
            <div class="ws_images">
                <ul>
                    <li><img
                            src="<%=request.getContextPath()%>/imageSliderData/images/1.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            id="wows1_0" /></li>
                    <li><img
                            src="<%=request.getContextPath()%>/imageSliderData/images/2.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            id="wows1_1" /></li>
                    <li><img
                            src="<%=request.getContextPath()%>/imageSliderData/images/3.jpg"
                            alt="Cùng chúng tôi" title="Cùng chúng tôi" id="wows1_2" /></li>
                    <li><img
                            src="<%=request.getContextPath()%>/imageSliderData/images/4.jpg"
                            alt="full screen slider"
                            title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            id="wows1_3" /></li>
                    <li><img
                            src="<%=request.getContextPath()%>/imageSliderData/images/5.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"
                            id="wows1_4" /></li>
                </ul>
            </div>
            <div class="ws_bullets">
                <div>
                    <a href="#"
                       title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"><img
                            src="<%=request.getContextPath()%>/imageSliderData/tooltips/1.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam" />1</a>
                    <a href="#"
                       title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"><img
                            src="<%=request.getContextPath()%>/imageSliderData/tooltips/2.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam" />2</a>
                    <a href="#"
                       title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"><img
                            src="<%=request.getContextPath()%>/imageSliderData/tooltips/3.jpg"
                            alt="Cùng chúng tôi" />3</a> <a href="#"
                                                    title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"><img
                            src="<%=request.getContextPath()%>/imageSliderData/tooltips/4.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam" />4</a>
                    <a href="#"
                       title="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam"><img
                            src="<%=request.getContextPath()%>/imageSliderData/tooltips/5.jpg"
                            alt="Cùng chúng tôi xây dựng mạng xã hội việc làm dành cho sinh viên lớn nhất Việt  Nam" />5</a>
                </div>
            </div>
            <div class="ws_shadow"></div>
        </div>

        <!-- End WOWSlider.com BODY section -->

        <!-- *************START LOGIN FORM, SIGN UP FORM  -->
        <!-- THEY WILL BE SHOW WHEN ITS LINK ON NAVIGATOR IS CLICKED -->
        <jsp:include page="/WEB-INF/includes/loginForm.jsp"></jsp:include>
        <jsp:include page="/WEB-INF/includes/signUpForm.jsp"></jsp:include>
            <!-- ***********END LOGIN AND SIGN UP FORM****************** -->
        </body>
        <!-- JS FOR SLIDESHOW -->
        <script type="text/javascript"
        src="<%=request.getContextPath()%>/imageSliderData/engines/wowslider.js"></script>
    <script type="text/javascript"
    src="<%=request.getContextPath()%>/imageSliderData/engines/script.js"></script>


</html>