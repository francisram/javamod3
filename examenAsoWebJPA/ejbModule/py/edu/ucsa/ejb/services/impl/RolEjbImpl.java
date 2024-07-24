package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.RolEjbRemote;

/**
 * Session Bean implementation class RolEjbImpl
 */
@Stateless(mappedName = "RolEjb")
@LocalBean
public class RolEjbImpl implements RolEjbRemote {

    /**
     * Default constructor. 
     */
    public RolEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
