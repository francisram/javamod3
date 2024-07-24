package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.CodigoDeSeguridadEjbRemote;

/**
 * Session Bean implementation class CodigoDeSeguridadEjbImpl
 */
@Stateless(mappedName = "CodigoDeSeguridadEjb")
@LocalBean
public class CodigoDeSeguridadEjbImpl implements CodigoDeSeguridadEjbRemote {

    /**
     * Default constructor. 
     */
    public CodigoDeSeguridadEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
