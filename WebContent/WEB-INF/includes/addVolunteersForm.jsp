<div class="modal fade bs-example-modal-md" id="addVolunteers"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-role" id="exampleModalLabel" align="center"><b>Thêm tình nguyện</b></h4>
			</div>
			
			<form method="post" action="volunteer?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="organization"><b>Tên tổ chức</b></label> 
						<input type="text"
							class="form-control modal-md" id="organization" name="organization"
							placeholder="Tên tổ chức tình nguyện" required="required">
					</div>
					<div class="form-group">
						<label for="role"><b>Vai trò</b></label> 
						<input type="text"
							class="form-control modal-md" id="role" name="role"
							placeholder="Vai trò trong tổ chức" required="required">
					</div>
					<div class="form-group">
						<label for="cause"><b>Sự kiện</b></label> 
						<input type="text"
							class="form-control modal-md" id="cause" name="cause"
							placeholder="Vai trò trong tổ chức" required="required">
					</div>
					<div class="form-group">
						<label for="startTime"><b>Thời gian bắt đầu</b></label> 
						<input type="date" value="2015-01-01"
							class="form-control modal-md" id="startTime" name="startTime"
							placeholder="Thời gian bắt đầu" required="required">
					</div>
					<div class="form-group">
						<label for="finishTime"><b>Thời gian bắt đầu</b></label> 
						<input type="date" value="2015-01-01"
							class="form-control modal-md" id="finishTime" name="finishTime"
							placeholder="Thời gian bắt kết thúc" required="required">
					</div>
					<div class="form-group">
						Đã dừng lại<input type="radio"
							class="form-control id="isNow" name="isNow" value="0"
							checked="checked">
						Còn tiếp diễn<input type="radio"
							class="form-control" id="isNow" name="isNow" value="1">
					</div>
					<div class="form-group">
						<label for="more"><b>Thông tin thêm</b></label> 
						<input type="text"
							class="form-control modal-md" id="more" name="more"
							placeholder="Thông tin thêm về tình nguyện">
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					<button type="submit" class="btn btn-primary">Thêm</button>
				</div>
			</form>
		</div>
	</div>
</div>