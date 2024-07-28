package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.MontoCuotaDTO;

@Remote
public interface MontoCuotaEjbRemote extends GenericEjbRemote<Long, MontoCuotaDTO> {

}
