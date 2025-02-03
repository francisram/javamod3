package py.edu.ucsa.coope.dev.core.services;

import java.util.List;

import py.edu.ucsa.coope.dev.core.entities.Barrio;



public interface BarrioServices extends GenericService<Integer, Barrio, Barrio> {

	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad);
}
