package py.edu.ucsa.ejb.dao.impl;

import java.util.List;

import py.edu.ucsa.ejb.dao.IOpcionDao;
import py.edu.ucsa.ejb.entities.Opcion;

public class OpcionDaoImpl extends AbstractDao<Long, Opcion> implements IOpcionDao {
	

	public OpcionDaoImpl() {
		super(Opcion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Opcion getOpcionByDominioCodOpcion(String dominio, String codOpcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByCodDominio(String dominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Opcion> getOpcionesByIdDominio(Integer idDominio) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
