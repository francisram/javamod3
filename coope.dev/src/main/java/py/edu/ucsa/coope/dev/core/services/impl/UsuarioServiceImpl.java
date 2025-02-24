package py.edu.ucsa.coope.dev.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import py.edu.ucsa.coope.dev.core.dao.UsuarioDao;
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.core.services.UsuarioServices;
import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;
import py.edu.ucsa.coope.dev.web.dto.UsuarioDto;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto persistir(UsuarioDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDto actualizar(UsuarioDto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(UsuarioDto entity) {
		// TODO Auto-generated method stub
		
	}

}
