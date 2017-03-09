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
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import net.viralpatel.struts2.bean.Article;
import net.viralpatel.struts2.dao.ArticleDao;
import net.viralpatel.struts2.service.ArticleServiceImpl;

/**
 * @author luoxiaojun
 *
 */
public class ArticleServiceTest {
	
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ArticleDao articleDao = mock(ArticleDao.class);
		ArticleServiceImpl articleService  = new ArticleServiceImpl();
		articleService.setArticleDao(articleDao);
		Article article = new Article();
		article.setId(1);
		when(articleDao.getArticleById(1)).thenReturn(article);
		assertEquals(articleService.getArticleById(1).getId(), 1);
	}

}
