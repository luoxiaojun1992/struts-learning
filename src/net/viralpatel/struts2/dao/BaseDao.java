package net.viralpatel.struts2.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao {

	public <T>void saveEntity(T entity);
	
	public <T>void deleteEntity(T entity);
	
	public <T>void deleteEntityById(Class <T>entityClass, Serializable id);
	
	public <T>void updateEntity(T entity);
	
    public <T>T getEntityById(Class <T>entityClass, Serializable id);

    public <T>List <T>getAllEntity(Class <T>entityClass);
    
}
