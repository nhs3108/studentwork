<div class="modal fade bs-example-modal-md" id="addEvents"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm sự kiện</b></h4>
			</div>
			
			<form method="post" action="event?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="event"><b>Tên sự kiện</b></label> 
						<input type="text"
							class="form-control modal-md" id="event" name="event"
							placeholder="Tên dự án đã làm" required="required">
					</div>
					<div class="form-group">
						<label for="place"><b>Địa điểm</b></label> 
						<input type="text"
							class="form-control modal-md" id="place" name="place"
							placeholder="Địa điểm diễn ra sự kiện" required="required">
					</div>
					<div class="form-group">
						<label for="time"><b>Thời gian</b></label> 
						<input type="date"
							class="form-control modal-md" id="time" name="time"
							placeholder="Thời gian diễn ra sự kiện" value="2015-01-01" required="required">
					</div>
					<div class="form-group">
						<label for="more"><b>Thông tin thêm</b></label> 
						<input type="text"
							class="form-control modal-md" id="more" name="more"
							placeholder="Thông tin chi tiết về sự kiện">
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