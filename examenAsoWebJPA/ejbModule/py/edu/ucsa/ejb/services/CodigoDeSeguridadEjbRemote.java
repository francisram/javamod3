package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.CodigoDeSeguridadDTO;

@Remote
public interface CodigoDeSeguridadEjbRemote extends GenericEjbRemote<Long, CodigoDeSeguridadDTO>{

}
