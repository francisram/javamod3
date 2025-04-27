package py.edu.ucsa.coope.dev.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractDao<PK extends Serializable, T> implements GenericDao<PK, T> {

    private final Class<T> persistenClass;
	protected Logger logger = null;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		
		Type genericSuperClass = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = null;
		while (parameterizedType == null && genericSuperClass != null) {
			if((genericSuperClass instanceof ParameterizedType)) {
				parameterizedType = (ParameterizedType)genericSuperClass;
			}else {
				genericSuperClass = ((Class<?>)genericSuperClass).getGenericSuperclass();
			}
		}
		if(parameterizedType!=null) {
			persistenClass = (Class<T>)parameterizedType.getActualTypeArguments()[1];
			this.logger = LoggerFactory.getLogger(persistenClass);
		}else {
			persistenClass=null;	
		}

	}

	@PersistenceContext(name = "coopedev-pu")
	protected EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@SuppressWarnings("unchecked")
	public Iterable<T> findAll() {
		return this.entityManager.createNamedQuery(persistenClass.getSimpleName() + ".findAll").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		//return this.entityManager.createNamedQuery(persistentClass.getSimpleName() + ".findAll").getResultList();
		return this.entityManager.createQuery("from " + persistenClass.getName()).getResultList();
	}
	
	@Override
	public T getById(PK id) {
		return (T) entityManager.find(persistenClass, id);
	}
	
	@Override
	public T persistir(T entity) {
		return (T) entityManager.merge(entity);
	}
	
	@Override
	public T actualizar(T entity) {
		return (T) entityManager.merge(entity);
	}
	
	@Override
	public void eliminar(T entity) {
		entityManager.remove(entity);
	}
	
	@Override
	public void eliminar(PK id) {
		this.entityManager.remove(this.getById(id));
	}
	

}
