<link type="text/css" rel="stylesheet" href="dreamcodes/comment_boxes/css/tsc_comment_boxes.css" />
<!-- Post status form -->
<div class="row" align="left">
	<div class="col-sm-6 col-md-12">
		<form action="#" method="post" role="form"
			enctype="multipart/form-data" class="facebook-share-box"
			style="background-color: #FAFAFA;">
			<div class="share">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-file"></i> Cập nhật trạng thái
					</div>
					<div class="panel-body">
						<div class="">
							<textarea name="content" cols="40" rows="10" id="content"
								class="form-control message"
								style="height: 62px; overflow: hidden;"
								placeholder="Bạn đang nghĩ gì ?"></textarea>
						</div>
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col-md-7">
								<div class="form-group">
									<div class="btn-group">
										<button type="button" class="btn btn-default">
											<img alt="location"
												src="<%=request.getContextPath()%>/images/location.png"
												style="width: 20px" height="20px"> Vị trí
										</button>
										<button type="button" class="btn btn-default">
											<img alt="location"
												src="<%=request.getContextPath()%>/images/photos_icon2.png"
												style="width: 20px" height="20px"> Ảnh
										</button>
									</div>
								</div>
							</div>
							<div class="col-md-5" align="right">
								<div class="form-group">
									<input type="button" name="submit" id="btnPost" value="Đăng" class="btn btn-primary">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<!-- Chứa comment của users -->
<div class="container" style="width: 700px;height:50;padding: 10px;border-radius: 5px;background-color: #E6E6E6;" align="center">
	<!-- Khung một bài viết -->
	<div class="row " style="display: block;width: 690px;height: auto;border-radius: 5px;background-color: white;">
		<!-- Phần đầu: Thông tin người đăng -->
		<div class="col-sm-6 col-md-12 panel-heading" align="left" >
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="40" height="40" align="left">
					<span class="text-info">&nbsp<b>${requestScope.user.fullname}</b></span>
					<span class="text-primary">&nbsp&nbsp&nbspĐã đăng lên dòng thời gian lúc 5 giờ ngày 17 tháng 3</span>
					<span class="pull-right">Sửa</span>
		</div>
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>	
		<div class="col-sm-6 col-md-12 " align="left" >
				<span class="post_status">Liga 2014/15 đang diễn ra vô cùng hấp dẫn và kịch tính. Nếu như Barca khởi đầu mùa giải rất tuyệt vời với việc giành 22/24 điểm sau 8 vòng, thì tiếp đó Real thậm chí còn thể hiện phong độ ấn tượng hơn với 11 trận thắng liên tiếp (trong chuỗi 22 trận thắng trên tất cả các mặt trận).Nhưng tính từ đầu năm mới, gã khổng lồ xứ Catalunya mới là đội thi đấu nổi bật. Thầy trò HLV Enrique thắng 17/19 trận trên cả 3 mặt trận (thua 2), trong đó thành tích tại Liga là thắng 9, thua 2.
				</span>
		</div>
		
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
		<div class="col-sm-6 col-md-12" align="left">
			<div class="row" style="display:block;width:690px;height:auto;border-radius: 5px;background-color: #F2F2F2;;">
				<div class="col-sm-6 col-md-1" align="left"><!-- Avatar -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/like.png" class="img-rounded" alt="Like"align="left"></a><span>200</span>
				</div>
				<div class="col-sm-6 col-md-1" align="left"><!-- User name -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/comment.png" class="img-rounded" alt="Like"align="left"></a><span>200</span>
				</div>
				<div class="col-sm-6 col-md-1"><!-- Do what? -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/share.png" class="img-rounded" alt="Like"align="left"></a><span>300</span>
				</div>
				<div class="col-sm-6 col-md-6">
					<span></span>
				</div>
			</div>
		</div>
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<!-- Khung commnet mới -->
		<div class="col-sm-6 col-md-12" align="left">
			<div class="row">
				<div class="col-sm-6 col-md-1" align="left">
					<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				</div>
				<div class="col-sm-6 col-md-11" align="left">	
					<form action="comment?action=add" id="post_comment" method="post">
						<div class="form-group">
											
					  	<textarea class="form-control" rows="5" id="comment" onKeyPress="return checkSubmit(event)" style="height: 30px"></textarea>
					  	<input type="submit"  value="Gửi"  class="form-control pull-right" placeholder="Comment" style="width: auto;height: 30px" >
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<br>
	<!-- Khung một bài viết -->
	<div class="row " style="display: block;width: 690px;height: auto;border-radius: 5px;background-color: white;">
		<!-- Phần đầu: Thông tin người đăng -->
		<div class="col-sm-6 col-md-12 panel-heading" align="left" >
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="40" height="40" align="left">
					<span class="text-info">&nbsp<b>${requestScope.user.fullname}</b></span>
					<span class="text-primary">&nbsp&nbsp&nbspĐã đăng lên dòng thời gian lúc 5 giờ ngày 17 tháng 3</span>
					<span class="pull-right">Sửa</span>
		</div>
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>	
		<div class="col-sm-6 col-md-12 " align="left" >
				<span class="post_status">Liga 2014/15 đang diễn ra vô cùng hấp dẫn và kịch tính. Nếu như Barca khởi đầu mùa giải rất tuyệt vời với việc giành 22/24 điểm sau 8 vòng, thì tiếp đó Real thậm chí còn thể hiện phong độ ấn tượng hơn với 11 trận thắng liên tiếp (trong chuỗi 22 trận thắng trên tất cả các mặt trận).Nhưng tính từ đầu năm mới, gã khổng lồ xứ Catalunya mới là đội thi đấu nổi bật. Thầy trò HLV Enrique thắng 17/19 trận trên cả 3 mặt trận (thua 2), trong đó thành tích tại Liga là thắng 9, thua 2.
				</span>
		</div>
		
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
		<div class="col-sm-6 col-md-12" align="left">
			<div class="row" style="display:block;width:690px;height:auto;border-radius: 5px;background-color: #F2F2F2;;">
				<div class="col-sm-6 col-md-1" align="left"><!-- Avatar -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/like.png" class="img-rounded" alt="Like"align="left"></a><span>200</span>
				</div>
				<div class="col-sm-6 col-md-1" align="left"><!-- User name -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/comment.png" class="img-rounded" alt="Like"align="left"></a><span>200</span>
				</div>
				<div class="col-sm-6 col-md-1"><!-- Do what? -->
					<a href="#"><img src="<%=request.getContextPath()%>/images/icons/share.png" class="img-rounded" alt="Like"align="left"></a><span>300</span>
				</div>
				<div class="col-sm-6 col-md-6">
					<span></span>
				</div>
			</div>
		</div>
		<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<div class="col-sm-6 col-md-12" align="left">
			<div class="user-comments">
				<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				&nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
				<!-- Nội dung omment -->
				&nbsp<span class="comment">Nếu muốn làm một cái gì thì phải tìm hiểu thật kĩ người ta đã làm chưa?Nếu người ta làm rồi thì phải tìm cách để làm tốt hơn người ta hoặc tìm phần "khuất" để làm!Câu nói văng vẳng của thầy bên tai làm em ăn không ngon, ngủ không yên!Cái sự nghiệp học hành thế này thì bao giờ mới hết ngu đây!</span>
				<p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">Thích</a> &nbsp &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
			</div>
		</div>
		
		<!-- Khung commnet mới -->
		<div class="col-sm-6 col-md-12" align="left">
			<div class="row">
				<div class="col-sm-6 col-md-1" align="left">
					<img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện của ${requestScope.user.fullname}" width="30" height="30" align="left">
				</div>
				<div class="col-sm-6 col-md-11" align="left">	
					<form action="comment?action=add" id="post_comment" method="post">
						<div class="form-group">
											
					  	<textarea class="form-control" rows="5" id="comment" onKeyPress="return checkSubmit(event)" style="height: 30px"></textarea>
					  	<input type="submit"  value="Gửi"  class="form-control pull-right" placeholder="Comment" style="width: auto;height: 30px" >
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$(".comment").shorten();
	});
</script>

<span id="result">Chán vl</span>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $("#btnPost").click(function(){
            var content = $("#content").val();
            $.ajax({
                type: 'POST',
                data:{content:content} ,
                url: "post?action=add",
                error: function () {
                     $("#result").html("éo được");
                },
                success: function (result) {
                        $("#result").html("<font color=red>"+content+"</font>");
                },
            });
        });
    });
</script>
