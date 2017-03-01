package net.viralpatel.struts2.dao;

import java.io.Serializable;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {
	
	public <T>T getEntityById(Class <T>entityClass, Serializable id) {
		
		return (T) getHibernateTemplate().get(entityClass, id);
		
	}
	
}
