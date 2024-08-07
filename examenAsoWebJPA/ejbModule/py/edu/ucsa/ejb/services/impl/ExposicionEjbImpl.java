package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import py.edu.ucsa.ejb.dao.IExposicionDao;
import py.edu.ucsa.ejb.dto.ExposicionDTO;
import py.edu.ucsa.ejb.services.ExposicionEjbRemote;

/**
 * Session Bean implementation class ExposicionEjbImpl
 */
@Stateless(mappedName = "ExposicionEjb")
@LocalBean
public class ExposicionEjbImpl implements ExposicionEjbRemote {
	
	private IExposicionDao eDao;

    /**
     * Default constructor. 
     */
    public ExposicionEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<ExposicionDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(ExposicionDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ExposicionDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExposicionDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(ExposicionDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<ExposicionDTO> listarPorFechas(String fechaInicial, String fechaFinal) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
