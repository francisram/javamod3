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

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub
		return this.entityManager.createNamedQuery(persistentClass.getSimpleName()+".findAll").getResultList();
		
	}

	@Override
	public T findById(PK id) {
		return (T) this.entityManager.find(persistentClass, id);
		//return null;
	}

	@Override
	public T insert(T entity) {
		// TODO Auto-generated method stub
		return (T) entityManager.merge(entity);
	}

	@Override
	public T update(T entity) {
		// TODO Auto-generated method stub
		return (T) entityManager.merge(entity);
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
		
	}

	@Override
	public void deleteById(PK id) {
		this.entityManager.remove(this.findById(id));
		
	}
	

}
