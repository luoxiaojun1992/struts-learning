package net.viralpatel.struts2.action;

import java.io.IOException;
import java.util.List;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.helper.MarkdownHelper;
import net.viralpatel.struts2.helper.RedisHelper;
import net.viralpatel.struts2.service.ArticleService;

public class IndexAction extends BaseAction {
	
	private ArticleService articleServ;
	private List<Article> articles;
	
	public final static int COUNT_PER_PAGE = 10;
	
    public String execute() {
    
    	RedisHelper redisHelper = RedisHelper.getInstance();
    	redisHelper.set("a", "like");
    	System.out.println(redisHelper.get("a"));
    	
    	try {
    		System.out.println(MarkdownHelper.getInstance().parse("This is ***TXTMARK***"));
    	} catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	setArticles(getArticleServ().getAllArticlesByPage(0, COUNT_PER_PAGE));
    	
    	return super.execute();
        
    }
    
    public void setArticleServ(ArticleService articleServ) {
    	
    	this.articleServ = articleServ;
    
    }
    
    public ArticleService getArticleServ() {
    	
    	return articleServ;
    
    }
    
    public void setArticles(List<Article> articles) {
    	
    	this.articles = articles;
    
    }
    
    public List<Article> getArticles() {
    	
    	return articles;
    	
    }

}
