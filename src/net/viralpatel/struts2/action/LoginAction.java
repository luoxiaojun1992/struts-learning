package net.viralpatel.struts2.action;

public class LoginAction extends BaseAction {
	
    private String username;
    private String password;
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin123";
 
    public String execute() {
 
    	return super.execute();
        
    }
    
    public String submit() {
    	
    	super.execute();
    	
    	//Get Login Page
        if (this.username == null 
        		|| this.password == null
        ) {
        	return LOGIN;
        }
    	
    	//Post Login Page
        if (this.username.equals(USERNAME)
                && this.password.equals(PASSWORD)) {
            return SUCCESS;
        } else {
            addActionError(getText("error.login"));
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
