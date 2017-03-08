package net.viralpatel.struts2.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sun.istack.internal.logging.Logger;

import net.viralpatel.struts2.util.PageHibernateCallback;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	
	protected Logger logger  = Logger.getLogger(this.getClass());
	
	public <T>void saveEntity(T entity) {
		
		getHibernateTemplate().saveOrUpdate(entity);
		
	}
	
	public <T>void deleteEntity(T entity) {
		
		getHibernateTemplate().delete(entity);
		
	}
	
	public <T>void deleteEntityById(Class <T>entityClass, Serializable id) {
		
		getHibernateTemplate().delete(entityClass.getName(), id);
		
	}
	
	public <T>void updateEntity(T entity) {
		
		getHibernateTemplate().saveOrUpdate(entity);
		
	}
	
	public <T>T getEntityById(Class <T>entityClass, Serializable id) {
		
		return (T) getHibernateTemplate().get(entityClass, id);
		
	}
	
	public <T>List <T>getAllEntity(Class <T>entityClass) {
		
		return (List<T>) getHibernateTemplate().find("from " + entityClass.getName());
		
	}
	
	public <T>List <T>findByPage(Class <T>entityClass, int offset, int limit) {
        
		String hql="from " + entityClass.getName();
        return (List<T>) getHibernateTemplate().execute((HibernateCallback<T>) new PageHibernateCallback(hql, new Object[]{}, offset, limit));
        
    }
	
	public int countAll(Class entityClass) {
		
		Long count = (Long)getHibernateTemplate().find("select count(*) from " + entityClass.getName()).listIterator().next();
		return count.intValue();
		
	}
}
