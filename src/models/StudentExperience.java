package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentExperience {
	protected int id;
	protected int studentId;
	protected String company;
	protected String title;
	protected String startTime;
	protected String finishTime;
	protected String more;
	public static final ArrayList<String> STUDENT_EXP_COLUMN = new ArrayList<>();
	static{
		STUDENT_EXP_COLUMN.add("id");
		STUDENT_EXP_COLUMN.add("studentId");
		STUDENT_EXP_COLUMN.add("company");
		STUDENT_EXP_COLUMN.add("title");
		STUDENT_EXP_COLUMN.add("startTime");
		STUDENT_EXP_COLUMN.add("finishTime");
		STUDENT_EXP_COLUMN.add("more");
	}
	public StudentExperience() {
		
	}
	
	public StudentExperience(int id, int studentId, String company,
			String title, String startTime, String finishTime, String more) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.company = company;
		this.title = title;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.more = more;
	}
	
	public static ArrayList<StudentExperience> getStudentExps(String columnName,String value){
		ArrayList<StudentExperience> experienceList = new ArrayList<StudentExperience>();
		String sql = "SELECT * FROM sw_student_exp WHERE "+ columnName +"=?;";
		String sqlToGetAll = "SELECT * FROM sw_student_exp;";
		//if columnName is not a column name, finish and return null
		if(!STUDENT_EXP_COLUMN.contains(columnName)){
			if (columnName == "" && value == "") {
				sql = sqlToGetAll;
			}else{
				//Ghi log
				System.out.println("Table has no the column called "+columnName);
				return experienceList;
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
				String company = result.getString("company");
				String title = result.getString("title");
				String startTime = result.getString("startTime");
				String finishTime = result.getString("finishTime");
				String more = result.getString("more");
				experienceList.add(new StudentExperience(id, studentId, company, title, startTime, finishTime, more));
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
        return experienceList;
	}
	
	public int addToDB(){
		String sql = "INSERT INTO sw_student_exp(studentId,company,title,startTime,finishTime,more) "
				+ "VALUES(?,?,?,?,?,?)";
		Connection connection = null;
		PreparedStatement prepstmt = null;
		int result = 0;
		try{
			connection = MyConnection.getConnection();
			prepstmt = connection.prepareStatement(sql);;
			prepstmt.setInt(1, this.studentId);
			prepstmt.setString(2, this.company);
			prepstmt.setString(3, this.title);
			prepstmt.setString(4, this.startTime);
			prepstmt.setString(5, this.finishTime);
			prepstmt.setString(6, this.more);
			
			result = prepstmt.executeUpdate();
			System.out.print("Inserted into sw_student_exp successfully!");
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getMore() {
		return more;
	}

	public void setMore(String more) {
		this.more = more;
	}
	public static void main(String a[]){
		StudentExperience s = new StudentExperience();
		s.company = "s";
		System.out.print(s.company);
	}
}
