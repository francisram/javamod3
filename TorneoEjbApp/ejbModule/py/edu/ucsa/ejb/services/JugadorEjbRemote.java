package py.edu.ucsa.ejb.services;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.JugadorDTO;


@Remote
public interface JugadorEjbRemote extends GenericEjbRemote<Long ,JugadorDTO>{
	
	public JugadorDTO getByNombre(String nombre);

	public List<JugadorDTO> findByNombre(String nombre, boolean isNull) throws Exception;
	
	public List<JugadorDTO> findJugadoresSinEquipo() throws Exception;




	
	

}
