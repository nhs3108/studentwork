<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<button type="button" class="btn btn-primary" data-toggle="modal"
	data-target="#messageModel" data-whatever="">Open modal for
	@getbootstrap</button>

<div class="modal fade" id="messageModel" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel">Trò chuyện với {HỌ VÀ TÊN}</h4>
			</div>
			<form method="post" action="message?action=send">
				<div class="modal-body">
					<table class="table">
					  <tr>
					  	<td class="text-success"><span><b>Tên thằng gửi: </b></span>Xin chao em yeu</td>
					  </tr>
					  <tr>
					  	<td class="text-danger"><i><b>Tên thằng nhận: </b>Chào chào cl</i></td>
					  </tr>
					  <tr>
					  	<td class="text-success"><b>Tên thằng gửi: </b>Trường hơp dài quá thì sẽ như thế nào dâudkkfnsknf
					  	ndfjnsfs
					  	knsknfs
					  	nsfd
					  	</td>
					  </tr>
					</table>
				<div class="modal-body">
					<div class="form-group">
						<label for="recipient-name" class="control-label">Người
							nhận:</label> <input type="text" class="form-control"
							name="ownerFullName" id="ownerFullName" disabled="disabled"
							value="Nguyễn Hồng Sơn"> <input type="hidden"
							class="form-control" name="ownerId" id="ownerId">
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