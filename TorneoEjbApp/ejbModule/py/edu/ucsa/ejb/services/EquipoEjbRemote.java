package py.edu.ucsa.ejb.services;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.EquipoDTO;


@Remote
public interface EquipoEjbRemote extends GenericEjbRemote<Long ,EquipoDTO> {

	public EquipoDTO getByNombre(String nombre);
	
	public List<EquipoDTO> findByNombre(String nombre , boolean isNull) throws Exception;
	

	

}
