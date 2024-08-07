package py.edu.ucsa.ejb.services.impl;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IExposicionDao;
import py.edu.ucsa.ejb.dto.ExposicionDTO;
import py.edu.ucsa.ejb.entities.Exposicion;
import py.edu.ucsa.ejb.services.ExposicionEjbRemote;

/**
 * Session Bean implementation class ExposicionEjbImpl
 */
@Stateless(mappedName = "ExposicionEjb")
@LocalBean
public class ExposicionEjbImpl implements ExposicionEjbRemote {
	
	@Inject
	@Named("exposicionDao")
	private IExposicionDao eDao;

    /**
     * Default constructor. 
     */
    public ExposicionEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<ExposicionDTO> findAll() throws Exception {
		Stream<Exposicion> exposiciones = StreamSupport.stream(eDao.findAll().spliterator(), false);
		return exposiciones.map(Exposicion::toDTO).toList();
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
		Stream<Exposicion> exposiciones = StreamSupport.stream(eDao.listarPorFechas(fechaInicial, fechaFinal).spliterator(), false);
		return exposiciones.map(Exposicion::toDTO).toList();
	}

}
