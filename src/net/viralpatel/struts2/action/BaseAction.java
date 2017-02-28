package net.viralpatel.struts2.action;

import org.apache.struts2.ServletActionContext;
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
    
    protected String getParam(String key, String ...default_val) {
    	
    	if (default_val.length < 1) {
    		default_val = new String[]{""};
    	}
    	
    	String val = ServletActionContext.getRequest().getParameter(key);
    	return val == null ? default_val[0] : val;
    
    }

}
