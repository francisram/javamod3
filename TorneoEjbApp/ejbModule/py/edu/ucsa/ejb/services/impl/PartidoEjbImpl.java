package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import py.edu.ucsa.ejb.dao.IPartidoDao;
import py.edu.ucsa.ejb.dto.PartidoDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Jugador;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.services.PartidoEjbRemote;

/**
 * Session Bean implementation class PartidoEjbImpl
 */
@Stateless(mappedName = "partidoEJB")
@LocalBean
public class PartidoEjbImpl implements PartidoEjbRemote {
	
	@Inject
	private IPartidoDao iDao;

	@Override
	public List<PartidoDTO> findAll() throws Exception {
		Stream<Partido> partidos = StreamSupport.stream(iDao.findAll().spliterator(), false) ;
		return partidos.map(Partido::toDTO).toList();
	}

	@Override
	public void insert(PartidoDTO dto) throws Exception {
		// TODO Auto-generated method stub
		iDao.insert(Partido.ofDTO(dto));
	}

	@Override
	public List<PartidoDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartidoDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PartidoDTO insertar(PartidoDTO obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(PartidoDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	
  

}
