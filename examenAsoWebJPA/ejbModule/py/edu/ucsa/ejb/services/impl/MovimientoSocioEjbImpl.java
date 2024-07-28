package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.MovimientoSocioDTO;
import py.edu.ucsa.ejb.services.MovimientoSocioEjbRemote;

/**
 * Session Bean implementation class MovimientoSocioEjbImpl
 */
@Stateless(mappedName = "MovimientoSocioEjb")
@LocalBean
public class MovimientoSocioEjbImpl implements MovimientoSocioEjbRemote {

    /**
     * Default constructor. 
     */
    public MovimientoSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<MovimientoSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MovimientoSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MovimientoSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimientoSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(MovimientoSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
