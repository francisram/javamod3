package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.UsuarioEjbRemote;

/**
 * Session Bean implementation class UsuarioEjbImpl
 */
@Stateless(mappedName = "UsuarioEjb")
@LocalBean
public class UsuarioEjbImpl implements UsuarioEjbRemote {

    /**
     * Default constructor. 
     */
    public UsuarioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
