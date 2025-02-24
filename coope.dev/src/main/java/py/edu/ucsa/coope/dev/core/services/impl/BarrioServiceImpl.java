package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.BarrioDao;
import py.edu.ucsa.coope.dev.core.entities.Barrio;
import py.edu.ucsa.coope.dev.core.services.BarrioServices;
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;


@Service("barrioService")
@Transactional
public class BarrioServiceImpl implements BarrioServices {
	
	@Autowired
	private BarrioDao barrioDao;

	@Override
	public List<BarrioDto> listar() {
		List<Barrio> entities = barrioDao.listar();
		return entities.stream().map(b -> b.toDto()).toList();
	}

	@Override
	public PaginadoDto<BarrioDto> listar(int pagina, int tamanhoPagina, String ordenarPor, String orden, String busqueda) {
		
		PaginadoDto<BarrioDto> paginado = new PaginadoDto<>();
		PaginadoDto<Barrio> paginadoConEntities = barrioDao.listar(tamanhoPagina, pagina, ordenarPor, orden, busqueda);
		
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
	public BarrioDto getById(Integer id) {
		Barrio b = barrioDao.getById(id);
		return b != null ? b.toDto(): null;
	}

	@Override
	public BarrioDto persistir(BarrioDto dto) {
		return barrioDao.persistir(Barrio.fromDto(dto)).toDto();
	}

	@Override
	public BarrioDto actualizar(BarrioDto dto) {
		return barrioDao.actualizar(Barrio.fromDto(dto)).toDto();
	}

	@Override
	public void eliminar(BarrioDto dto) {
		barrioDao.eliminar(Barrio.fromDto(dto));
		
	}


	@Override
	public List<BarrioDto> getBarriosByIdCiudad(Integer idCiudad) {
		
		return barrioDao.getBarriosByIdCiudad(idCiudad).stream().map(b -> b.toDto()).toList();
	}

	@Override
	public void eliminar(Integer id) {
		//barrioDao.eliminar(Barrio.fromDto(barrio));
		barrioDao.eliminar(id);
		
	}




}
