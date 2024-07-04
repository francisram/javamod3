package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import py.edu.ucsa.ejb.dao.ITorneoDao;
import py.edu.ucsa.ejb.dto.TorneoDTO;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.entities.Torneo;
import py.edu.ucsa.ejb.services.TorneoEjbRemote;

/**
 * Session Bean implementation class TorneoEjbImpl
 */
@Stateless(mappedName = "torneoEJB")
@LocalBean
public class TorneoEjbImpl implements TorneoEjbRemote {
	
	private List<Torneo> listaTorneos = new ArrayList<Torneo>();

	@Inject
	private ITorneoDao iDao;
	
    /**
     * Default constructor. 
     */
    public TorneoEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<TorneoDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		Stream<Torneo> torneos = StreamSupport.stream(iDao.findAll().spliterator(), false) ;
		return torneos.map(Torneo::toDTO).toList();
	}

	@Override
	public void insert(TorneoDTO dto) throws Exception {
		iDao.insert(Torneo.ofDTO(dto));
		
	}

	@Override
	public List<TorneoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TorneoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TorneoDTO insertar(TorneoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(TorneoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TorneoDTO getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
