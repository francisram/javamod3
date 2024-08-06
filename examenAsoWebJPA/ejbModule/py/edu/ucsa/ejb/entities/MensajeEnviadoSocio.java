package py.edu.ucsa.ejb.entities;

import java.time.LocalDateTime;

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

@Entity
@Table(name = "mensajes_enviados_socios")
@NamedQuery(name = "MensajeEnviadoSocio.findAll", query = "SELECT m FROM MensajeEnviadoSocio m ORDER BY m.socioDestino ASC")
public class MensajeEnviadoSocio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socio_destino_id" )
	private Socio socioDestino;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mensajes_socio_id" )
	private MensajeEnviadoSocio mensaje;
	
	@Column(name = "fecha_creacion", columnDefinition = "DATE",nullable = true)
	private LocalDateTime fechaCreacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_creacion_id" )
	private Usuario usuarioCreacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Socio getSocioDestino() {
		return socioDestino;
	}
	public void setSocioDestino(Socio socioDestino) {
		this.socioDestino = socioDestino;
	}
	public MensajeEnviadoSocio getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeEnviadoSocio mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	@Override
	public String toString() {
		return "MensajeEnviadoSocioDTO [id=" + id + ", socioDestino=" + socioDestino + ", mensaje=" + mensaje
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	
	

}
