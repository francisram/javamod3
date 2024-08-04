package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.entities.Opcion;

@Remote
public interface OpcionEjbRemote extends GenericEjbRemote<Long, OpcionDTO> {
	
	Opcion getOpcionByDominioCodOpcion(String dominio,String codOpcion);
	Iterable<Opcion> getOpcionesByCodDominio(String dominio);
	Iterable<Opcion> getOpcionesByIdDominio(Integer idDominio);

}
