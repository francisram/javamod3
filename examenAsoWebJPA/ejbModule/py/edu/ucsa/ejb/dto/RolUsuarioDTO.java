package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

import py.edu.ucsa.ejb.entities.Rol;
import py.edu.ucsa.ejb.entities.Usuario;

public class RolUsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario idUsuario;
	private Rol idRol;
	private Long id;
	
			

		

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	@Override
	public String toString() {
		return "RolUsuarioDTO [idUsuario=" + idUsuario + ", idRol=" + idRol + ", id=" + id + "]";
	}
	


	
	

}
