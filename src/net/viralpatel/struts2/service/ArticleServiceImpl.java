package net.viralpatel.struts2.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.dao.ArticleDao;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	public Article getArticleById(int id) {
		
		return getArticleDao().getArticleById(id);
		
	}
	
	public List<Article> getAllArticles() {
		
    	return getArticleDao().getAllArticles();
    	
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		
		this.articleDao = articleDao;
	
	}
	
	public ArticleDao getArticleDao() {
		
		return articleDao;
	
	}
	
}
