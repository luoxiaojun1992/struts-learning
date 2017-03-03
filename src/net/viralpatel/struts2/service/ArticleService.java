package net.viralpatel.struts2.service;

import java.util.List;

import net.viralpatel.struts2.bean.Article;

public interface ArticleService {
	
	public Article getArticleById(int id);
	
	public List<Article> getAllArticles();
	
	public List<Article> getAllArticlesByPage(int offset, int limit);
	
}
