package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.EstadoSocioDTO;
import py.edu.ucsa.ejb.services.EstadoSocioEjbRemote;

/**
 * Session Bean implementation class EstadoSocioEjbImpl
 */
@Stateless(mappedName = "EstadoSocioEjb")
@LocalBean
public class EstadoSocioEjbImpl implements EstadoSocioEjbRemote {

    /**
     * Default constructor. 
     */
    public EstadoSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<EstadoSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EstadoSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EstadoSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(EstadoSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
