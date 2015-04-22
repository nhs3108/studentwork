<div class="modal fade bs-example-modal-md" id="addAwards"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm giải thưởng</b></h4>
			</div>
			
			<form method="post"  action="award?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="award"><b>Tên giải thưởng</b></label> 
						<input type="text"
							class="form-control modal-md" id="award" name="award"
							placeholder="Tên giải thưởng" required="required">
					</div>
					<div class="form-group">
						<label for="year"><b>Năm</b></label> 
						<input type="number" value="2015"
							class="form-control modal-md" id="year" name="year"
							placeholder="Năm đạt giải thưởng" required="required">
					</div>
					<div class="form-group">
						<label for="more"><b>Thông tin thêm</b></label> 
						<input type="text"
							class="form-control modal-md" id="more" name="more"
							placeholder="Thông tin giải thưởng">
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