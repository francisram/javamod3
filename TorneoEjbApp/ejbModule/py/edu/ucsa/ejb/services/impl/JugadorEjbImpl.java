package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.JugadorDTO;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.services.JugadorEjbRemote;

/**
 * Session Bean implementation class JugadorEjbImpl
 */
@Stateless
@LocalBean
public class JugadorEjbImpl implements JugadorEjbRemote {
	
	private List<Jugador> listaJugadores = new ArrayList<Jugador>();

	@Override
	public List<JugadorDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(JugadorDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JugadorDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JugadorDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JugadorDTO insertar(JugadorDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(JugadorDTO obj) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}





}
