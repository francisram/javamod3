package py.edu.ucsa.ejb.dao.impl;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import py.edu.ucsa.ejb.dao.IGenericDao;

public abstract class AbstractDao <PK extends Serializable , T> implements IGenericDao<PK, T>{
	
	private final Class<T> persistentClass;
	protected Logger LOGGER = null;
	
	public AbstractDao(Class<T> clazz){
		this.persistentClass = clazz;
		this.LOGGER = Logger.getLogger(persistentClass.getName());
	}
	
	@PersistenceContext(name = "TorneoJPA")
	protected EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
	

}
