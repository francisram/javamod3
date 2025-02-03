package py.edu.ucsa.coop.dev.core.dao;

import java.util.List;

import py.edu.ucsa.coope.dev.core.entities.Barrio;

public interface BarrioDao extends GenericDao<Integer, Barrio> {
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad);
}
