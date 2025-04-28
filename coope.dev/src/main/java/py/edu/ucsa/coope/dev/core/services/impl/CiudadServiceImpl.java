package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.CiudadDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.core.entities.Ciudad;
import py.edu.ucsa.coope.dev.core.services.CiudadService;
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;

@Service("ciudadService")
@Transactional
public class CiudadServiceImpl implements CiudadService{
	
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
		PaginadoDto<CiudadDto> paginado = new PaginadoDto<>();
		PaginadoDto<Ciudad> paginadoConEntities = ciudadDao.listar(tamanhoPagina, pagina, ordenarPor, orden, busqueda);
		
		if(Objects.nonNull(paginadoConEntities.getData()) && !paginadoConEntities.getData().isEmpty()) {
			paginado.setData(paginadoConEntities.getData().stream().map(b -> b.toDto()).toList());
			paginado.setPagination(paginadoConEntities.getPagination());
		}else {
			paginado.setPagination(new PaginationDto());
			paginado.setData(new ArrayList<>());
		}
		
		
		return paginado;
	}

	@Override
	public CiudadDto getById(Integer id) {
		Ciudad b = ciudadDao.getById(id);
		return b != null ? b.toDto(): null;
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
		ciudadDao.eliminar(Ciudad.fromDto(entity));
	}

	@Override
	public void eliminar(Integer id) {
		ciudadDao.eliminar(id);
		
	}

	@Override
	public List<CiudadDto> getCiudadesByDepartamento(Integer idDepartamento) {
		// TODO Auto-generated method stub
		return ciudadDao.getCiudadesByDepartamento(idDepartamento).stream().map(b -> b.toDto()).toList();
	}

}
