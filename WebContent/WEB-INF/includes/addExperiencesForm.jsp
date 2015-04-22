<div class="modal fade bs-example-modal-md" id="addExperiences"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm kinh nghiệm</b></h4>
			</div>
			
			<form method="post" action="experience?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="company"><b>Tên công ty</b></label> 
						<input type="text"
							class="form-control modal-md" id="company" name="company"
							placeholder="Tên công ty đã làm việc" required="required">
					</div>
					<div class="form-group">
						<label for="title"><b>Công việc</b></label> 
						<input type="text"
							class="form-control modal-md" id="title" name="title"
							placeholder="Thông tin vị trí làm việc, công tác" required="required">
					</div>
					<div class="form-group">
						<label for="startTime"><b>Thời gian bắt đầu</b></label> 
						<input type="date"
							class="form-control modal-md" id="startTime" name="startTime"
							placeholder="Thời gian bắt đầu làm công việc" value="2015-01-01" required="required">
					</div>
					<div class="form-group">
						<label for="finishTime"><b>Thời gian bắt đầu</b></label> 
						<input type="date"
							class="form-control modal-md" id="finishTime" name="finishTime"
							placeholder="Thời gian bắt kết thúc công việc" value="2015-01-01" required="required">
					</div>
					<div class="form-group">
						<label for="more"><b>Thông tin thêm</b></label> 
						<input type="text"
							class="form-control modal-md" id="more" name="more"
							placeholder="Thông tin công việc">
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