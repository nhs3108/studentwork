package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentCertification {
	protected int id;
	protected int studentId;
	protected String certification;
	protected int year;
	public static final ArrayList<String> STUDENT_CERTIFICATION_COLUMN = new ArrayList<>();
	static{
		STUDENT_CERTIFICATION_COLUMN.add("id");
		STUDENT_CERTIFICATION_COLUMN.add("studentId");
		STUDENT_CERTIFICATION_COLUMN.add("certification");
		STUDENT_CERTIFICATION_COLUMN.add("year");
	}
	
	public StudentCertification() {
		super();
	}
	public StudentCertification(int id, int studentId, String certification,
			int year) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.certification = certification;
		this.year = year;
	}
	public static ArrayList<StudentCertification> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_CERTIFICATION_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_certifications WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentCertification> certificationList = new ArrayList<StudentCertification>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String certification = result.getString("certification");
				int year = result.getInt("year");
				certificationList.add(new StudentCertification(id, studentId, certification, year));
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
        return certificationList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_certifitions(id, studentId, certification, year) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.certification);
			prepstmt.setInt(4, this.year);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_certification successfully!");
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
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
