package py.edu.ucsa.ejb.services.impl;

import java.util.List;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import py.edu.ucsa.ejb.dao.IRolUsuarioDao;
import py.edu.ucsa.ejb.dto.RolUsuarioDTO;
import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.RolUsuario;
import py.edu.ucsa.ejb.entities.Usuario;
import py.edu.ucsa.ejb.services.RolUsuarioEjbRemote;

/**
 * Session Bean implementation class RolUsuarioEjbImpl
 */
@Stateless(mappedName = "rolUsuarioEjb")
@LocalBean
public class RolUsuarioEjbImpl implements RolUsuarioEjbRemote {
	
	@Inject
	@Named("rolUsuarioDao")
	private IRolUsuarioDao rdao;
    /**
     * Default constructor. 
     */
    public RolUsuarioEjbImpl() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<RolUsuarioDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(RolUsuarioDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RolUsuarioDTO> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolUsuarioDTO getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(RolUsuarioDTO obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterable<RolUsuario> getRolesByUsuario(Usuario idUsuario) {
		Iterable<RolUsuario> roles = rdao.getRolesByUsuario(idUsuario);
		return roles;
	}

	
	
}
