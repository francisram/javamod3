package py.edu.ucsa.coop.dev.core.dao.impl;

import java.util.List;

import jakarta.persistence.Query;
import py.edu.ucsa.coop.dev.core.dao.AbstractDao;
import py.edu.ucsa.coop.dev.core.dao.BarrioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;

public class BarrioDaoImpl extends AbstractDao<Integer, Barrio> implements BarrioDao{

	@SuppressWarnings("unchecked")
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad){
		
		/*forma 1 de hacer*/
//		Query q = this.getEntityManager().createNamedQuery("Barrio.getBarriosByIdCiudad");
//		q.setParameter("idCiudad", idCiudad);
//		List<Barrio> barrios =  q.getResultList();
//		return barrios;
		
		/* otro metodo igual */
		return this.getEntityManager().createNamedQuery("Barrio.getBarriosByIdCiudad").setParameter("idCiudad", idCiudad).getResultList();
		
	}
	
}
