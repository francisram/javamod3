package py.edu.ucsa.ejb.entities;

public class Rol {
	private Integer idUsuario;
	private Integer rol;
	
		
	@Override
	public String toString() {
		return "Rol [idUsuario=" + idUsuario + ", rol=" + rol + "]";
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getRol() {
		return rol;
	}
	public void setRol(Integer rol) {
		this.rol = rol;
	}
	
	

}
