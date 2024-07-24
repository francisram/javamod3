package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.MenuEjbRemote;

/**
 * Session Bean implementation class MenuEjbImpl
 */
@Stateless(mappedName = "MenuEjb")
@LocalBean
public class MenuEjbImpl implements MenuEjbRemote {

    /**
     * Default constructor. 
     */
    public MenuEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
