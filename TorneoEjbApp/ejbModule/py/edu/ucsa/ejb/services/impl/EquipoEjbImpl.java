package py.edu.ucsa.ejb.services.impl;


import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import py.edu.ucsa.ejb.dao.IEquipoDao;
import py.edu.ucsa.ejb.dao.IJugadorDao;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.services.EquipoEjbRemote;


/**
 * Session Bean implementation class EquipoEjbImpl
 */
@Stateless(mappedName = "equipoEJB")
@Transactional
public class EquipoEjbImpl implements EquipoEjbRemote {
	
	@Inject
	@Named("equipoDAO")
	private IEquipoDao eDao;
	
	@Inject
	@Named("jugadorDAO")
	private IJugadorDao jDao;
	

	@Override
	public List<EquipoDTO> findAll() throws Exception {
		Stream<Equipo> equipos = StreamSupport.stream(eDao.findAll().spliterator(), false) ;
		return equipos.map(Equipo::toListaDTO).toList();
	}

	@Override
	public void insert(EquipoDTO dto) throws Exception {
		if(dto.getJugadores().size() > 20) {
			throw new Exception("nose permite mas de 20 jugadores");
		}
		
		Equipo equipo = Equipo.ofDTO(dto);
		//System.out.println("se registra equipo");
		equipo = eDao.insert(equipo);
		List<Jugador> jugadores = equipo.getJugadores();
		System.out.println("lista de jugadores a asignar");
		//jugadores.forEach((x)->System.out.println(x));
		
		for (Jugador jugador : jugadores) {
			//Jugador eJugador;
			Jugador j = jDao.findById(jugador.getId());
			//eJugador = jDao.findById(jugador.getId());
			if(Objects.isNull(j)) {
				System.out.println("no se encontro al jugador");
			}else {
				System.out.println("jugador encontrado" + j.toString());
			}
			j.setEquipo(equipo);
			jDao.update(j);
		}
		
	}

	@Override
	public List<EquipoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return eDao.findById(id).toDTO();
	}


	@Override
	public void actualizar(EquipoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		Equipo e = eDao.findById(id);
		
		System.out.println("lista de jugadores a liberar");
		
		Iterable<Jugador> jugadores = jDao.findJugadoresPorEquipo(e);
		
		for (Jugador jugador : jugadores) {

			jugador.setEquipo(null);
			jDao.update(jugador);
		}


		eDao.deleteById(id);  
		
	}

	@Override
	public EquipoDTO getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipoDTO> findByNombre(String nombre, boolean isNull) throws Exception {
		Stream<Equipo> equipos = StreamSupport.stream(eDao.findAllByNombre(nombre,isNull).spliterator(), false) ;
		return equipos.map(Equipo::toListaDTO).toList();
	}















	
	

}
