package entities;

import java.util.Date;

public class Feedbacks implements java.io.Serializable {

	private Integer id;
	private int userId;
	private String content;
	private Date time;

	public Feedbacks() {
	}

	public Feedbacks(int userId, String content, Date time) {
		this.userId = userId;
		this.content = content;
		this.time = time;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
