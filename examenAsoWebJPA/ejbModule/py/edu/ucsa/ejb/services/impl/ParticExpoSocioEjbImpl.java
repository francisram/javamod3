package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.ParticExpoSocioDTO;
import py.edu.ucsa.ejb.entities.ParticExpoSocio;
import py.edu.ucsa.ejb.services.ParticExpoSocioEjbRemote;

/**
 * Session Bean implementation class ParticExpoSocioEjbImpl
 */
@Stateless(mappedName = "ParticExpoSocioEjb")
@LocalBean
public class ParticExpoSocioEjbImpl implements ParticExpoSocioEjbRemote {
	

    @Override
	public ParticExpoSocio ObtenerParticipacion(Integer id, Integer id_socio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<ParticExpoSocio> obtenerParticipacionesPorSocio(Integer idSocio) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
     * Default constructor. 
     */
    public ParticExpoSocioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<ParticExpoSocioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ParticExpoSocioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ParticExpoSocioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParticExpoSocioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ParticExpoSocioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
