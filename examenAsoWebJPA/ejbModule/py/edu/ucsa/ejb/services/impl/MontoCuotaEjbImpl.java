package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.MontoCuotaEjbRemote;

/**
 * Session Bean implementation class MontoCuotaEjbImpl
 */
@Stateless(mappedName = "MontoCuotaEjb")
@LocalBean
public class MontoCuotaEjbImpl implements MontoCuotaEjbRemote {

    /**
     * Default constructor. 
     */
    public MontoCuotaEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
