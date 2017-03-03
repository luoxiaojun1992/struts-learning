package net.viralpatel.struts2.action;

import java.util.List;
import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.service.ArticleService;
import redis.clients.jedis.Jedis;

public class IndexAction extends BaseAction {
	
	private ArticleService articleServ;
	private List<Article> articles;
	
    public String execute() {
    
    	Jedis jedis = new Jedis("127.0.0.1", 6379);
    	jedis.set("a", "like");
    	System.out.println(jedis.get("a"));
    	
    	setArticles(getArticleServ().getAllArticlesByPage(0, 1));
    	
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
