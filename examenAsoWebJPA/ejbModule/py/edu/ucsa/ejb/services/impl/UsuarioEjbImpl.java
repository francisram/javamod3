package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IUsuarioDao;
import py.edu.ucsa.ejb.dto.UsuarioDTO;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.UsuarioEjbRemote;

/**
 * Session Bean implementation class UsuarioEjbImpl
 */
@Stateless(mappedName = "usuarioEjb")
@LocalBean
public class UsuarioEjbImpl implements UsuarioEjbRemote {
	
	@Inject
	@Named("usuarioDAO")
	private IUsuarioDao uDao;

    /**
     * Default constructor. 
     */
    public UsuarioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<UsuarioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UsuarioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UsuarioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UsuarioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<Rol> getRolesByUsuario(Integer idUsuario) {
		Iterable<Rol> roles = uDao.getRolesByUsuario(idUsuario);
		return roles;
	}

	@Override
	public Usuario validarUsuario(String username, String password) {
		// TODO Auto-generated method stub
		
		Usuario usuario = uDao.validarUsuario(username, password);
		
		return usuario;
	}
    
    

}
