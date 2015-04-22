<div class="modal fade bs-example-modal-md" id="addSkills"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
	aria-hidden="true">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="exampleModalLabel" align="center"><b>Thêm kĩ năng</b></h4>
			</div>
			
			<form method="post" id="updateForm" action="skill?action=add">
				<div class="modal-body">
					<div class="form-group">
						<label for="skill"><b>Tên kĩ năng</b></label> 
						<input type="text"
							class="form-control modal-md" id="skill" name="skill"
							placeholder="Tên kĩ năng" required="required">
					</div>
					<div class="form-group">
						<label for="level"><b>Trình độ</b></label> 
						<input type="number" min="1" max="10" value="5"
							class="form-control modal-md" id="fullname" name="level"
							placeholder="Trình độ đánh giá 1-10" required="required">
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
					<button type="submit" class="btn btn-primary" >Thêm</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script>
/* $(document).ready(function(){
	  $("#updateForm").submit(function(event){
	      var data = $(this).serialize();
	      var tagerUrl = $(this).attr("action");
			alert(data + "  ------------ " + tagerUrl);
		$.ajax({
	          type: "POST",
	          url: tagerUrl,
	          data: {id: id},
	          success: function(data){
	              alert("Them xong");
	          }
	      });
	  });
	}); */
</script>

