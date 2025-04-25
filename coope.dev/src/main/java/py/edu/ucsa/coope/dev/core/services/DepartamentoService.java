package py.edu.ucsa.coope.dev.core.services;


import py.edu.ucsa.coope.dev.web.dto.DepartamentoDto;

public interface DepartamentoService extends GenericService<Integer, DepartamentoDto> {
	public void eliminar(Integer id);
}
