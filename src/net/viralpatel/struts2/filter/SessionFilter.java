package net.viralpatel.struts2.filter;

import java.io.IOException;
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  
  
public class SessionFilter implements Filter{  
      
    public void destroy() {  
        //
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {
    	
    	if (((HttpServletRequest) request).getSession().getAttribute("login_flag") == null) { 
    		((HttpServletResponse)response).sendRedirect("login.action");
    	} else {
    		chain.doFilter(request, response);  
        }
    	
    }  
  
    public void init(FilterConfig filterConfig) throws ServletException {  
        
    	//
    	
    }  
  
}
