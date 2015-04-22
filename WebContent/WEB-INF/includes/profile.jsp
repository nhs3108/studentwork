<!-- BEGIN GLOBAL MANDATORY STYLES -->
<%@page import="entities.Users"%>
<%@page import="models.StudentEventModel"%>
<%@page import="entities.StudentEvents"%>
<%@page import="entities.StudentLanguages"%>
<%@page import="models.StudentLanguageModel"%>
<%@page import="models.StudentInterestModel"%>
<%@page import="entities.StudentInterests"%>
<%@page import="models.StudentProjectModel"%>
<%@page import="entities.StudentProjects"%>
<%@page import="models.StudentVolunteerModel"%>
<%@page import="entities.StudentVolunteers"%>
<%@page import="models.StudentExperienceModel"%>
<%@page import="entities.StudentExp"%>
<%@page import="models.StudentStudyModel"%>
<%@page import="entities.StudentStudyings"%>
<%@page import="models.StudentAwardModel"%>
<%@page import="entities.StudentAwards"%>
<%@page import="models.StudentCertificationModel"%>
<%@page import="entities.StudentCertifications"%>
<%@page import="models.StudentSkillModel"%>
<%@page import="entities.StudentSkills"%>

<div class="col-sm-12 col-md-12">
	<br><span><b><i>Sử dụng chức năng tạo CV để có bản CV đẹp và nhanh nhất</i></b></span>&nbsp&nbsp&nbsp<a href="downloadCV?username=${requestScope.user.username}&language=vi" class="btn btn-danger">Tạo CV</a>
</div>
<%
	Users requestUser = (Users)request.getAttribute("user");
	Users sessionUser = (Users)session.getAttribute("user");
%>
<!-- Kĩ năng -->
<div class="col-sm-12 col-md-12"><br>
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color:#E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 0px 0px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/skills.png"
				class="img-rounded" alt="Skills" width="60" height="60" align="left">
			<h3 class="text-info"><b>Kĩ năng</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive " >
						<table class="table table-bordered" id="sample_editable_1" style="background-color: white">
							<thead>
								<tr>
									<th>Kỹ năng</th>
									<th>Trình độ</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									//********** GET USER INFOMATION*******************//
									Users user = (Users) request.getAttribute("user");
									int userId = user.getId();
									java.util.List<StudentSkills> skillList = new StudentSkillModel()
											.getByStudentId(userId);
									for (StudentSkills ss : skillList) {
								%>
									<tr>
										<td><%=ss.getSkill()%></td>
										<td class="center"><%=ss.getLevel()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
											%>
											<td><a class="delete btn_delSkill" id="<%=ss.getId()%>"
											href="skill?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
										<%
									}
								%>
							</tbody>
						</table>
					</div>
					<button class="btn btn-primary" data-toggle="modal" data-target="#addSkills">Thêm mới</button>
					<jsp:include page="/WEB-INF/includes/addSkillsForm.jsp"></jsp:include>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Chứng chỉ -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color:#E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 0px 0px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/post.png"
				class="img-rounded" alt="Certifications" width="60" height="60" align="left">
			<h3 class="text-info"><b>Chứng chỉ</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_2" style="background-color: white">
							<thead>
								<tr>
									<th>Chứng chỉ</th>
									<th>Năm</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentCertifications> certificationList = new StudentCertificationModel().getByStudentId(userId);
									for(StudentCertifications sc:certificationList){
								%>
									<tr>
										<td><%=sc.getCertification()%></td>
										<td class="center"><%=sc.getYear()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
											%>
											<td><a class="delete btn_delCert" id="<%=sc.getId() %>" href="certification?action=del">Xóa</a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addCertifications">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addCertificationsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Các gải thưởng mà sinh viên đạt được -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color:#E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/awards.png"
				class="img-rounded" alt="Awards" width="60" height="60" align="left">
			<h3 class="text-info"><b>Giải thưởng</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_3" style="background-color: white">
							<thead>
								<tr>
									<th>Năm</th>
									<th>Tên giải thưởng</th>
									<th>Mô tả thêm</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentAwards> awardList = new StudentAwardModel()
											.getByStudentId(userId);
									for (StudentAwards sa : awardList) {
								%>
									<tr>
										<td><%=sa.getYear()%></td>
										<td class="center"><%=sa.getAward()%></td>
										<td><%=sa.getMore()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
											%>
											<td><a class="delete btn_delAward" id="<%=sa.getId()%>" href="award?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addAwards">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addAwardsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Quá trình học tập của sinh viên -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 50px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/studying.png"
				class="img-rounded" alt="Skills" width="60" height="60" align="left">
			<h3 class="text-info"><b>Quá trình học tập</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_4" style="background-color: white">
							<thead>
								<tr>
									<th>Lớp</th>
									<th>Điểm</th>
									<th>Điểm rèn luyện</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentStudyings> studyList = new StudentStudyModel()
											.getByStudentId(userId);
									for (StudentStudyings ss : studyList) {
								%>
									<tr>
										<td><%=ss.getClassName()%></td>
										<td class="center"><%=ss.getScore()%></td>
										<td><%=ss.getConduct()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
											%>
											<td><a class="delete" id="<%=ss.getId()%>"
										href="study?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addStudyings">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addStudyingsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- Kinh nghiệm làm việc của sinh viên -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/experiences.png"
				class="img-rounded" alt="Experiences" width="60" height="60" align="left">
			<h3 class="text-info"><b>Kinh nghiệm</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_5" style="background-color: white">
							<thead>
								<tr>
									<th>Công ty</th>
									<th>Công việc</th>
									<th>Ngày bắt đầu</th>
									<th>Ngày kết thúc</th>
									<th>Thông tin thêm</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentExp> expList = new StudentExperienceModel().getByStudentId(userId);
									for(StudentExp se:expList){
								%>
									<tr>
										<td><%=se.getCompany()%></td>
										<td><%=se.getTitle()%></td>
										<td class="center"><%=se.getStartTime()%></td>
										<td class="center"><%=se.getFinishTime()%></td>
										<td><%=se.getMore()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
											%>
											<td><a class="delete" id="<%=se.getId() %>" href="experience?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addExperiences">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addExperiencesForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Dự án mà sinh viên đã tham gia -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/projects.png"
				class="img-rounded" alt="Projects" width="60" height="60" align="left">
			<h3 class="text-info"><b>Dự án</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_6" style="background-color: white">
							<thead>
								<tr>
									<th>Dự án</th>
									<th>Link</th>
									<th>Mô tả</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentProjects> projectList = new StudentProjectModel().getByStudentId(userId);
									for(StudentProjects sp:projectList){
								%>
									<tr>
										<td><%=sp.getProject()%></td>
										<td><%=sp.getLink()%></td>
										<td><%=sp.getMore()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
										%>
											<td><a class="delete" id="<%=sp.getId() %>" href="project?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addProjects">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addProjectsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Tình nguyện -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/volunteer.png"
				class="img-rounded" alt="Volunteers" width="60" height="60" align="left">
			<h3 class="text-info"><b>Tình nguyện</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_7" style="background-color: white">
							<thead>
								<tr>
									<th>Tổ chức</th>
									<th>Vai trò</th>
									<th>Hoạt động</th>
									<th>Ngày bắt đầu</th>
									<th>Ngày kết thúc</th>
									<th>Thông tin thêm</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentVolunteers> volunteerList = new StudentVolunteerModel().getByStudentId(userId);
									for(StudentVolunteers sv:volunteerList){
								%>
									<tr>
										<td><%=sv.getOrganization()%></td>
										<td><%=sv.getRole()%></td>
										<td><%=sv.getCause()%></td>
										<td class="center"><%=sv.getStartTime()%></td>
										<td class="center"><%=((sv.getIsNow()==1)?"vẫn còn tham gia":sv.getFinishTime())%></td>
										<td><%=sv.getMore()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
										%>
											<td><a class="delete" id="<%=sv.getId() %>" href="volunteer?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addVolunteers">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addVolunteersForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Sở thích của sinh viên -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/interest.png"
				class="img-rounded" alt="Interests" width="60" height="60" align="left">
			<h3 class="text-info"><b>Sở thích</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_8" style="background-color: white">
							<thead>
								<tr>
									<th>Sở thích</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentInterests> interestList = new StudentInterestModel().getByStudentId(userId);
									for(StudentInterests si:interestList){
								%>
									<tr>
										<td><%=si.getInterest()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
										%>
											<td><a class="delete" id="<%=si.getId() %>" href="interest?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addInterests">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addInterestsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<!-- Ngôn ngữ -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/languages.png"
				class="img-rounded" alt="Languages" width="60" height="60" align="left">
			<h3 class="text-info"><b>Ngôn ngữ</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_9" style="background-color: white">
							<thead>
								<tr>
									<th>Ngôn ngữ</th>
									<th>Trình độ(1-5)</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentLanguages> languageList = new StudentLanguageModel().getByStudentId(userId);
									for(StudentLanguages sl:languageList){
								%>
									<tr>
										<td><%=sl.getLanguage()%></td>
										<td><%=sl.getLevel()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
										%>
											<td><a class="delete" id="<%=sl.getId() %>" href="language?action=del"> Xóa </a></td>
										<%
										}
										%>
									</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addLanguages">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addLanguagesForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Sự kiện -->
<div class="col-sm-12 col-md-12">
	<div class="thumbnail"
		style="width: auto; height: 300px; border: 1px solid #666; background-color: #E0E6F8; overflow: hidden; text-align: justify;"
		align="left">
		<div class="caption"
			style="height: 300px; overflow: auto; margin: 0px -300px 5px 5px; padding-right: 300px;"
			align="left">
			<img src="<%=request.getContextPath()%>/images/basic.png"
				class="img-rounded" alt="Events" width="60" height="60" align="left">
			<h3 class="text-info"><b>Sự kiện</b></h3>
			<div class="portlet box blue">
				<div class="portlet-body">
					<div class="table-responsive ">
						<table class="table table-bordered" id="sample_editable_10" style="background-color: white">
							<thead>
								<tr>
									<th>Sự kiện</th>
									<th>Địa điểm</th>
									<th>Thời gian</th>
									<th>Chi tiết</th>
									<%
									if(sessionUser.getId() == requestUser.getId()){
										out.print("<th>Xóa</th>");
									}
									%>
								</tr>
							</thead>
							<tbody>
								<%
									java.util.List<StudentEvents> eventList = new StudentEventModel().getByStudentId(userId);
									for(StudentEvents se:eventList){
								%>
									<tr>
										<td><%=se.getEvent()%></td>
										<td><%=se.getPlace()%></td>
										<td><%=se.getTime()%></td>
										<td><%=se.getMore()%></td>
										<%
										if(sessionUser.getId() == requestUser.getId()){
										%>
											<td><a class="delete" id="<%=se.getId() %>" href="event?action=del">
											Xóa </a></td>
										<%
										}
										%>
									</tr>
								<tr>
									<td><%=se.getEvent()%></td>
									<td><%=se.getPlace()%></td>
									<td><%=se.getTime()%></td>
									<td><%=se.getMore()%></td>
									<td><a class="delete" id="<%=se.getId() %>" href="event?action=del">
											Xóa </a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
						<button class="btn btn-primary" data-toggle="modal" data-target="#addEvents">Thêm mới</button>
						<jsp:include page="/WEB-INF/includes/addEventsForm.jsp"></jsp:include>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script>
<script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-migrate-1.2.1.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery.blockui.min.js"
	type="text/javascript"></script>
<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/plugins/uniform/jquery.uniform.min.js"
	type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript"
	src="assets/plugins/select2/select2.min.js"></script>
<script type="text/javascript"
	src="assets/plugins/data-tables/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="assets/plugins/data-tables/DT_bootstrap.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="assets/scripts/core/app.js"></script>
<script src="assets/scripts/custom/table-editable.js"></script>
<script src="assets/scripts/custom/table-editable2.js"></script>
<script src="assets/scripts/custom/table-editable3.js"></script>
<script src="assets/scripts/custom/table-editable4.js"></script>
<script src="assets/scripts/custom/table-editable5.js"></script>
<script src="assets/scripts/custom/table-editable6.js"></script>
<script src="assets/scripts/custom/table-editable7.js"></script>
<script src="assets/scripts/custom/table-editable8.js"></script>
<script src="assets/scripts/custom/table-editable9.js"></script>
<script src="assets/scripts/custom/table-editable10.js"></script>
<script>
	jQuery(document).ready(function() {
		App.init();
		TableEditable.init();
		TableEditable2.init();
		TableEditable3.init();
		TableEditable4.init();
		TableEditable5.init();
		TableEditable6.init();
		TableEditable7.init();
		TableEditable8.init();
		TableEditable9.init();
		TableEditable10.init();
	});
</script>


<script>
//************* ajax PROFILE *************//
$(document).ready(function(){
  $(".delete").click(function(){
  	
      var id = $(this).attr("id");
      var tagerUrl = $(this).attr("href");
      $.ajax({
          type: "POST",
          url: tagerUrl,
          data: {id: id},
          success: function(data){
              alert("Post deleted");
          }
      });
  });
});
</script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>