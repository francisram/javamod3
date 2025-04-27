package py.edu.ucsa.coope.dev.web.security.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.core.entities.BaseDataCopier;
import py.edu.ucsa.coope.dev.core.entities.BaseEntity;
import py.edu.ucsa.coope.dev.core.entities.Opcion;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;
import py.edu.ucsa.coope.dev.web.security.Rol;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_usuarios", schema = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
//@NamedQuery(name = "Usuario.getUsuarioByUserName", query = "")
public class Usuario implements Serializable, BaseEntity, UserDetails {

	private static final long serialVersionUID = 46167056262484645L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_hora_creacion")
	private Timestamp fechaAlta;

	@Column(name = "fecha_hora_ult_modif")
	private Timestamp fechaHoraUltModif;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creacion")
	@JsonBackReference
	private Usuario usuarioCreacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_ult_modif")
	@JsonBackReference
	private Usuario usuarioUltModif;
	

	@ManyToOne(targetEntity = Opcion.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	private Opcion estado;

	//private String estado; //I:INACTIVO, A:ACTIVO, S:SUSPENDIDO, C:CANCELADO
	@Column(name="cuenta_expirada")
	private boolean cuentaExpirada;
	
	@Column(name="cuenta_bloqueada")
	private boolean cuentaBloqueada;
	
	@Column(name="credenciales_expiradas")
	private boolean credencialesExpiradas;
	
	@Column(name="cuenta_activa")
	private boolean cuentaActiva;

	private String email;
	private String nombres;
	private String apellidos;
	private String usuario;
	private String password;
	private String avatar;
	private String status;
	
	@Enumerated(EnumType.STRING)
	private Rol rol;
//	@JsonBackReference
//	@OneToMany(mappedBy = "usuario")
//	private List<PerfilXUsuario> perfiles;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Token> tokens;

	public UsuarioDto toDto() {// public OpcionDTO fromOpcionToDTO() {
		UsuarioDto dto = new UsuarioDto();
		BeanUtils.copyProperties(this, dto);
		dto.setId(this.getId());
		if (this.getEstado() != null) {
			dto.setEstado(this.getEstado().toDto());
		}
		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}

	public static Usuario fromDto(UsuarioDto dto) {// public static Opcion fromDTO(OpcionDTO dto)
		Usuario entity = new Usuario();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getEstado() != null) {
			entity.setEstado(Opcion.fromDto(dto.getEstado()));
		}

		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		return entity;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
/*		List<SimpleGrantedAuthority> authorities = new ArrayList<>();/*getPerfiles()
	            .stream()
	            .map(perfil -> new SimpleGrantedAuthority("PERFIL_" + perfil.getPerfil().getCodigo()))
	            .collect(Collectors.toList());*/
	    /*authorities.add(new SimpleGrantedAuthority("PERFIL_ADMIN"));
	    return authorities;*/
//		return rol.getAuthorities();
	    
	    return rol.getAuthorities();
	}

	@Override
	public String getUsername() {
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !cuentaExpirada;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !cuentaBloqueada;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credencialesExpiradas;
	}

	@Override
	public boolean isEnabled() {
		return cuentaActiva;
	}

	@Override
	public Timestamp getFechaAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaAlta(Timestamp fechaAlta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Timestamp getFechaModificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaModificacion(Timestamp fechaModificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuarioAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsuarioAlta(Usuario usuarioAlta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuarioModificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
}