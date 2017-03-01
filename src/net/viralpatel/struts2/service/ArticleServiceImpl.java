package net.viralpatel.struts2.service;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.dao.ArticleDao;

public class ArticleServiceImpl implements ArticleService {

	public Article getArticleById(int id) {
		
		return (Article) new ArticleDao().getEntityById(Article.class, id);
		
	}
	
}
