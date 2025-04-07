package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.UsuarioDao;
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.core.services.UsuarioServices;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.PaginationDto;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioServices {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	public List<UsuarioDto> listar() {
		List<Usuario> entities = usuarioDao.listar();
		return entities.stream().map(e ->e.toDto()).toList();
	}

	@Override
	public PaginadoDto<UsuarioDto> listar(int pagina, int tamanhoPagina, String ordenarPor, String orden,
			String busqueda) {
		
		PaginadoDto<UsuarioDto> paginado = new PaginadoDto<>();
		PaginadoDto<Usuario> paginadoConEntities = usuarioDao.listar(tamanhoPagina, pagina, ordenarPor, orden, busqueda);
		
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
	public UsuarioDto getById(Integer id) {
		return usuarioDao.getById(id).toDto();
	}

	@Override
	public UsuarioDto persistir(UsuarioDto entity) {

		return usuarioDao.persistir(Usuario.fromDto(entity)).toDto();
	}

	@Override
	public UsuarioDto actualizar(UsuarioDto entity) {
		// TODO Auto-generated method stub
		return usuarioDao.actualizar(Usuario.fromDto(entity)).toDto();
	}

	@Override
	public void eliminar(UsuarioDto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		
		usuarioDao.eliminar(id);
		
	}

}
