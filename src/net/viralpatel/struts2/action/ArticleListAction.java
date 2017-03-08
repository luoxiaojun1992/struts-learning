package net.viralpatel.struts2.action;

import java.util.List;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.service.ArticleService;

public class ArticleListAction extends BaseAction {

	private ArticleService articleServ;
	private List<Article> articles;
	
	public final static int COUNT_PER_PAGE = 10;
	
	public String execute() {
    	
		int page = Integer.parseInt(getParam("page", "1"));
		int countOfAllArticles = getArticleServ().countAllArticles();
		int pageTotal = countOfAllArticles / COUNT_PER_PAGE;
		int prevPage, nextPage;
		prevPage = page == 1 ? page : (page - 1);
		
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
