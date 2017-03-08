package net.viralpatel.struts2.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.viralpatel.struts2.bean.Article;

public class ArticleDao extends BaseDaoImpl {
	
	public List<Article> getAllArticles() {
    	
    	return formatArticleList(getAllEntity(Article.class));
		
	}
	
	public Article getArticleById(int id) {
		
		return (Article) getEntityById(Article.class, id);
	
	}
	
	public List<Article> getAllArticlesByPage(int offset, int limit) {
    	
    	return formatArticleList(findByPage(Article.class, offset, limit));
		
	}
	
	public int countAllArticles() {
		
		return countAll(Article.class);
		
	}
	
	private List<Article> formatArticleList(List articleList) {
		
		List<Article> articleArray = new ArrayList<Article>();
		Iterator i = articleList.iterator();
    	while (i.hasNext()) {
    		articleArray.add((Article) i.next());
    	}
    	
    	return articleArray;
		
	}
	
}
