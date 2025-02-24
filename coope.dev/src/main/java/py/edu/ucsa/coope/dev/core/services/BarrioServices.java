package py.edu.ucsa.coope.dev.core.services;

import java.util.List;

import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;



public interface BarrioServices extends GenericService<Integer, BarrioDto> {

	public List<BarrioDto> getBarriosByIdCiudad(Integer idCiudad);
	public void eliminar(Integer id);
}
