package py.edu.ucsa.ejb.dao.impl;

import py.edu.ucsa.ejb.dao.ITorneoDao;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Torneo;

public class TorneoDaoImpl extends AbstractDao<Long, Torneo> implements ITorneoDao {

	public TorneoDaoImpl() {
		super(Torneo.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<Equipo> findByAnho(int anho) {
		// TODO Auto-generated method stub
		return null;
	}

}
