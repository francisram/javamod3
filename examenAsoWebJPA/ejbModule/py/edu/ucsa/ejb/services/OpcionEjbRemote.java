package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.entities.Dominio;
import py.edu.ucsa.ejb.entities.Opcion;

@Remote
public interface OpcionEjbRemote extends GenericEjbRemote<Long, OpcionDTO> {
	
	Opcion getOpcionByDominioCodOpcion(Dominio dominio,Opcion codOpcion);
	Iterable<Opcion> getOpcionesByIdDominio(Dominio dominio);

}
