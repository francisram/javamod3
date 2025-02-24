package py.edu.ucsa.coope.dev.core.services;

import java.util.List;

import py.edu.ucsa.coope.dev.web.dto.CiudadDto;

public interface CiudadServices extends GenericService<Integer, CiudadDto>{
	
	public List<CiudadDto> getCiudadesByDepartamento(Integer idDepartamento);
	public void eliminar(Integer id);
}
