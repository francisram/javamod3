package py.edu.ucsa.ejb.dao;

import java.util.List;

import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.RolUsuario;
import py.edu.ucsa.ejb.entities.Usuario;



public interface IRolUsuarioDao extends IGenericDao<Long, RolUsuario>{

	Iterable<Rol> getRolesByUsuario(Usuario idUsuario);

}
