package py.edu.ucsa.ejb.session.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import py.edu.ucsa.ejb.dao.IEquipoDao;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.session.EquipoEjbRemote;

/**
 * Session Bean implementation class EquipoEjbImpl
 */
@Stateless(mappedName = "equipoEJB")
@Transactional
public class EquipoEjbImpl implements EquipoEjbRemote {
	
	@Inject
	@Named("equipoDao")
	private IEquipoDao eDao;
	
	@Inject
	@Named("jugadorDao")
	private IEquipoDao jDao;
	
	private List<Equipo> listaEquipos = new ArrayList<>();

	@Override
	public List<Equipo> listar() {
		return listaEquipos;
	}



	@Override
	public Equipo insertar(Equipo obj) {
		Equipo e = new Equipo();
		if (!Objects.isNull(obj)) {
			Equipo eq = getById(obj.getId());
			if (eq.getId() == 0) {
				listaEquipos.add(obj);
				e = obj;
			}
		}
		return e;
	}

	@Override
	public void actualizar(Equipo obj) {
		if (!Objects.isNull(obj)) {
			for (int i = 0 ; i <listaEquipos.size(); i++) {
				if(listaEquipos.get(i).getId() == obj.getId()) {
					listaEquipos.set(i, obj);
					break;
				}
			}
		}
		
	}

	@Override
	public void eliminar(Long id) {
		if (!Objects.isNull(id)) {
			for (int i = 0 ; i <listaEquipos.size(); i++) {
				if(listaEquipos.get(i).getId() == id) {
					listaEquipos.remove(i);
					break;
				}
			}
		}
		
	}

	@Override
	public Equipo getByNombre(String nombre) {
		Equipo e = new Equipo();
		if (nombre != null) {
			for (Equipo equipo : listaEquipos) {
				if (equipo.getNombre() == nombre) {
					e = equipo;
					break;
				}
			}
		}
		return e;
	}



	@Override
	public Equipo getById(Long id) {
		Equipo e = new Equipo();
		if (id != null) {
			for (Equipo equipo : listaEquipos) {
				if (id.equals(equipo.getId())) {
					e = equipo;
					break;
				}
			}
		}
		return e;
	}



	@Override
	public List<Equipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		Stream<Equipo> equipos = StreamSupport.stream(eDao.findAll().spliterator(), false);
		return equipos.map().toList();
	}



	@Override
	public void insert(Equipo dto) throws Exception {
		// TODO Auto-generated method stub
		if(dto.getJugadores().size()>20) {
			throw new Exception("no se permite mas de 20 jugadores");
		}
		//se guarda el equipo
		Equipo equipo = new Equipo.ofDTO();
		equipo = eDao.insert(equipo);
		
		//se guarda a los jugadores
		Jugador eJugador;
		for(Jugador j: equipo.getJugadores()) {
			eJugador = jDao.findById(j.getId());
			eJugador.setEquipo(equipo);
			jDao.update(eJugador);
		}
	}


	
	

}
