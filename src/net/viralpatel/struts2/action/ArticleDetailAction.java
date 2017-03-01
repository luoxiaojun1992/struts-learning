package net.viralpatel.struts2.action;

import net.viralpatel.struts2.bean.*;
import net.viralpatel.struts2.service.ArticleService;

public class ArticleDetailAction extends BaseAction {

    private Article article;
    
    private ArticleService articleServ;
    
    public String execute() {
    	
    	setArticle(getArticleServ().getArticleById(Integer.parseInt(getParam("id", "0"))));
    	
    	return super.execute();
        
    }
    
    public Article getArticle() {
    	
    	return article;
    
    }
    
    public void setArticle(Article article) {
    	
    	this.article = article;
    
    }
    
    public void setArticleServ(ArticleService articleServ) {
    	
    	this.articleServ = articleServ;
    
    }
    
    public ArticleService getArticleServ() {
    	
    	return articleServ;
    
    }
    
}
