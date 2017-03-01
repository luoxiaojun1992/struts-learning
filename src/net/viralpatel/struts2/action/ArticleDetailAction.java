package net.viralpatel.struts2.action;

import net.viralpatel.struts2.bean.*;
import net.viralpatel.struts2.service.ArticleService;

public class ArticleDetailAction extends BaseAction {

    private Article article;
    
    private ArticleService articleServ;
    
    public String execute() {
    	
//    	setArticle(new Article(getText("article.title").concat(getParam("id", "222")), getText("article.content")));
    	
    	setArticle(getArticleServ().getArticleById(getParam("id", "222")));
    	
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
