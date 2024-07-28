package py.edu.ucsa.ejb.services;

import jakarta.ejb.Remote;
import py.edu.ucsa.ejb.dto.MenuDTO;

@Remote
public interface MenuEjbRemote extends GenericEjbRemote<Long, MenuDTO> {

}
