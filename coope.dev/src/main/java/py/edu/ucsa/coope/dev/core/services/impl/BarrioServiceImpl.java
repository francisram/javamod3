package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.BarrioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.core.services.BarrioServices;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;


@Service("barrioService")
@Transactional
public class BarrioServiceImpl implements BarrioServices {
	
	@Autowired
	private BarrioDao barrioDao;

	@Override
	public List<Barrio> listar() {
		// TODO Auto-generated method stub
		return barrioDao.listar();
	}

	@Override
	public PaginadoDto<Barrio> listar(int pagina, int tamanhoPagina, String ordenarPor, String orden, String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Barrio getById(Integer id) {
		// TODO Auto-generated method stub
		return barrioDao.getById(id);
	}

	@Override
	public Barrio persistir(Barrio entity) {
		// TODO Auto-generated method stub
		return barrioDao.persistir(entity);
	}

	@Override
	public Barrio actualizar(Barrio entity) {
		// TODO Auto-generated method stub
		return barrioDao.actualizar(entity);
	}

	@Override
	public void eliminar(Barrio entity) {
		barrioDao.eliminar(entity);
		
	}

	@Override
	public List<Barrio> castEntitiesListToDoList(List<Barrio> res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Barrio> getBarriosByIdCiudad(Integer idCiudad) {
		// TODO Auto-generated method stub
		return barrioDao.getBarriosByIdCiudad(idCiudad);
	}

}
