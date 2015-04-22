
<%@page import="features.MyTime"%>
<%@page import="models.UserModel"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="models.MessageModel"%>
<%@page import="entities.Messages"%>
<%@page import="entities.Users"%>
<%@page import="java.util.List"%>
<%
	Users requestUser = (Users)request.getAttribute("user");
	Users sessionUser = (Users)session.getAttribute("user");
	List<Messages> inbox = new MessageModel().getByOwnerAndSender(requestUser.getId(),sessionUser.getId());
%>
<div class="modal fade bs-example-modal-lg" id="messageModel" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Trò chuyện với <%=requestUser.getFullname() %></h4>
			</div>
			<form method="post" action="message?action=send">
				<div class="modal-body">
					<div>
						<table class="table">
						<%
							for(Messages msg:inbox){
						%>
						<tr>
				  			<td class="<%=msg.getOwnerId()==sessionUser.getId()?"text-success":"text-danger"%>">
				  			<span><b><%=new UserModel().getById(msg.getSenderId()).getFullname() %> </b><i><%=MyTime.getTimePeriodFromNow(msg.getSendTime()) %></i></span>
				  			<br>
				  			<%=msg.getContent() %>
				  			</td>
					  	</tr>
						<%
							}
						%>
					</table>
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Người
							nhận:</label> <input type="text" class="form-control"
							name="ownerFullName" id="ownerFullName" disabled="disabled"
							value="<%=requestUser.getFullname()%>"> <input type="hidden"
							class="form-control" name="ownerId" id="ownerId" value="<%=requestUser.getId()%>">
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">Nội dung:</label>
						<textarea class="form-control" id="content" name="content"></textarea>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">Gửi tin</button>
			</form>
		</div>
	</div>
</div>
</div>