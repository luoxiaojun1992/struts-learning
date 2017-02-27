package net.viralpatel.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleDetailAction extends ActionSupport {
    private String title;
    private String content;
 
    public String execute() {
 
    	setTitle(getText("article.title"));
    	setContent("test content");
    	return SUCCESS;
        
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
}

