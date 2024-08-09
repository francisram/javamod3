package py.edu.ucsa.ejb.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.RolDTO;

@Entity
@Table(name = "roles ")
@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r ORDER BY r.id ASC")
public class Rol implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_rol", nullable = true)
	private String nombreRol;
	
	
	public static Rol ofDTO(RolDTO dto) {
		Rol rol = new Rol();
		rol.setId(dto.getId());
		rol.setNombreRol(dto.getNombreRol());
		return rol;
		
	}
	
	public RolDTO toDTO() {
		RolDTO rol = new RolDTO();
		rol.setId(this.getId());
		rol.setNombreRol(this.getNombreRol());
		return rol;
	}
	
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
		return "Rol [id=" + id + ", nombreRol=" + nombreRol + "]";
	}
	
	
	

	
	

}
