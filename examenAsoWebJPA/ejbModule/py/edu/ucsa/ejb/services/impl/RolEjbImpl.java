package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.RolDTO;
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

	@Override
	public List<RolDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RolDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(RolDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
