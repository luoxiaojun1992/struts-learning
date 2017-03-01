package net.viralpatel.struts2.dao;

import java.io.Serializable;

public interface BaseDao {

    public <T>T getEntityById(Class <T>entityClass, Serializable id);

}
