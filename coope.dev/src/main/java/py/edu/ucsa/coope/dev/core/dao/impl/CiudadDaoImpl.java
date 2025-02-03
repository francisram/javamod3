package py.edu.ucsa.coope.dev.core.dao.impl;

import java.util.List;

import py.edu.ucsa.coope.dev.core.dao.AbstractDao;
import py.edu.ucsa.coope.dev.core.entities.Ciudad;

public class CiudadDaoImpl extends AbstractDao<Integer, Ciudad>{

	@SuppressWarnings("unchecked")
	public List<Ciudad> getBarriosByIdCiudad(Integer idDepartamento){
		
		/*forma 1 de hacer*/
//		Query q = this.getEntityManager().createNamedQuery("Ciudad.getCiudadesByDepto");
//		q.setParameter("idDepartamento", idCiudad);
//		List<Barrio> resultado =  q.getResultList();
//		return resultado;
		
		/* otro metodo igual */
		return this.getEntityManager().createNamedQuery("Ciudad.getCiudadesByDepto").setParameter("idDepartamento", idDepartamento).getResultList();
		
	}
}
