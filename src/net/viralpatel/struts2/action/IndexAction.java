package net.viralpatel.struts2.action;

import java.util.List;
import net.viralpatel.struts2.service.ArticleService;

public class IndexAction extends BaseAction {
	
	private ArticleService articleServ;
	private List articles;
	
    public String execute() {
    	
    	setArticles(getArticleServ().getAllArticles());
    	
    	return super.execute();
        
    }
    
    public void setArticleServ(ArticleService articleServ) {
    	
    	this.articleServ = articleServ;
    
    }
    
    public ArticleService getArticleServ() {
    	
    	return articleServ;
    
    }
    
    public void setArticles(List articles) {
    	
    	this.articles = articles;
    
    }
    
    public List getArticles() {
    	
    	return articles;
    	
    }

}
