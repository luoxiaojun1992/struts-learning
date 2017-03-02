package net.viralpatel.struts2.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sun.istack.internal.logging.Logger;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	
	protected Logger logger  = Logger.getLogger(this.getClass());
	
	public <T>void saveEntity(T entity) {
		
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}
	
	public <T>void deleteEntity(T entity) {
		
		this.getHibernateTemplate().delete(entity);
		
	}
	
	public <T>void deleteEntityById(Class <T>entityClass, Serializable id) {
		
		this.getHibernateTemplate().delete(entityClass.getName(), id);
		
	}
	
	public <T>void updateEntity(T entity) {
		
		this.getHibernateTemplate().saveOrUpdate(entity);
		
	}
	
	public <T>T getEntityById(Class <T>entityClass, Serializable id) {
		
		return (T) getHibernateTemplate().get(entityClass, id);
		
	}
	
	public <T>List <T>getAllEntity(Class <T>entityClass) {
		
		return (List<T>) this.getHibernateTemplate().find("from " + entityClass.getName());
		
	}
	
}
