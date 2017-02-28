package net.viralpatel.struts2.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
    
	private String siteName;
	
    public String execute() {
    	
    	this.setSiteName(getText("site.name"));
    	
    	return SUCCESS;
        
    }
    
    public String getSiteName() {
    	
    	return siteName;
    
    }
    
    public void setSiteName(String siteName) {
    	
    	this.siteName = siteName;
    
    }

}
