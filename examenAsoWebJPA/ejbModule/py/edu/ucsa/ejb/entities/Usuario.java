package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
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
import py.edu.ucsa.ejb.dto.SocioDTO;
import py.edu.ucsa.ejb.dto.UsuarioDTO;


@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.usuario ASC")
@NamedQuery(name = "Usuario.validarUsuario" , query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario and u.clave = :clave")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "usuario", nullable = true)
	private String usuario;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "clave", nullable = true)
	private String clave;
	@Column(name = "habilitado", columnDefinition = "boolean", nullable = true)
	private boolean habilitado;
	@Column(name = "cuenta_expirada", columnDefinition = "boolean", nullable = true)
	private boolean cuentaExpirada;
	@Column(name = "cuenta_bloqueada", columnDefinition = "boolean", nullable = true)
	private boolean cuentaBloqueada;
	@Column(name = "fecha_creacion_usuario", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaCreacionUsuario;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_socio" , nullable = true)
	private Socio idSocio;
	
	
	public static Usuario ofDTO(UsuarioDTO dto) {
		Usuario u = new Usuario();
		u.setClave(dto.getClave());
		u.setCuentaBloqueada(dto.isCuentaBloqueada());
		u.setCuentaExpirada(dto.isCuentaExpirada());
		u.setEmail(dto.getEmail());
		if(!Objects.isNull(dto.getFechaCreacionUsuario())) {
			u.setFechaCreacionUsuario(dto.getFechaCreacionUsuario());			
		}
		u.setHabilitado(dto.isHabilitado());
		u.setId(dto.getId());
		if(Objects.isNull(dto.getIdSocio())) {
			u.setIdSocio(Socio.ofDTO(dto.getIdSocio()));
		}

		u.setUsuario(dto.getUsuario());
		
		return u;
				
	}
	
	public UsuarioDTO toDTO() {
		
		UsuarioDTO u = new UsuarioDTO();
		u.setClave(this.clave);
		u.setCuentaBloqueada(this.isCuentaBloqueada());
		u.setCuentaExpirada(this.isCuentaExpirada());
		u.setEmail(this.email);
		if(!Objects.isNull(this.getFechaCreacionUsuario())) {
			u.setFechaCreacionUsuario(this.getFechaCreacionUsuario());
		}
		u.setHabilitado(this.isHabilitado());
		u.setId(this.id);
		SocioDTO s = new SocioDTO();
		s.setId(this.id);
		u.setIdSocio(s);
		u.setUsuario(usuario);
		
		return u;
		
	}
	
	public UsuarioDTO toListaDTO() {
		
		UsuarioDTO u = new UsuarioDTO();
		u.setClave(this.clave);
		u.setCuentaBloqueada(this.isCuentaBloqueada());
		u.setCuentaExpirada(this.isCuentaExpirada());
		u.setEmail(this.email);
		if(!Objects.isNull(u.getFechaCreacionUsuario())) {
			//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			u.setFechaCreacionUsuario(this.getFechaCreacionUsuario());
		}
		u.setHabilitado(this.isHabilitado());
		u.setId(this.id);
		SocioDTO s = new SocioDTO();
		s.setId(this.id);
		u.setIdSocio(s);
		u.setUsuario(usuario);
		
		return u;
		
	}
	
	
	public LocalDate getFechaCreacionUsuario() {
		return fechaCreacionUsuario;
	}
	public void setFechaCreacionUsuario(LocalDate fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public Socio getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(Socio idSocio) {
		this.idSocio = idSocio;
	}
	public boolean isCuentaExpirada() {
		return cuentaExpirada;
	}
	public void setCuentaExpirada(boolean cuentaExpirada) {
		this.cuentaExpirada = cuentaExpirada;
	}
	public boolean isCuentaBloqueada() {
		return cuentaBloqueada;
	}
	public void setCuentaBloqueada(boolean cuentaBloqueada) {
		this.cuentaBloqueada = cuentaBloqueada;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", email=" + email + ", clave=" + clave + ", habilitado="
				+ habilitado + ", cuentaExpirada=" + cuentaExpirada + ", cuentaBloqueada=" + cuentaBloqueada
				+ ", fechaCreacionUsuario=" + fechaCreacionUsuario + ", idSocio=" + idSocio + "]";
	}
	
	
	
}
