package py.edu.ucsa.ejb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles_usuarios")
@NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r ORDER BY r.idRol ASC")
public class RolUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id" , nullable = true)
	private Integer idUsuario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id" , nullable = true)
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
