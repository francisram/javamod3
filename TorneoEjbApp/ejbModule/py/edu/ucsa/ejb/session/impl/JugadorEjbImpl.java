package py.edu.ucsa.ejb.session.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.session.JugadorEjbRemote;

/**
 * Session Bean implementation class JugadorEjbImpl
 */
@Stateless
@LocalBean
public class JugadorEjbImpl implements JugadorEjbRemote {
	
	private List<Jugador> listaJugadores = new ArrayList<Jugador>();

	@Override
	public List<Jugador> listar() {
		
		return listaJugadores;
	}

	@Override
	public Jugador getById(Integer id) {
		Jugador jugador = new Jugador();
		for (Jugador j : listaJugadores) {
			if(j.getId() == id) {
				jugador = j;
				break;
			}
		}
		return jugador;
	}

	@Override
	public Jugador insertar(Jugador obj) {
		Jugador jug = new Jugador();
		if(!Objects.isNull(obj)) {
			Jugador j = getById(obj.getId());
			if(j.getId() == 0) {
				listaJugadores.add(obj);
			}
		}
		return jug;
	}

	@Override
	public void actualizar(Jugador obj) {
		if(!Objects.isNull(obj)) {
			for (int i = 0; i < listaJugadores.size(); i++) {
				if(listaJugadores.get(i).getId() == obj.getId()) {
					listaJugadores.set(i, obj);					
				}
			}
		}
		
	}

	@Override
	public void eliminar(Integer id) {
		if(!Objects.isNull(id)) {
			for (int i = 0; i < listaJugadores.size(); i++) {
				if(listaJugadores.get(i).getId() == id) {
					listaJugadores.remove(i);					
				}
			}
		}
		
	}

	@Override
	public Jugador getByNombre(String nombre) {
		Jugador j = new Jugador();
		if(!Objects.isNull(nombre)) {
			for (int i = 0; i < listaJugadores.size(); i++) {
				if(listaJugadores.get(i).getNombres() == nombre) {
					j = listaJugadores.get(i);					
				}
			}
		}
		return j;
	}



}
