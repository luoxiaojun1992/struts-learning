package net.viralpatel.struts2.action;

import com.opensymphony.xwork2.ActionContext;

public class DashboardAction extends BaseAction {

	private String username;
	
	public String execute() {
    	
		setUsername(ActionContext.getContext().getSession().get("login_flag").toString());
		
    	return super.execute();
        
    }
	
	public String getUsername() {
        
    	return username;
    
    }
 
    public void setUsername(String username) {
        
    	this.username = username;
    
    }
	
}
