<div class="modal fade bs-example-modal-md" id="addStudyings"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Quá trình học tập</b></h4>
			</div>
			
			<form method="post" action="study?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="className"><b>Tên lớp</b></label> 
						<input type="text"
							class="form-control modal-md" id="className" name="className"
							placeholder="Tên lớp" required="required">
					</div>
					<div class="form-group">
						<label for="score"><b>Điểm học tập</b></label> 
						<input type="number" min="0" max="100"
							class="form-control modal-md" id="score" name="score"
							placeholder="Điểm học tập trên thang điểm 100" required="required">
					</div>
					<div class="form-group">
						<label for="conduct"><b>Điểm rèn luyện</b></label> 
						<input type="number" min="0" max="100"
							class="form-control modal-md" id="conduct" name="conduct"
							placeholder="Điểm rèn luyện" required="required">
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