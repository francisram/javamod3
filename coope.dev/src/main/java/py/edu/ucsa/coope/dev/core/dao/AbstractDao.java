package py.edu.ucsa.coope.dev.core.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class AbstractDao<PK extends Serializable , T> implements GenericDao<PK, T> {
	private final Class<T> persistenclass;
	protected Logger logger = null;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		Type genericSuperClass = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = null;
		while (parameterizedType == null && genericSuperClass != null) {
			if((genericSuperClass  instanceof ParameterizedType)) {
				parameterizedType = (ParameterizedType) genericSuperClass;
			}
			else {
				genericSuperClass = ((Class<?>) genericSuperClass).getGenericSuperclass(); 
			}
			
		}
		if(parameterizedType != null) {
			persistenclass = (Class<T>) parameterizedType.getActualTypeArguments()[1];
			this.logger =  LoggerFactory.getLogger(persistenclass);
			
		}else {
			persistenclass = null;
		}
	}
	
	@PersistenceContext(unitName = "coopedev-pu")
	private EntityManager entityManager;
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		return this.getEntityManager().createQuery("from " + persistenclass.getName()).getResultList();

	}

	@Override
	public T getById(PK id) {
		// TODO Auto-generated method stub
		return (T) this.getEntityManager().find(persistenclass, id);
	}

	@Override
	public T persistir(T entity) {

		return this.getEntityManager().merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T actualizar(T entity) {
		T entityFinded ;
		PK id ;
		try {
			 var idField = persistenclass.getDeclaredField("id");
		        idField.setAccessible(true);
		         id = (PK) idField.get(entity);
		     entityFinded = this.getById(id);
		        if (entityFinded == null) {
		            throw new IllegalArgumentException("No se puede actualizar, la entidad con ID " + id + " no existe.");
		        }
			return this.getEntityManager().merge(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;

	}

	@Override
	public void eliminar(T entity) {
		this.getEntityManager().remove(entity);
		
	}

	@Override
	public void eliminar(PK id) {
		T entity = this.getById(id);
		this.getEntityManager().remove(entity);
		
	}
	
	

}
