
<!-- Hien thi bai post -->
<%@page import="org.jsoup.Jsoup"%>
<%@page import="models.*"%>
<%@page import="entities.*"%>
<%@page import="features.*"%>
<%@page import="org.jsoup.safety.*"%>
<%
Users user = (Users)request.getAttribute("user");
int userId = user.getId();
java.util.List<StudentPosts> postList = new StudentPostModel().getByStudentId(userId);

for(StudentPosts sp: Reversed.reversed(postList)){
	StudentPosts thisPost = (new StudentPostModel().getById(sp.getId()));
	%>
	<hr>
	<div class="col-sm-6 col-md-12 panel-heading" align="left" >
	    <img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện ${requestScope.user.fullname}" width="40" height="40" align="left">
	    <span class="text-info">&nbsp<b>${requestScope.user.fullname}</b></span>
	    <span class="text-primary"><%=MyTime.getTimePeriodFromNow(thisPost.getTime()) %></span>
	    <span class="pull-right">Sửa</span>
	</div>
	<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>	
	<div class="col-sm-6 col-md-12 " align="left" >
	    <span class="post_content"><%=thisPost.getContent() %></span>
	</div>
	
	<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
	
	<!-- Sá» like, comment, share -->
	<div class="col-sm-6 col-md-12" align="left">
	    <div class="row" style="display:block;width:690px;height:auto;border-radius: 5px;background-color: #F2F2F2;;">
	        <div class="col-sm-6 col-md-1" align="left">
	            <a href="#"><img src="<%=request.getContextPath()%>/images/icons/like.png" class="img-rounded" alt="Like"align="left"></a><span><%=thisPost.getLikes() %></span>
	        </div>
	        <div class="col-sm-6 col-md-1" align="left">
	            <a href="#"><img src="<%=request.getContextPath()%>/images/icons/comment.png" class="img-rounded" alt="Comment"align="left"></a><span><%=thisPost.getComments() %></span>
	        </div>
	        <div class="col-sm-6 col-md-1">
	            <a href="#"><img src="<%=request.getContextPath()%>/images/icons/share.png" class="img-rounded" alt="Share"align="left"></a><span><%=thisPost.getShares() %></span>
	        </div>
	        <div class="col-sm-6 col-md-6">
	            <span></span>
	        </div>
	    </div>
	</div>

	<div class="col-sm-6 col-md-12" style="height: 15px" align="left"></div>
	
	<!-- Ná»i dung comment -->
	<div class="col-sm-6 col-md-12" align="left">
	    <div class="user-comments">
		    <img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện ${requestScope.user.fullname}" width="30" height="30" align="left">
		    &nbsp<span class="text-info"><b>${requestScope.user.fullname}</b></span>
		    <!-- Ná»i dung omment -->
		    &nbsp<span class="comment">Nôi dung comment</span>
		    <p><span class="text-info">20 &nbsp</span><a href="#" class="btn-link">thích</a> &nbsp &nbsp<span style="font-family:monospace;"> 17 tháng 3</span><p>
		</div>
	    </div>


    <!-- Khung commnet má»i -->
    <form action="#" method="post">
        <div class="col-sm-6 col-md-12" align="left">
            <div class="row">
                <div class="col-sm-6 col-md-1" align="left">
                    <img src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="Ảnh đại diện ${requestScope.user.fullname}" width="30" height="30" align="left">
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
    <p></p>
    <p></p>
	<%
}
%>
</form>