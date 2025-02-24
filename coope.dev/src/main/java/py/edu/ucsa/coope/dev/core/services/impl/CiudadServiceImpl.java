package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.CiudadDao;
import py.edu.ucsa.coope.dev.core.entities.Ciudad;
import py.edu.ucsa.coope.dev.core.services.CiudadServices;
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

@Service("ciudadService")
@Transactional
public class CiudadServiceImpl implements CiudadServices{
	
	@Autowired
	CiudadDao ciudadDao;

	@Override
	public List<CiudadDto> listar() {
		// TODO Auto-generated method stub
		List<Ciudad> entities = ciudadDao.listar();
		return entities.stream().map(c->c.toDto()).toList();
	}

	@Override
	public PaginadoDto<CiudadDto> listar(int pagina, int tamanhoPagina, String ordenarPor, String orden,
			String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CiudadDto getById(Integer id) {
		return ciudadDao.getById(id).toDto();
	}

	@Override
	public CiudadDto persistir(CiudadDto entity) {
		// TODO Auto-generated method stub
		return ciudadDao.persistir(Ciudad.fromDto(entity)).toDto();
	}

	@Override
	public CiudadDto actualizar(CiudadDto entity) {
		// TODO Auto-generated method stub
		return this.ciudadDao.actualizar(Ciudad.fromDto(entity)).toDto();
	}

	@Override
	public void eliminar(CiudadDto entity) {
		
	}

	@Override
	public void eliminar(Integer id) {
		ciudadDao.eliminar(id);
		
	}

	@Override
	public List<CiudadDto> getCiudadesByDepartamento(Integer idDepartamento) {
		// TODO Auto-generated method stub
		return null;
	}

}
