package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.TipoMovimientoDTO;
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

	@Override
	public List<TipoMovimientoDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TipoMovimientoDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoMovimientoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoMovimientoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(TipoMovimientoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
    

}
