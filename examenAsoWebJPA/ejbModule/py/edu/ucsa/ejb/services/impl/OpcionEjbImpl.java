package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IOpcionDao;
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.entities.Dominio;
import py.edu.ucsa.ejb.entities.Opcion;
import py.edu.ucsa.ejb.services.OpcionEjbRemote;

/**
 * Session Bean implementation class OpcionEjbImpl
 */
@Stateless(mappedName = "OpcionEjb")
@LocalBean
public class OpcionEjbImpl implements OpcionEjbRemote {

	@Inject
	@Named("opcionDAO")
	private IOpcionDao oDao;
    
    public OpcionEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Opcion getOpcionByDominioCodOpcion(String dominio, String codOpcion) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Iterable<Opcion> getOpcionesByIdDominio(Dominio dominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OpcionDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(OpcionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OpcionDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcionDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(OpcionDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
