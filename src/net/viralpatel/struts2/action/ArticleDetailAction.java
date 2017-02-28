package net.viralpatel.struts2.action;

import net.viralpatel.struts2.bean.*;

public class ArticleDetailAction extends BaseAction {

    private Article article;
    
    public String execute() {
    	
    	setArticle(new Article(getText("article.title").concat(getParam("id", "222")), getText("article.content")));
    	
    	return super.execute();
        
    }
    
    public Article getArticle() {
    	return article;
    }
    
    public void setArticle(Article article) {
    	this.article = article;
    }
    
}
