package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.DepartamentoDao;
import py.edu.ucsa.coope.dev.core.entities.Departamento;
import py.edu.ucsa.coope.dev.core.services.DepartamentoService;
import py.edu.ucsa.coope.dev.web.dto.DepartamentoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;

@Service("departamentoService")
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao departamentoDao;
	
	@Override
	public List<DepartamentoDto> listar() {
		List<Departamento> entities = departamentoDao.listar();
		
		return entities.stream().map(d ->d.toDto()).toList();
	}

	@Override
	public PaginadoDto<DepartamentoDto> listar(int pagina, int tamanhoPagina, String ordenarPor, String orden,
			String busqueda) {
		// TODO Auto-generated method stub
		
		PaginadoDto<DepartamentoDto> paginado = new PaginadoDto<>();
		PaginadoDto<Departamento> paginadoConEntities = departamentoDao.listar(tamanhoPagina, pagina, ordenarPor, orden, busqueda);
		
		if(Objects.nonNull(paginadoConEntities.getData()) && !paginadoConEntities.getData().isEmpty()) {
			paginado.setData(paginadoConEntities.getData().stream().map(d -> d.toDto()).toList());
			paginado.setPagination(paginadoConEntities.getPagination());
		}else {
			paginado.setData(new ArrayList<>());
			paginado.setPagination(new PaginationDto());
		}
		
		return paginado;
	}

	@Override
	public DepartamentoDto getById(Integer id) {
		// TODO Auto-generated method stub
		return departamentoDao.getById(id).toDto();
	}

	@Override
	public DepartamentoDto persistir(DepartamentoDto entity) {
		// TODO Auto-generated method stub
		return departamentoDao.persistir(Departamento.fromDto(entity)).toDto();
	}

	@Override
	public DepartamentoDto actualizar(DepartamentoDto entity) {
		// TODO Auto-generated method stub
		return departamentoDao.actualizar(Departamento.fromDto(entity)).toDto();
	}

	@Override
	public void eliminar(DepartamentoDto entity) {

		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		departamentoDao.eliminar(id);
	}

}
