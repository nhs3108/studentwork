<div class="modal fade bs-example-modal-md" id="addProjects"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm dự án</b></h4>
			</div>
			
			<form method="post" action="project?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="project"><b>Tên dự án</b></label> 
						<input type="text"
							class="form-control modal-md" id="project" name="project"
							placeholder="Tên dự án đã làm" required="required">
					</div>
					<div class="form-group">
						<label for="link"><b>Link</b></label> 
						<input type="text"
							class="form-control modal-md" id="link" name="link"
							placeholder="Link đến dự án (github, website...)">
					</div>
					<div class="form-group">
						<label for="more"><b>Thông tin thêm</b></label> 
						<input type="text"
							class="form-control modal-md" id="more" name="more"
							placeholder="Thông tin chi tiết về dự án">
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