<div class="modal fade bs-example-modal-md" id="addInterests"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm sở thích</b></h4>
			</div>
			
			<form method="post" action="interest?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="interest"><b>Sở thích</b></label> 
						<input type="text"
							class="form-control modal-md" id="interest" name="interest"
							placeholder="Sở thích của bạn" required="required">
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