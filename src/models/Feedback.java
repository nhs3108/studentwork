package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Feedback {
	protected int userId;
	protected String content;
	protected String time;
	
	public Feedback(int userId, String content, String time) {
		this.userId = userId;
		this.content = content;
		this.time = time;
	}
	public int pushNew(){
		Connection connection = null;
		PreparedStatement prepstmt = null;
        int n = 0;
        try {
            connection = MyConnection.getConnection();
            String sql = "INSERT INTO feedbacks(user_id,content,time) VALUES(?,?,?)";
            prepstmt =  connection.prepareStatement(sql);
            prepstmt.setInt(1, userId);
            prepstmt.setString(2, content);
            prepstmt.setString(3, time);
            n = prepstmt.executeUpdate();
            System.out.println("Insert thanh cong");

        } catch (Exception e) {
            System.out.println(e.toString());
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
        return n;
	}


	public static Feedback getFeedbackById(int id) {
		String sql = "SELECT * FROM feedbacks WHERE id=" + id + ";";
		Connection connection = null;
		Statement statement = null;
		Feedback feedback = null;
			try {
				connection = MyConnection.getConnection();
				statement = connection.createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					int userId = Integer.parseInt(result.getString("user_id"));
					String content = result.getString("content");
					String time = result.getString("time");
					feedback = new Feedback(userId, content, time);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				// finally block used to close resources
				try {
					if (statement != null) {
						statement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		System.out.print(sql);
		return feedback;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
}
