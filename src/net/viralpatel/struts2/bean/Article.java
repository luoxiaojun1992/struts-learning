package net.viralpatel.struts2.bean;

public class Article {
	
	private String title;
	private String content;
	private String publishAt;
	
	public Article(String title, String content) {
		setTitle(title);
		setContent(content);
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
	
	public String getPublishAt() {
		return publishAt;
	}
	
	public void setPublishAt(String publishAt) {
		this.publishAt = publishAt;
	}

}
