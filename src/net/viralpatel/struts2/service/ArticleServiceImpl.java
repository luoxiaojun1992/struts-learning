package net.viralpatel.struts2.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import net.viralpatel.struts2.bean.Article;

public class ArticleServiceImpl implements ArticleService {

	public Article getArticleById(int id) {
		
		//读取hibernate.cfg.xml文件  
        Configuration cfg = new Configuration().configure();  
        
        //建立SessionFactory  
        SessionFactory factory =cfg.buildSessionFactory();  
          
        //取得session  
        Session session = null;  
          
        try {
        	
            //开启session  
            session = factory.openSession();
            
            //开启事务  
            session.beginTransaction();
            
            Article article = (Article)session.get(Article.class, id);
              
            //提交事务  
            session.getTransaction().commit();
            
            return article;
              
        } catch(Exception e) {
        	
            e.printStackTrace();  
            
            //回滚事务
            session.getTransaction().rollback();  
        
        } finally {  
            
        	if (session != null && session.isOpen()) {  
            	
        		//关闭session
            	session.close();  
            
        	}
        	
        }
		
		return new Article();
		
	}
	
}
