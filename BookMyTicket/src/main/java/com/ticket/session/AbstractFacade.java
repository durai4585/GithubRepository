package com.ticket.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Session Bean implementation class AbstractFacade
 */

public abstract class AbstractFacade<T> {

	Class<T> entityClass;
	

	 protected abstract EntityManager getEntityManager();
	
	public AbstractFacade() {


	}

	/**
	 * Default constructor.
	 */
	public AbstractFacade(Class<T> entityClass) {

		this.entityClass = entityClass;

	}

	public List<T> findAll(){
    	
    	CriteriaBuilder builder =  getEntityManager().getCriteriaBuilder();
    	CriteriaQuery<T> cQuery = builder.createQuery(entityClass);
    	Root<T> root = cQuery.from(entityClass);
    	cQuery.select(root);
    	
    	TypedQuery<T> typedQry = getEntityManager().createQuery(cQuery);
    	return typedQry.getResultList();
    	
    	
    }
	
	public List<T> getAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
	
	 public T find(Object id) {
	        return getEntityManager().find(entityClass, id);
	    }

	 public int count() {
	        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
	        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
	        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
	        javax.persistence.Query q = getEntityManager().createQuery(cq);
	        return ((Long) q.getSingleResult()).intValue();
	    }
}
