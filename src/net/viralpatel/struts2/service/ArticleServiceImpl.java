package net.viralpatel.struts2.service;

import net.viralpatel.struts2.bean.Article;

public class ArticleServiceImpl implements ArticleService {

	public Article getArticleById(String id) {
		
		return new Article("test title ".concat(id), "test content");
		
	}
	
}
