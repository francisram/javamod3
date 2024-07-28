package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.MensajeEnviadoSocioDTO;
import py.edu.ucsa.ejb.services.MensajeEnviadoSocioEjbRemote;

/**
 * Session Bean implementation class MensajeEnviadoSocioEjbImpl
 */
@Stateless(mappedName = "MensajeEnviadoSocioEjb")
@LocalBean
public class MensajeEnviadoSocioEjbImpl implements MensajeEnviadoSocioEjbRemote {

    @Override
	public List<MensajeEnviadoSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MensajeEnviadoSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MensajeEnviadoSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MensajeEnviadoSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(MensajeEnviadoSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	/**
     * Default constructor. 
     */
    public MensajeEnviadoSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

}
