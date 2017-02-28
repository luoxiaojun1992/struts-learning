package net.viralpatel.struts2.action;

import net.viralpatel.struts2.bean.*;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ArticleDetailAction extends ActionSupport {
    private String title;
    private String content;
    private User user;
    
    private String getParam(String key, String ...default_val) {
    	
    	if (default_val.length < 1) {
    		default_val = new String[]{""};
    	}
    	String val = ServletActionContext.getRequest().getParameter(key);
    	return val == null ? default_val[0] : val;
    
    }
    
    public String execute() {
 
    	setTitle(getText("article.title").concat(getParam("id", "222")));
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
