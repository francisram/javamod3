package py.edu.ucsa.ejb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r ORDER BY r.rol ASC")
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
