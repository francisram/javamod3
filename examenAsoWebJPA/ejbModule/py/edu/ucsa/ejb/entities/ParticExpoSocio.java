package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
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
@Table(name = "partic_expo_socios")
@NamedQuery(name = "ParticExpoSocio.findAll", query = "SELECT pe FROM ParticExpoSocio pe ORDER BY pe.id ASC")
public class ParticExpoSocio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socios_id" , nullable = true)
	private Socio socio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exposiciones_id" , nullable = true)
	private Exposicion exposicion;
	
	@Column(name = "cancelo_participacion", columnDefinition="boolean",  nullable = true)
	private boolean canceloParticipacion;
	
	@Column(name = "fecha_cancelacion", columnDefinition="TIMESTAMPS", nullable = true)
	private LocalDateTime fechaCancelacion;
	
	@Column(name = "fecha_creacion", columnDefinition="TIMESTAMPS", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private Usuario usuarioCreacion;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ParticExpoSocio [id=" + id + ", socio=" + socio + ", exposicion=" + exposicion
				+ ", canceloParticipacion=" + canceloParticipacion + ", fechaCancelacion=" + fechaCancelacion
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
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
	public Exposicion getExposicion() {
		return exposicion;
	}
	public void setExposicion(Exposicion exposicion) {
		this.exposicion = exposicion;
	}
	public boolean isCanceloParticipacion() {
		return canceloParticipacion;
	}
	public void setCanceloParticipacion(boolean canceloParticipacion) {
		this.canceloParticipacion = canceloParticipacion;
	}
	public LocalDateTime getFechaCancelacion() {
		return fechaCancelacion;
	}
	public void setFechaCancelacion(LocalDateTime fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
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
	public ParticExpoSocio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
