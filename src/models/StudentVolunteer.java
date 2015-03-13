package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentVolunteer {
	protected int id;
	protected int studentId;
	protected String organization;
	protected String role;
	protected String cause;
	protected String startTime;
	protected String finishTime;
	protected int isNow;
	protected String more;
	public static final ArrayList<String> STUDENT_VOLUNTEER_COLUMN = new ArrayList<>();
	static{
		STUDENT_VOLUNTEER_COLUMN.add("id");
		STUDENT_VOLUNTEER_COLUMN.add("studentId");
		STUDENT_VOLUNTEER_COLUMN.add("organization");
		STUDENT_VOLUNTEER_COLUMN.add("role");
		STUDENT_VOLUNTEER_COLUMN.add("cause");
		STUDENT_VOLUNTEER_COLUMN.add("startTime");
		STUDENT_VOLUNTEER_COLUMN.add("finishTime");
		STUDENT_VOLUNTEER_COLUMN.add("isNow");
		STUDENT_VOLUNTEER_COLUMN.add("more");
	}
	public StudentVolunteer() {
		super();
	}

	public StudentVolunteer(int id, int studentId, String organization,
			String role, String cause, String startTime, String finishTime,
			int isNow, String more) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.organization = organization;
		this.role = role;
		this.cause = cause;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.isNow = isNow;
		this.more = more;
	}

	public static ArrayList<StudentVolunteer> getStudentExps(String columnName,String value){
		//if columnName is not a column name, finish and return null
		if(!STUDENT_VOLUNTEER_COLUMN.contains(columnName)){
			//Ghi log
			System.out.println("Table has no the column called "+columnName);
			return null;
		}
		String sql = "SELECT * FROM sw_student_volunteers WHERE "+ columnName +"=?;";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		ArrayList<StudentVolunteer> volunteerList = new ArrayList<StudentVolunteer>();
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setString(1, value);
			ResultSet result = prepstmt.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				int studentId = result.getInt("studentId");
				String organization = result.getString("organization");
				String role = result.getString("role");
				String cause = result.getString("cause");
				String startTime = result.getString("startTime");
				String finishTime = result.getString("finishTime");
				int isNow = result.getInt("isNow");
				String more = result.getString("more");
				
				volunteerList.add(new StudentVolunteer(id, studentId, organization, role, cause, startTime, finishTime, isNow, more));
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
        return volunteerList;
	}
	public int addToDB(){
		String sql = "INSERT INTO sw_student_volunteers(id, studentId, organization, role, cause, startTime, finishTime, isNow, more) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.id);
			prepstmt.setInt(2, this.studentId);
			prepstmt.setString(3, this.organization);
			prepstmt.setString(4, this.role);
			prepstmt.setString(5, this.cause);
			prepstmt.setString(6, this.startTime);
			prepstmt.setString(7, this.finishTime);
			prepstmt.setInt(8, this.isNow);
			prepstmt.setString(9, this.more);
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public int getIsNow() {
		return isNow;
	}

	public void setIsNow(int isNow) {
		this.isNow = isNow;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}
	
}
