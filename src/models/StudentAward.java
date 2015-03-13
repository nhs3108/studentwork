package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentAward {
	protected int id;
	protected int studentId;
	protected String award;
	protected int year;
	protected String more;
	public static final ArrayList<String> STUDENT_AWARD_COLUMN = new ArrayList<>();
	static{
		STUDENT_AWARD_COLUMN.add("id");
		STUDENT_AWARD_COLUMN.add("studentId");
		STUDENT_AWARD_COLUMN.add("award");
		STUDENT_AWARD_COLUMN.add("year");
		STUDENT_AWARD_COLUMN.add("more");
	}
	public StudentAward() {
		super();
	}
	public StudentAward(int id, int studentId, String award, int year,
			String more) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.award = award;
		this.year = year;
		this.more = more;
	}
	public static ArrayList<StudentAward> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_AWARD_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_awards WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentAward> awardList = new ArrayList<StudentAward>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String award = result.getString("award");
				int year = result.getInt("year");
				String more = result.getString("more");
				
				awardList.add(new StudentAward(id, studentId, award, year, more));
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
        return awardList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_awards(id, studentId, award, year, more) "
				+ "VALUES(?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.award);
			prepstmt.setInt(4, this.year);
			prepstmt.setString(5, this.more);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_awards successfully!");
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
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	
}
