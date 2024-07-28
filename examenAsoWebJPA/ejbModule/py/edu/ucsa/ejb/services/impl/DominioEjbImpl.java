package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.DominioDTO;
import py.edu.ucsa.ejb.services.DominioEjbRemote;

/**
 * Session Bean implementation class DominioEjbImpl
 */
@Stateless(mappedName = "DominioEjb")
@LocalBean
public class DominioEjbImpl implements DominioEjbRemote {

    /**
     * Default constructor. 
     */
    public DominioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DominioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(DominioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DominioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DominioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(DominioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
