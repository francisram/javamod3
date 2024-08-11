package py.edu.ucsa.ejb.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados_socios")
@NamedQuery(name = "EstadoSocio.findAll", query = "SELECT c FROM EstadoSocio c ORDER BY c.socio ASC")
public class EstadoSocio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_socio" , nullable = true)
	private Socio socio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado" )
	private Opcion estado;
	@Column(name = "fecha_estado",columnDefinition = "DATE", nullable = true)
	private LocalDateTime fechaEstado;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_creacion" )
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
	public Opcion getEstado() {
		return estado;
	}
	public void setEstado(Opcion estado) {
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
