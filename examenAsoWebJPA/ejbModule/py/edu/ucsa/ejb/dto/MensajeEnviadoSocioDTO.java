package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MensajeEnviadoSocioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private SocioDTO socioDestino;
	private MensajeEnviadoSocioDTO mensaje;
	private LocalDateTime fechaCreacion;
	private UsuarioDTO usuarioCreacion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SocioDTO getSocioDestino() {
		return socioDestino;
	}
	public void setSocioDestino(SocioDTO socioDestino) {
		this.socioDestino = socioDestino;
	}
	public MensajeEnviadoSocioDTO getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeEnviadoSocioDTO mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	@Override
	public String toString() {
		return "MensajeEnviadoSocioDTO [id=" + id + ", socioDestino=" + socioDestino + ", mensaje=" + mensaje
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	
	

}
