package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import py.edu.ucsa.ejb.dao.IParticExpoSocioDao;
import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.entities.Socio;


@RequestScoped
@Named("particExpoSocioDao")
public class ParticExpoSocioDaoImpl extends AbstractDao<Long, ParticExpoSocio> implements IParticExpoSocioDao {

	
	public ParticExpoSocioDaoImpl() {
		super(ParticExpoSocio.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Socio idSocio) {
		// TODO Auto-generated method stub
		
		Query q = this.entityManager.createNamedQuery("ParticExpoSocio.obtenerParticipacionesPorSocio");
		q.setParameter("socio", idSocio);

		return q.getResultList();
	}



	
	
}
