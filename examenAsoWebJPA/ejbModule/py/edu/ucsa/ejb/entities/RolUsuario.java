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
import py.edu.ucsa.ejb.dto.RolUsuarioDTO;

@Entity
@Table(name = "roles_usuarios")
@NamedQuery(name = "RolUsuario.findAll", query = "SELECT r FROM RolUsuario r ORDER BY r.idRol ASC")
@NamedQuery(name = "RolUsuario.getRolesByUsuario" , query = "SELECT r FROM RolUsuario r WHERE r.idUsuario = :usuario")
public class RolUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id" , nullable = true)
	private Usuario idUsuario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id" , nullable = true)
	private Rol idRol;
	
	
	public static RolUsuario ofDTO(RolUsuarioDTO dto) {
		
		RolUsuario rolUsuario = new RolUsuario();
		rolUsuario.setId(dto.getId());
		rolUsuario.setIdRol(Rol.ofDTO(dto.getIdRol()));
		rolUsuario.setIdUsuario(Usuario.ofDTO(dto.getIdUsuario()));
		return rolUsuario;
		
	}
	
	public RolUsuarioDTO toDTO() {
		RolUsuarioDTO rolUsuario = new RolUsuarioDTO();
		rolUsuario.setId(this.getId());
		rolUsuario.setIdRol(this.getIdRol().toDTO());
		rolUsuario.setIdUsuario(this.getIdUsuario().toDTO());
		return rolUsuario;
		
	}
	
	
	
		
	@Override
	public String toString() {
		return "RolUsuarioDTO [idUsuario=" + idUsuario + ", idRol=" + idRol + "]";
	}
	


	public Usuario getIdUsuario() {
		return idUsuario;
	}



	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	
	
	

}
