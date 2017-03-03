package net.viralpatel.struts2.action;

import java.io.IOException;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {
	
    private String username;
    private String password;
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin123";
 
    public String execute() {
 
    	return super.execute();
        
    }
    
    public String submit() throws IOException {
    	
    	super.execute();
    	
    	//Get Login Page
        if (this.username == null 
        		|| this.password == null
        ) {
        	ServletActionContext.getResponse().sendRedirect("login.action");
        	return LOGIN;
        }
    	
    	//Post Login Page
        if (this.username.equals(USERNAME)
                && this.password.equals(PASSWORD)) {
        	
        	Map<String, Object> session = ActionContext.getContext().getSession();
        	session.put("login_flag", getUsername());
        	
        	ServletActionContext.getResponse().sendRedirect("admin/dashboard.action");
            return SUCCESS;
        } else {
            addActionError(getText("error.login"));
            
            ServletActionContext.getResponse().sendRedirect("login.action");
            return ERROR;
        }
        
    }
 
    public String getUsername() {
        
    	return username;
    
    }
 
    public void setUsername(String username) {
        
    	this.username = username;
    
    }
 
    public String getPassword() {
        
    	return password;
    
    }
 
    public void setPassword(String password) {
        
    	this.password = password;
    
    }
}
