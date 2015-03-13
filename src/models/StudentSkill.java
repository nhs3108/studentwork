package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentSkill {
	protected int id;
	protected int studentId;
	protected String skill;
	protected String level;
	public static final ArrayList<String> STUDENT_SKILL_COLUMN = new ArrayList<>();
	static{
		STUDENT_SKILL_COLUMN.add("id");
		STUDENT_SKILL_COLUMN.add("studentId");
		STUDENT_SKILL_COLUMN.add("skill");
		STUDENT_SKILL_COLUMN.add("title");
		STUDENT_SKILL_COLUMN.add("level");
	}
	public StudentSkill() {
		super();
	}
	public StudentSkill(int id, int studentId, String skill, String level) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.skill = skill;
		this.level = level;
	}
	public static ArrayList<StudentSkill> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_SKILL_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_skills WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentSkill> skillList = new ArrayList<StudentSkill>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String skill = result.getString("skill");
				String level = result.getString("level");
				skillList.add(new StudentSkill(id, studentId, skill, level));
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
        return skillList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_skills(id,studentId,skill,level) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.skill);
			prepstmt.setString(4, this.level);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_skills successfully!");
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
}
