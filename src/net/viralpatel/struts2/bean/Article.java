package net.viralpatel.struts2.bean;

import java.util.Date;

public class Article {
	
	private int id;
	private String title;
	private String content;
	private Date publishAt;
	private Date updateAt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getPublishAt() {
		return publishAt;
	}
	
	public void setPublishAt(Date publishAt) {
		this.publishAt = publishAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}
	
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
