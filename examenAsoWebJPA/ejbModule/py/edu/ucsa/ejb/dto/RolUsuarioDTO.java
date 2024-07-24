package py.edu.ucsa.ejb.dto;

public class RolUsuarioDTO {
	private Integer idUsuario;
	private Integer idRol;
	
		
	@Override
	public String toString() {
		return "RolUsuarioDTO [idUsuario=" + idUsuario + ", idRol=" + idRol + "]";
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
