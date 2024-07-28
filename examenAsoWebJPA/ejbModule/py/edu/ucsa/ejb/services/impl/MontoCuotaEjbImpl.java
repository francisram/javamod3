package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.MontoCuotaDTO;
import py.edu.ucsa.ejb.services.MontoCuotaEjbRemote;

/**
 * Session Bean implementation class MontoCuotaEjbImpl
 */
@Stateless(mappedName = "MontoCuotaEjb")
@LocalBean
public class MontoCuotaEjbImpl implements MontoCuotaEjbRemote {

    @Override
	public List<MontoCuotaDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MontoCuotaDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MontoCuotaDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MontoCuotaDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(MontoCuotaDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Default constructor. 
     */
    public MontoCuotaEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
