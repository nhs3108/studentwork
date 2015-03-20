package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentProject {
	protected int id;
	protected int studentId;
	protected String project;
	protected String link;
	protected String more;
	public static final ArrayList<String> STUDENT_PROJECT_COLUMN = new ArrayList<>();
	static{
		STUDENT_PROJECT_COLUMN.add("id");
		STUDENT_PROJECT_COLUMN.add("studentId");
		STUDENT_PROJECT_COLUMN.add("project");
		STUDENT_PROJECT_COLUMN.add("link");
		STUDENT_PROJECT_COLUMN.add("more");
	}
	public StudentProject() {
		super();
	}
	public StudentProject(int id, int studentId, String project, String link,
			String more) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.project = project;
		this.link = link;
		this.more = more;
	}
	public static ArrayList<StudentProject> getStudentExps(String columnName,String value){
		ArrayList<StudentProject> projectList = new ArrayList<StudentProject>();
		String sql = "SELECT * FROM sw_student_projects WHERE "+ columnName +"=?;";
		String sqlToGetAll = "SELECT * FROM sw_student_projects;";
		//if columnName is not a column name, finish and return null
		if(!STUDENT_PROJECT_COLUMN.contains(columnName)){
			if (columnName == "" && value == "") {
				sql = sqlToGetAll;
			}else{
				//Ghi log
				System.out.println("Table has no the column called "+columnName);
				return projectList;
			}
		}
		Connection connection = null;
		PreparedStatement prepstmt = null;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			if (sql!=sqlToGetAll) {
				prepstmt.setString(1, value);
			}
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String project = result.getString("project");
				String link = result.getString("link");
				String more = result.getString("more");
				
				projectList.add(new StudentProject(id, studentId, project, link, more));
			}
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (prepstmt != null) {
                	prepstmt.close();
                }
                if (connection != null) {	
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return projectList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_projects(studentId, project, link, more) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.studentId);
			prepstmt.setString(2, this.project);
			prepstmt.setString(3, this.link);
			prepstmt.setString(4, this.more);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_volunteers successfully!");
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (prepstmt != null) {
                	prepstmt.close();
                }
                if (connection != null) {	
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return result;
	}
	public static int delete(int id){
		String sql = "DELETE FROM sw_student_projects WHERE id = ?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, id);
			result = prepstmt.executeUpdate();
			System.out.println("Deldete Projects thanh cong!");
		}catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (prepstmt != null) {
                	prepstmt.close();
                }
                if (connection != null) {	
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	
}
