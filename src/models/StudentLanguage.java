package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentLanguage {
	protected int id;
	protected int studentId;
	protected String language;
	protected String level;
	public static final ArrayList<String> STUDENT_LANGUAGE_COLUMN = new ArrayList<>();
	static{
		STUDENT_LANGUAGE_COLUMN.add("id");
		STUDENT_LANGUAGE_COLUMN.add("studentId");
		STUDENT_LANGUAGE_COLUMN.add("skill");
		STUDENT_LANGUAGE_COLUMN.add("title");
		STUDENT_LANGUAGE_COLUMN.add("level");
	}
	public StudentLanguage() {
		super();
	}
	public StudentLanguage(int id, int studentId, String language, String level) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.language = language;
		this.level = level;
	}
	public static ArrayList<StudentLanguage> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_LANGUAGE_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_languages WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentLanguage> languageList = new ArrayList<StudentLanguage>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String language = result.getString("language");
				String level = result.getString("level");
				languageList.add(new StudentLanguage(id, studentId, language, level));
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
        return languageList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_languages(id,studentId,language,level) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.language);
			prepstmt.setString(4, this.level);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_languages successfully!");
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
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public static ArrayList<String> getStudentLanguageColumn() {
		return STUDENT_LANGUAGE_COLUMN;
	}
}
