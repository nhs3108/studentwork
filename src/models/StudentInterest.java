package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentInterest {
	protected int id;
	protected int studentId;
	protected String interest;
	public static final ArrayList<String> STUDENT_INTERESTS_COLUMN = new ArrayList<>();
	static{
		STUDENT_INTERESTS_COLUMN.add("id");
		STUDENT_INTERESTS_COLUMN.add("studentId");
		STUDENT_INTERESTS_COLUMN.add("interest");
	}
	public StudentInterest() {
		super();
	}

	public StudentInterest(int id, int studentId, String interest) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.interest = interest;
	}

	public static ArrayList<StudentInterest> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_INTERESTS_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_interests WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentInterest> interestList = new ArrayList<StudentInterest>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String interest = result.getString("interest");
				interestList.add(new StudentInterest(id, studentId, interest));
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
        return interestList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_interests(id, studentId, interest) "
				+ "VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.interest);
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_interests successfully!");
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

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}
}
