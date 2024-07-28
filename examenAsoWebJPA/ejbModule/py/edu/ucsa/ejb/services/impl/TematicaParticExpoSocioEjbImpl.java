package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.TematicaParticExpoSocioDTO;
import py.edu.ucsa.ejb.services.TematicaParticExpoSocioEjbRemote;

/**
 * Session Bean implementation class TematicaParticExpoSocioEjbImpl
 */
@Stateless(mappedName = "TematicaParticExpoSocioEjb")
@LocalBean
public class TematicaParticExpoSocioEjbImpl implements TematicaParticExpoSocioEjbRemote {

    /**
     * Default constructor. 
     */
    public TematicaParticExpoSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<TematicaParticExpoSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TematicaParticExpoSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TematicaParticExpoSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TematicaParticExpoSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(TematicaParticExpoSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
