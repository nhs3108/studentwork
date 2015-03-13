<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href=""> <img alt="Student Work"
				src="http://www.firebirdsql.org/file/about/ds-firebird-logo-500.png"
				height="30"> <strong style="size: 80px;">StudentWork</strong>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/${initParam['hostname']}/home">Trang chủ</a></li>
				<li>
					 ${sessionScope.email}
				</li>
				<li><a href="/${initParam['hostname']}/contactus">Liên hệ</a></li>
				<li><a href="/${initParam['hostname']}/recruitment">Tin tuyển dụng</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Tìm kiếm với ...">
						</div>
						<button type="submit" class="btn btn-info">Tìm kiếm</button>
					</form>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>