/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.jsoup.Jsoup;

import models.StudentAwardModel;
import models.StudentBasicModel;
import models.StudentCertificationModel;
import models.StudentEventModel;
import models.StudentExperienceModel;
import models.StudentInterestModel;
import models.StudentLanguageModel;
import models.StudentProjectModel;
import models.StudentSkillModel;
import models.StudentStudyModel;
import models.StudentVolunteerModel;
import models.UserModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import entities.StudentAwards;
import entities.StudentBasic;
import entities.StudentCertifications;
import entities.StudentEvents;
import entities.StudentExp;
import entities.StudentInterests;
import entities.StudentLanguages;
import entities.StudentProjects;
import entities.StudentSkills;
import entities.StudentStudyings;
import entities.StudentVolunteers;
import entities.Users;

public class PDF {
	private static String BACKGROUND_BLUE = "blue.png";
	private static Font titleFont = new Font(Font.FontFamily.COURIER, 18,
			Font.BOLD, new BaseColor(28, 176, 230));
	private static Font commonFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
			Font.NORMAL, BaseColor.GRAY);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	public static void exportCV(String username, String language, String filePath){
		try {
			Document document = new Document(PageSize.A4, 50, 50, 20, 20);
			FileOutputStream fos = new FileOutputStream(filePath);
			PdfWriter.getInstance(document, new DataOutputStream(fos));
			document.open();
			addMetaData(document);
			addContent(document,username,"en");
			document.close();
			System.out.println("DONE!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		System.out.println(fullPath);
		System.out.println(pathArr[0]);
		fullPath = pathArr[0];
		
		String reponsePath = "";
// to read a file from webcontent
		reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";
		return reponsePath;
	}
	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("Curiculum Vitae");
		document.addSubject("Curiculum Vitae");
		document.addKeywords("CV, Curiculum Vitae, So Yeu Ly Lich");
		document.addAuthor("StudentWork");
		document.addCreator("StudentWork");
	}

	private static void addContent(Document document,String username, String language) throws DocumentException,
			IOException {
		Users user = new UserModel().getByUsername(username).get(0);
		int userId = user.getId();

		Paragraph paragraph1 = new Paragraph();
		paragraph1.setSpacingBefore(2);
		Paragraph title = new Paragraph("SO YEU LY LICH", titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		paragraph1.add(title);
		addEmptyLine(paragraph1, 4);
		Image avatar = Image.getInstance("son.jpg");
		avatar.scaleAbsolute(100, 100);
		paragraph1.add(avatar);
		// ****************Thong tin co ban*********************
		Paragraph basicInfoPara = new Paragraph();
		Image basicHeaderImg = Image.getInstance("basic_vi.png");
		basicHeaderImg.scaleAbsolute(700, 40);
		basicHeaderImg.setScaleToFitLineWhenOverflow(true);
		basicInfoPara.add(basicHeaderImg);
		StudentBasic studentBasic = new StudentBasicModel().getByStudentId(
				userId).get(0);
		basicInfoPara
				.add(new Paragraph("Name	: " + user.getFullname(), commonFont));
		basicInfoPara.add(new Paragraph("Gender	: " + studentBasic.getGender(),
				commonFont));
		basicInfoPara.add(new Paragraph(
				"Birthday : " + studentBasic.getBirthday(), commonFont));
		basicInfoPara.add(new Paragraph("Phone : " + user.getPhone(), commonFont));
		basicInfoPara.add(new Paragraph("Email : " + user.getEmail(), commonFont));
		basicInfoPara.add(new Paragraph("Address : "
				+ "Xuan Thuy st., Cau Giay, Ha Noi city", commonFont));
		basicInfoPara.add(new Paragraph("Material Status : "
				+ studentBasic.getMaritalStatus(), commonFont));
		basicInfoPara.add(new Paragraph("Nation : " + studentBasic.getNation(),
				commonFont));
		basicInfoPara.add(new Paragraph("More infomation : "
				+ studentBasic.getMore(), commonFont));

		// ****************Qua Trinh Hoc Tap*********************
		Paragraph studyPara = new Paragraph();
		Image studyHeaderImg = Image.getInstance("studying_vi.png");
		studyHeaderImg.scaleAbsolute(700, 40);
		studyHeaderImg.setScaleToFitLineWhenOverflow(true);
		studyPara.add(studyHeaderImg);
		studyPara.add(new Paragraph("University/College: "
				+ studentBasic.getCollege(), commonFont));
		studyPara
				.add(new Paragraph(
						"_______________________________________________________________"));
		java.util.List<StudentStudyings> studyingList = new StudentStudyModel()
				.getByStudentId(userId);
		for (StudentStudyings ss : studyingList) {
			studyPara.add(new Paragraph(ss.getClassName() + " : with score "
					+ ss.getScore() + " and " + ss.getConduct()
					+ " for morality", commonFont));
		}

		// ****************Ky nang*********************
		Paragraph skillPara = new Paragraph();
		Image skillHeaderImg = Image.getInstance("skill_vi.png");
		skillHeaderImg.scaleAbsolute(700, 40);
		skillHeaderImg.setScaleToFitLineWhenOverflow(true);
		skillPara.add(skillHeaderImg);
		java.util.List<StudentSkills> skillList = new StudentSkillModel()
				.getByStudentId(userId);
		for (StudentSkills ss : skillList) {
			skillPara.add(new Paragraph(ss.getSkill() + " : Level"
					+ ss.getLevel(), commonFont));
		}

		// ****************Kinh nghiem thuc te*********************
		Paragraph experiencePara = new Paragraph();
		Image expHeaderImg = Image.getInstance("exp_vi.png");
		expHeaderImg.scaleAbsolute(700, 40);
		expHeaderImg.setScaleToFitLineWhenOverflow(true);
		experiencePara.add(expHeaderImg);
		java.util.List<StudentExp> expList = new StudentExperienceModel()
				.getByStudentId(userId);
		for (StudentExp se : expList) {
			experiencePara.add(new Paragraph(se.getStartTime() + " to "
					+ se.getFinishTime() + ": " + se.getTitle() + " at "
					+ se.getCompany() + ". " + se.getMore(), commonFont));
		}

		// ****************Giai thuong*********************
		Paragraph awardPara = new Paragraph();
		Image awardHeaderImg = Image.getInstance("award_vi.png");
		awardHeaderImg.scaleAbsolute(700, 40);
		awardHeaderImg.setScaleToFitLineWhenOverflow(true);
		awardPara.add(awardHeaderImg);
		java.util.List<StudentAwards> awardList = new StudentAwardModel().getByStudentId(userId);
		for(StudentAwards sa:awardList){
			awardPara.add(new Paragraph("In " + sa.getYear() + ": " + sa.getAward() + ". " + sa.getMore(),commonFont));
		}
		
		// ****************Bang cap*********************
		Paragraph certificationPara = new Paragraph();
		Image certificationHeaderImg = Image.getInstance("certification_vi.png");
		certificationHeaderImg.scaleAbsolute(700, 40);
		certificationHeaderImg.setScaleToFitLineWhenOverflow(true);
		certificationPara.add(certificationHeaderImg);
		java.util.List<StudentCertifications> certificationList = new StudentCertificationModel().getByStudentId(userId);
		for(StudentCertifications sc:certificationList){
			certificationPara.add(new Paragraph("In " + sc.getYear() +": "+ sc.getCertification(),commonFont));
		}
		
		// ****************Ngon ngu*********************
		Paragraph languagePara = new Paragraph();
		Image languageHeaderImg = Image.getInstance("language_vi.png");
		languageHeaderImg.scaleAbsolute(700, 40);
		languageHeaderImg.setScaleToFitLineWhenOverflow(true);
		languagePara.add(languageHeaderImg);
		java.util.List<StudentLanguages> languageList = new StudentLanguageModel().getByStudentId(userId);
		for(StudentLanguages sl:languageList){
			languagePara.add(new Paragraph(sl.getLanguage() + " : " + sl.getLevel(),commonFont));
		}
		
		// ****************Hoat dong tinh nguyen*********************
		Paragraph volunteerPara = new Paragraph();
		Image volunteerHeaderImg = Image.getInstance("volunteer_vi.png");
		volunteerHeaderImg.scaleAbsolute(700, 40);
		volunteerHeaderImg.setScaleToFitLineWhenOverflow(true);
		volunteerPara.add(volunteerHeaderImg);
		java.util.List<StudentVolunteers> volunteerList = new StudentVolunteerModel().getByStudentId(userId);
		for(StudentVolunteers sv:volunteerList){
			int isNow = sv.getIsNow();
			volunteerPara.add(new Paragraph(sv.getStartTime() + " to " + ((isNow==1)?"now":sv.getFinishTime()) + ": " + sv.getOrganization()
					+ " " + sv.getCause() + " : " +sv.getCause(),commonFont));
		}

		// ****************Du an/do an/san pham da/dang thuc hien*********************
		Paragraph projectPara = new Paragraph();
		Image projectHeaderImg = Image.getInstance("project_vi.png");
		projectHeaderImg.scaleAbsolute(700, 40);
		projectHeaderImg.setScaleToFitLineWhenOverflow(true);
		projectPara.add(projectHeaderImg);
		java.util.List<StudentProjects> projectList = new StudentProjectModel().getByStudentId(userId);
		for(StudentProjects sp:projectList){
			projectPara.add(new Paragraph(sp.getProject() + ". See at :" + sp.getLink() + ".  " + sp.getMore(),commonFont));
		}
		
		// ****************Su kien tham gia*********************
		
		Paragraph eventPara = new Paragraph();
		Image eventHeaderImg = Image.getInstance("event_vi.png");
		eventHeaderImg.scaleAbsolute(700, 40);
		eventHeaderImg.setScaleToFitLineWhenOverflow(true);
		eventPara.add(eventHeaderImg);
		java.util.List<StudentEvents> eventList = new StudentEventModel().getByStudentId(userId);
		for(StudentEvents se:eventList){
			eventPara.add(new Paragraph("Time: " + se.getTime() + ". " + se.getEvent() + ". Place :" + se.getPlace() + ". " + se.getMore(),commonFont));
		}
		
		// ****************So thich*********************
		Paragraph interestPara = new Paragraph();
		Image interestHeaderImg = Image.getInstance("interest_vi.png");
		interestHeaderImg.scaleAbsolute(700, 40);
		interestHeaderImg.setScaleToFitLineWhenOverflow(true);
		interestPara.add(interestHeaderImg);
		java.util.List<StudentInterests> interestList = new StudentInterestModel().getByStudentId(userId);
		int i = 1;
		for(StudentInterests si:interestList){
			interestPara.add(new Paragraph(i + ". " + si.getInterest(),commonFont));
			i++;
		}
		
		document.add(paragraph1);
		document.add(basicInfoPara);
		document.add(studyPara);
		document.add(skillPara);
		document.add(experiencePara);
		document.add(awardPara);
		document.add(certificationPara);
		document.add(languagePara);
		document.add(volunteerPara);
		document.add(projectPara);
		document.add(eventPara);
		document.add(interestPara);
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}