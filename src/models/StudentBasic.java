package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentBasic {
	protected int id;
	protected int studentId;
	protected String birthday;
	protected String gender;
	protected String college;
	protected int inYear;
	protected String major;
	protected String maritalStatus;
	protected String nation;
	protected String more;
	public static final ArrayList<String> STUDENT_BASIC_COLUMN = new ArrayList<>();
	static{
		STUDENT_BASIC_COLUMN.add("id");
		STUDENT_BASIC_COLUMN.add("studentId");
		STUDENT_BASIC_COLUMN.add("birthday");
		STUDENT_BASIC_COLUMN.add("gender");
		STUDENT_BASIC_COLUMN.add("college");
		STUDENT_BASIC_COLUMN.add("inYear");
		STUDENT_BASIC_COLUMN.add("major");
		STUDENT_BASIC_COLUMN.add("maritalStatus");
		STUDENT_BASIC_COLUMN.add("nation");
		STUDENT_BASIC_COLUMN.add("more");
	}
	
	public StudentBasic() {
		super();
	}
	
	public StudentBasic(int id, int studentId, String birthday, String gender,
			String college, int inYear, String major, String maritalStatus,
			String nation, String more) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.birthday = birthday;
		this.gender = gender;
		this.college = college;
		this.inYear = inYear;
		this.major = major;
		this.maritalStatus = maritalStatus;
		this.nation = nation;
		this.more = more;
	}

	public static ArrayList<StudentBasic> getUsers(String columnName,String value){
		String sql = "SELECT * FROM sw_student_basic WHERE "+ columnName +"=?;";
		String sqlToGetAll = "SELECT * FROM sw_student_basic;";
		
		//if columnName is not a column name, finish and return null
		ArrayList<StudentBasic> basicInfoList = new ArrayList<StudentBasic>();
		if(!STUDENT_BASIC_COLUMN.contains(columnName)){
			if (columnName == "" && value == "") {
				sql = sqlToGetAll;
			}else{
				//Ghi log
				System.out.println("Table has no the column called "+columnName);
				return basicInfoList;
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
				String birthday = result.getString("birthday");
				String gender = result.getString("gender");
				String college = result.getString("college");
				String major = result.getString("major");
				int inYear = result.getInt("inYear");
				String maritalStatus = result.getString("maritalStatus");
				String nation = result.getString("nation");
				String more = result.getString("more");
				basicInfoList.add(new StudentBasic(id, studentId, birthday, gender, college, inYear, major, maritalStatus, nation, more));
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
		return basicInfoList;
	}
	
	public int addToDB(){
		String sql = "INSERT INTO sw_student_basic(studentId, birthday, gender, college, inYear, major, maritalStatus, nation, more) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);
			prepstmt.setInt(1, this.studentId);
			prepstmt.setString(2, this.birthday);
			prepstmt.setString(3, this.gender);
			prepstmt.setString(4, this.college);
			prepstmt.setInt(5, this.inYear);
			prepstmt.setString(6, this.major);
			prepstmt.setString(7, this.maritalStatus);
			prepstmt.setString(8, this.nation);
			prepstmt.setString(9, this.more);
			result = prepstmt.executeUpdate();
			System.out.print("insert Thanh cong");
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getInYear() {
		return inYear;
	}

	public void setInYear(int inYear) {
		this.inYear = inYear;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}

	public static ArrayList<String> getStudentBasicColumn() {
		return STUDENT_BASIC_COLUMN;
	}
	
}
