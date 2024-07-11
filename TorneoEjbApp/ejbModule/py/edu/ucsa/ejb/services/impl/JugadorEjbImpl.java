package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.jws.WebService;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.services.JugadorEjbRemote;

/**
 * Session Bean implementation class JugadorEjbImpl
 */
@Stateless(mappedName = "jugadorEJB")
@WebService
public class JugadorEjbImpl implements JugadorEjbRemote {
	@Inject
	@Named("jugadorDAO")
	private IJugadorDao iDao;
	
	private List<Jugador> listaJugadores = new ArrayList<Jugador>();

	@Override
	public List<JugadorDTO> findAll() throws Exception {
		Stream<Jugador> jugadores = StreamSupport.stream(iDao.findAll().spliterator(), false) ;
		return jugadores.map(Jugador::toListaDTO).toList();
	}

	@Override
	public void insert(JugadorDTO dto) throws Exception {
		iDao.insert(Jugador.ofDTO(dto));
		
	}

	@Override
	public List<JugadorDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JugadorDTO getById(Long id) {
		// TODO Auto-generated method stub
		return iDao.findById(id).toDTO();
	}



	@Override
	public void actualizar(JugadorDTO obj) {
		// TODO Auto-generated method stub
		iDao.update(Jugador.ofDTO(obj));
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JugadorDTO getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JugadorDTO> findByNombre(String nombre, boolean isNull) throws Exception {
		Stream<Jugador> jugadores = StreamSupport.stream(iDao.findByNombre(nombre, isNull).spliterator(), false) ;
		return jugadores.map(Jugador::toListaBusqueda).toList();
	}

	@Override
	public List<JugadorDTO> findJugadoresSinEquipo() throws Exception {
		Stream<Jugador> jugadores = StreamSupport.stream(iDao.findJugadoresSinEquipo().spliterator(), false) ;
		return jugadores.map(Jugador::toListaDTO).toList();
	}





}
