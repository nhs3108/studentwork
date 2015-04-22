<br><br><br>
<nav class="navbar navbar-default navbar-fixed-top" >
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand " href="/${initParam['websiteName']}"> <img alt="Student Work"
				src="http://www.firebirdsql.org/file/about/ds-firebird-logo-500.png"
				height="30"> <strong style="size: 80px;">StudentWork</strong>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/${initParam['websiteName']}/home"><b>Trang chá»§</b></a></li>
				<li><a href="#" data-toggle="modal" data-target="#loginForm"><b>ÄÄng nháº­p</b></a></li>
				<li><a href="#" data-toggle="modal" data-target="#signUpForm"><b>ÄÄng kÃ­</b></a></li>
				<li><a href="/${initParam['websiteName']}/contactus"><b>LiÃªn há»</b>Â</a></li>
				<li><a href="/${initParam['websiteName']}/recruitment"><b>Vá» chÃºng tÃ´i</b></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<img alt="" src="<%=request.getContextPath()%>/images/0.jpg" class="img-rounded" alt="áº¢nh Äáº¡i diá»n cá»§a ${requestScope.user.fullname}" width="45" height="45"><b> NgÃ´ VÄn Thiá»n</b>
				</li>
				<li>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Tá»« khÃ³a tÃ¬m kiáº¿m">
						</div>
						<button type="submit" class="btn btn-info glyphicon glyphicon-search" aria-label="Left Align">
						</button>
					</form>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>

				