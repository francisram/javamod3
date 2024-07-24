package py.edu.ucsa.ejb.services.impl;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.services.TipoMovimientoEjbRemote;

/**
 * Session Bean implementation class TipoMovimientoEjbImpl
 */
@Stateless(mappedName = "TipoMovimientoEjb")
@LocalBean
public class TipoMovimientoEjbImpl implements TipoMovimientoEjbRemote {

    /**
     * Default constructor. 
     */
    public TipoMovimientoEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
