
<!-- Post new status -->
<div class="row" align="left">
	<div class="col-sm-6 col-md-12">
		<jsp:include page="/WEB-INF/includes/postNewStatus.jsp"></jsp:include>
	</div>
</div>

<span id="result">ChÃ¡n vl</span>
<div class="container"
	style="width: 700px; height: 50; padding: 10px; border-radius: 5px; background-color: #E6E6E6;"
	align="center">
	<div class="row "
		style="display: block; width: 690px; height: auto; border-radius: 5px; background-color: white;">
		<jsp:include page="/WEB-INF/includes/postFrame.jsp"></jsp:include>
	</div>
</div>

<script type="text/javascript">
    $(document).ready(function () {
        $(".comment").shorten();
    });
</script>
<!-- 

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#btnPost").click(function () {
            var content = $("#content").val();
            alert(content);
            $.ajax({
                type: 'POST',
                data: {content: content},
                url: "post?action=add",
                error: function () {
                    $("#result").html("Xảy ra lỗi");
                },
                success: function (result) {
                    $("#result").prepend(content);
                    $("#result").prepend("<br/>");
                    $("#content").val("");
                },
            });
        });
    });
</script>
 -->
