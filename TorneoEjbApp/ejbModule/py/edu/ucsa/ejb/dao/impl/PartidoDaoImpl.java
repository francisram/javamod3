package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.IPartidoDao;
import py.edu.ucsa.ejb.entities.Partido;

public class PartidoDaoImpl extends AbstractDao<Long, Partido> implements IPartidoDao {

	public PartidoDaoImpl() {
		super(Partido.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Partido> findByFechaNro(int fechaNro) {
		// TODO Auto-generated method stub
		return this.entityManager.createQuery("SELECT p FROM Partido p WHERE p.fechaNro = fechaNro").setParameter("fechaNro", fechaNro).getResultList();
	}

}
