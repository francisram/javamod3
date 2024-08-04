package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String usuario;
	private String email;
	private String clave;
	private boolean habilitado;
	private boolean cuentaExpirada;
	private boolean cuentaBloqueada;
	private LocalDate fechaCreacionUsuario;
	private SocioDTO idSocio;
	
	
	
	
	public LocalDate getFechaCreacionUsuario() {
		return fechaCreacionUsuario;
	}
	public void setFechaCreacionUsuario(LocalDate fechaCreacionUsuario) {
		this.fechaCreacionUsuario = fechaCreacionUsuario;
	}

	public SocioDTO getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(SocioDTO idSocio) {
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
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(Integer id) {
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
		return "UsuarioDTO [id=" + id + ", usuario=" + usuario + ", email=" + email + ", clave=" + clave + ", habilitado="
				+ habilitado + ", cuentaExpirada=" + cuentaExpirada + ", cuentaBloqueada=" + cuentaBloqueada
				+ ", fechaCreacionUsuario=" + fechaCreacionUsuario + ", idSocio=" + idSocio + "]";
	}
	
	
	
}
