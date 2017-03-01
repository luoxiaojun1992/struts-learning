package net.viralpatel.struts2.service;

import net.viralpatel.struts2.bean.Article;

import net.viralpatel.struts2.dao.ArticleDao;
import net.viralpatel.struts2.dao.BaseDao;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;
	
	public Article getArticleById(int id) {
		
		return (Article) getArticleDao().getEntityById(Article.class, id);
		
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public BaseDao getArticleDao() {
		return articleDao;
	}
	
}
