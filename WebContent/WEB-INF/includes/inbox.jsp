<%@page import="models.*" %>
<%@page import="entities.*" %>
<%@page import="features.*" %>
<%@page import="java.util.List" %>
<div>

<%
	Users sessionUser = (Users)session.getAttribute("user");
	//List<Messages> inbox = new MessageModel().getByOwnerId(sessionUser.getId());
	List<Integer> senderList = new MessageModel().getSenderList(sessionUser.getId());
	for(int senderId : senderList){
		out.print("<b>"+new UserModel().getById(senderId).getFullname()+"</b>");
		List<Messages> conversation = new MessageModel().getByOwnerAndSender(sessionUser.getId(), senderId);
		for(Messages msg : conversation){
			if(msg.getSenderId()==sessionUser.getId()){
				out.print("<b>" + msg.getContent() + "</b>");
			}else{
				out.print("<i>" + msg.getContent() + "</i>");
			}
			out.print("<br>");
		}
		out.print("<br><br>");
	}
%>
</div>
