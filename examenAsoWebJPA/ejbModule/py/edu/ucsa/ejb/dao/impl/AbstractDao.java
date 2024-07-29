package py.edu.ucsa.ejb.dao.impl;

import java.io.Serializable;
import java.util.logging.Logger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import py.edu.ucsa.ejb.dao.IGenericDao;

public class AbstractDao <PK extends Serializable , T> implements IGenericDao<PK, T>{
	
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

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findById(PK id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T insert(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(PK id) {
		// TODO Auto-generated method stub
		
	}

}
