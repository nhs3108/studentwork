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
		ArrayList<StudentLanguage> languageList = new ArrayList<StudentLanguage>();
		String sql = "SELECT * FROM sw_student_languages WHERE "+ columnName +"=?;";
		String sqlToGetAll = "SELECT * FROM sw_student_languages;";
		//if columnName is not a column name, finish and return null
		if(!STUDENT_LANGUAGE_COLUMN.contains(columnName)){
			if (columnName == "" && value == "") {
				sql = sqlToGetAll;
			}else{
				//Ghi log
				System.out.println("Table has no the column called "+columnName);
				return languageList;
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
		String sql = "INSERT INTO sw_student_languages(studentId,language,level) "
				+ "VALUES(?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.studentId);
			prepstmt.setString(2, this.language);
			prepstmt.setString(3, this.level);
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
