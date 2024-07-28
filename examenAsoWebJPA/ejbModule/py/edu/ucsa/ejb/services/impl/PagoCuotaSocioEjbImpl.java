package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.PagoCuotaSocioDTO;
import py.edu.ucsa.ejb.services.PagoCuotaSocioEjbRemote;

/**
 * Session Bean implementation class PagoCuotaSocioEjbImpl
 */
@Stateless(mappedName = "PagoCuotaSocioEjb")
@LocalBean
public class PagoCuotaSocioEjbImpl implements PagoCuotaSocioEjbRemote {

    @Override
	public List<PagoCuotaSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PagoCuotaSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PagoCuotaSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PagoCuotaSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(PagoCuotaSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Default constructor. 
     */
    public PagoCuotaSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
