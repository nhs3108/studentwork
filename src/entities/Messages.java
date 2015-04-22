package entities;

import java.util.Date;

public class Messages implements java.io.Serializable {

	private Integer id;
	private int ownerId;
	private int senderId;
	private String content;
	private int status;
	private Date readTime;
	private Date sendTime;

	public Messages() {
	}

	public Messages(int ownerId, int senderId, String content, int status,
			Date sendTime) {
		this.ownerId = ownerId;
		this.senderId = senderId;
		this.content = content;
		this.status = status;
		this.sendTime = sendTime;
	}

	public Messages(int ownerId, int senderId, String content, int status,
			Date readTime, Date sendTime) {
		this.ownerId = ownerId;
		this.senderId = senderId;
		this.content = content;
		this.status = status;
		this.readTime = readTime;
		this.sendTime = sendTime;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getSenderId() {
		return this.senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getReadTime() {
		return this.readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

}
