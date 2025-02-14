package py.edu.ucsa.ejb.dao.impl;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IPartidoDao;
import py.edu.ucsa.ejb.entities.Partido;

@RequestScoped
@Named("partidoDAO")
public class PartidoDaoImpl extends AbstractDao<Long, Partido> implements IPartidoDao {

	public PartidoDaoImpl() {
		super(Partido.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Partido> findByFechaNro(int fechaNro) {
		// TODO Auto-generated method stub
		return this.entityManager.createQuery("SELECT p FROM PartidoDTO p WHERE p.fechaNro = :fechaNro").setParameter("fechaNro", fechaNro).getResultList();
	}

}
