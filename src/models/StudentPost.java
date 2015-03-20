package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentPost {
	protected int id;
	protected int studentId;
	protected String content;
	protected String time;
	public static final ArrayList<String> STUDENT_POST_COLUMN = new ArrayList<>();
	static{
		STUDENT_POST_COLUMN.add("id");
		STUDENT_POST_COLUMN.add("studentId");
		STUDENT_POST_COLUMN.add("content");
		STUDENT_POST_COLUMN.add("time");
	}
	public StudentPost() {
		super();
	}
	public StudentPost(int id, int studentId, String content, String time) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.content = content;
		this.time = time;
	}
	public static ArrayList<StudentPost> getStudentExps(String columnName,String value){
		String sql = "SELECT * FROM sw_student_posts WHERE "+ columnName +"=?;";
		String sqlToGetAll = "SELECT * FROM sw_student_posts;";
		ArrayList<StudentPost> posttList = new ArrayList<StudentPost>();
		//if columnName is not a column name, finish and return null
		if(!STUDENT_POST_COLUMN.contains(columnName)){
			if (columnName == "" && value == "") {
				sql = sqlToGetAll;
			}else{
				//Ghi log
				System.out.println("Table has no the column called "+columnName);
				return posttList;
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
				String content = result.getString("content");
				String time = result.getString("time");
				posttList.add(new StudentPost(id, studentId, content, time));
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
        return posttList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_interests(studentId, content, time) "
				+ "VALUES(?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.studentId);
			prepstmt.setString(2, this.content);
			prepstmt.setString(3, this.time);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_posts successfully!");
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static ArrayList<String> getStudentPostColumn() {
		return STUDENT_POST_COLUMN;
	}
}
