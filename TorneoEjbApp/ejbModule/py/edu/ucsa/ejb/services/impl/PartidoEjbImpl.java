package py.edu.ucsa.ejb.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dto.PartidoDTO;
import py.edu.ucsa.ejb.entities.Equipo;
import py.edu.ucsa.ejb.entities.Partido;
import py.edu.ucsa.ejb.services.PartidoEjbRemote;

/**
 * Session Bean implementation class PartidoEjbImpl
 */
@Stateless
@LocalBean
public class PartidoEjbImpl implements PartidoEjbRemote {
	
	private List<Partido> listaPartidos = new ArrayList<Partido>();

	@Override
	public List<PartidoDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(PartidoDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
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
