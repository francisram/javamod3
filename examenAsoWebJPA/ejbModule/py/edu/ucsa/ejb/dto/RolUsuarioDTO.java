package py.edu.ucsa.ejb.dto;

public class RolUsuarioDTO {
	private Integer idUsuario;
	private Integer idRol;
	private Integer id;
	
	
	
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RolUsuarioDTO [idUsuario=" + idUsuario + ", idRol=" + idRol + ", id=" + id + "]";
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	
	

}
