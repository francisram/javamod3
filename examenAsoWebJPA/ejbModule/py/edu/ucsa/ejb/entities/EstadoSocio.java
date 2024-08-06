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
@Table(name = "estados_socios")
@NamedQuery(name = "EstadoSocio.findAll", query = "SELECT c FROM EstadoSocio c ORDER BY c.socio ASC")
public class EstadoSocio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socio_id" , nullable = true)
	private Socio socio;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estado_id" )
	private EstadoSocio estado;
	@Column(name = "fecha_estado",columnDefinition = "DATE", nullable = true)
	private LocalDateTime fechaEstado;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_creacion_id" )
	private Usuario usuarioCreacion;
	@Column(name = "fecha_creacion", columnDefinition = "DATE", nullable = true)
	private LocalDateTime fechaCreacion;
	@Column(name = "observacion", nullable = true)
	private String observacion;
	
	
	
	
	@Override
	public String toString() {
		return "EstadoSocioDTO [id=" + id + ", socio=" + socio + ", estado=" + estado + ", fechaEstado=" + fechaEstado
				+ ", usuarioCreacion=" + usuarioCreacion + ", fechaCreacion=" + fechaCreacion + ", observacion="
				+ observacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public EstadoSocio getEstado() {
		return estado;
	}
	public void setEstado(EstadoSocio estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaEstado() {
		return fechaEstado;
	}
	public void setFechaEstado(LocalDateTime fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	
}
