package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nombreRol;

		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	@Override
	public String toString() {
		return "RolDTO [id=" + id + ", nombreRol=" + nombreRol + "]";
	}
	
	
	

}
