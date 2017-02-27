package net.viralpatel.struts2.action;

import java.util.Map;
import net.viralpatel.struts2.bean.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleDetailAction extends ActionSupport {
    private String title;
    private String content;
    private User user;
 
    public String execute() {
 
    	//Get Request Parameters
    	ActionContext context = ActionContext.getContext();
    	Map params = context.getParameters();
    	String articleId = params.getOrDefault("articleId", "111").toString();
    	
    	setTitle(getText("article.title").concat(articleId));
    	setContent(getText("article.content"));
    	setUser(new User());
    	
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
    
    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
}
