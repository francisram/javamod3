package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import py.edu.ucsa.ejb.dao.IOpcionDao;
import py.edu.ucsa.ejb.entities.Dominio;
import py.edu.ucsa.ejb.entities.Opcion;

@RequestScoped
@Named("opcionDAO")
public class OpcionDaoImpl extends AbstractDao<Long, Opcion> implements IOpcionDao {

	public OpcionDaoImpl() {
		super(Opcion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Opcion getOpcionByDominioCodOpcion(String dominio, String codOpcion) {
		TypedQuery<Opcion> q = this.entityManager.createNamedQuery("Opcion.getOpcionByDominioCodOpcion", Opcion.class);
		q.setParameter("dominio", dominio);
		q.setParameter("opcion", codOpcion);
		Opcion opcion = q.getSingleResult();
		return opcion;
	}

	@Override
	public Iterable<Opcion> getOpcionesByIdDominio(Dominio dominio) {
		// TODO Auto-generated method stub

		return  this.entityManager.createNamedQuery("Opcion.getOpcionByDominio", Opcion.class).setParameter("dominio", dominio).getResultList();

	}

}
