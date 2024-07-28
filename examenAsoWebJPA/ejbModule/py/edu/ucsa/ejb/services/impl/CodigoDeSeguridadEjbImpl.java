package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.CodigoDeSeguridadDTO;
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

	@Override
	public List<CodigoDeSeguridadDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(CodigoDeSeguridadDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CodigoDeSeguridadDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodigoDeSeguridadDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(CodigoDeSeguridadDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}
    

}
