package py.edu.ucsa.coope.dev.core.services;

import java.util.List;

import py.edu.ucsa.coope.dev.web.dto.BarrioDto;





public interface BarrioService extends GenericService<Integer, BarrioDto> {

	public List<BarrioDto> getBarriosByIdCiudad(Integer idCiudad);
	public void eliminar(Integer id);
}
