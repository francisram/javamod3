package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import py.edu.ucsa.ejb.dao.IEquipoDao;
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
	@Named("equipoDao")
	private IEquipoDao eDao;
	
	@Inject
	@Named("jugadorDao")
	private IEquipoDao jDao;
	
	private List<EquipoDTO> listaEquipos = new ArrayList<>();

	@Override
	public List<EquipoDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(EquipoDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EquipoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EquipoDTO insertar(EquipoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(EquipoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EquipoDTO getByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EquipoDTO> findByNombre(String nombre, boolean isNull) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}











	
	

}
