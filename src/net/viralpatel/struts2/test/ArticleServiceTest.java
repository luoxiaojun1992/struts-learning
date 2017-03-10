/**
 * 
 */
package net.viralpatel.struts2.test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.dao.ArticleDao;
import net.viralpatel.struts2.service.ArticleServiceImpl;

/**
 * @author luoxiaojun
 *
 */
public class ArticleServiceTest {
	
	private ArticleDao articleDao;
	private ArticleServiceImpl articleService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		setArticleDao(mock(ArticleDao.class));
		setArticleService(new ArticleServiceImpl());
		getArticleService().setArticleDao(getArticleDao());
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetArticleById() {
		
		Article article = new Article();
		article.setId(1);
		when(getArticleDao().getArticleById(1)).thenReturn(article);
		assertEquals(getArticleService().getArticleById(1).getId(), 1);
	
	}
	
	@Test
	public void testGetAllArticles() {
		
		List<Article> articleList = new ArrayList<Article>();
		
		for (int i = 0; i < 3; ++i) {
			
			Article article = new Article();
			article.setId(1);
			articleList.add(article);
			
		}
		
		when(getArticleDao().getAllArticles()).thenReturn(articleList);
		
		Iterator<Article> i = getArticleService().getAllArticles().iterator();
		while(i.hasNext()) {
			assertEquals(i.next().getId(), 1);
		}
		
	}
	
	@Test
	public void testCountAllArticles() {
		
		when(getArticleDao().countAllArticles()).thenReturn(1);
		assertEquals(getArticleService().countAllArticles(), 1);
	
	}
	
	public void setArticleDao(ArticleDao articleDao) {
		
		this.articleDao = articleDao;
	
	}

	public ArticleDao getArticleDao() {
		
		return articleDao;
		
	}
	
	public void setArticleService(ArticleServiceImpl articleService) {
		
		this.articleService = articleService;
		
	}
	
	public ArticleServiceImpl getArticleService() {
		
		return articleService;
		
	}
	
}
