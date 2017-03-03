package net.viralpatel.struts2.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.viralpatel.struts2.bean.Article;

public class ArticleDao extends BaseDaoImpl {
	
	public List<Article> getAllArticles() {
		
		List<Article> articleArray = new ArrayList<Article>();
    	
    	List articleList = getAllEntity(Article.class);
    	Iterator i = articleList.iterator();
    	while (i.hasNext()) {
    		articleArray.add((Article) i.next());
    	}
    	
    	return articleArray;
		
	}
	
	public Article getArticleById(int id) {
		
		return (Article) getEntityById(Article.class, id);
	
	}
	
}
