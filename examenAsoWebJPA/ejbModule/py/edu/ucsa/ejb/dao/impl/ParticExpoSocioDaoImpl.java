package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
	public ParticExpoSocio ObtenerParticipacion(Exposicion expo, Socio socio) {
		// TODO Auto-generated method stub
		
		
		 TypedQuery<ParticExpoSocio> q = this.entityManager.createNamedQuery("ParticExpoSocio.ObtenerParticipacion", ParticExpoSocio.class);
	        q.setParameter("socio", socio);
	        q.setParameter("exposicion", expo);
	        
	        
	        try {
	        	ParticExpoSocio p = q.getSingleResult();
	        	 return p;
			}catch (NoResultException ex) {
		        System.out.println("No se encontró la participación para socio");
		        return new ParticExpoSocio();  // Retornar un nuevo objeto si no se encuentra resultado
		    } 
	        catch (Exception ex) {
				System.out.println(ex.getMessage());
				return new ParticExpoSocio();
			}
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
