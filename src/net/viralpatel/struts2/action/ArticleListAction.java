package net.viralpatel.struts2.action;

import java.util.List;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.service.ArticleService;

public class ArticleListAction extends BaseAction {

	private ArticleService articleServ;
	private List<Article> articles;
	private int prevPageNum;
	private int nextPageNum;
	
	public final static int COUNT_PER_PAGE = 10;
	
	public String execute() {
    	
		int page = Integer.parseInt(getParam("page", "1"));
		setPrevPageNum(page == 1 ? page : (page - 1));
		setNextPageNum(page == (int)Math.ceil((double)getArticleServ().countAllArticles() / (double)COUNT_PER_PAGE) ? page : (page + 1));
		
    	setArticles(getArticleServ().getAllArticlesByPage((page - 1) * COUNT_PER_PAGE, COUNT_PER_PAGE));
    	
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
    
    public void setPrevPageNum(int prevPageNum) {
    	
    	this.prevPageNum = prevPageNum;
    	
    }
    
    public int getPrevPageNum() {
    	
    	return this.prevPageNum;
    	
    }
    
    public void setNextPageNum(int nextPageNum) {
    	
    	this.nextPageNum = nextPageNum;
    	
    }
    
    public int getNextPageNum() {
    	
    	return this.nextPageNum;
    	
    }
	
}
