<div class="modal fade bs-example-modal-md" id="addLanguages"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Ngôn ngữ</b></h4>
			</div>
			
			<form method="post" action="language?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="language"><b>Tên ngôn ngữ</b></label> 
						<input type="text"
							class="form-control modal-md" id="language" name="language"
							placeholder="Tên ngôn ngữ" required="required">
					</div>
					<div class="form-group">
						<label for="level"><b>Trình độ</b></label> 
						<input type="num" min="1" max="10" value="5"
							class="form-control modal-md" id="level" name="level"
							placeholder="Trình độ đánh giá theo thang 10" required="required">
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