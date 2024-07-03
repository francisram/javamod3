package py.edu.ucsa.ejb.services;

import java.util.List;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.TorneoDTO;


@Remote
public interface TorneoEjbRemote extends GenericEjbRemote<Long , TorneoDTO>{
	public TorneoDTO getByNombre (String nombre);

}
