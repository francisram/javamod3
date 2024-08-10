package py.edu.ucsa.ejb.entities;


import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.ParticExpoSocioDTO;

@Entity
@Table(name = "partic_expo_socios")
@NamedQuery(name = "ParticExpoSocio.findAll", query = "SELECT pe FROM ParticExpoSocio pe ORDER BY pe.id ASC")
@NamedQuery(name = "ParticExpoSocio.obtenerParticipacionesPorSocio", query = "SELECT pe FROM ParticExpoSocio pe JOIN pe.socio s JOIN pe.exposicion e JOIN pe.usuarioCreacion u  WHERE Pe.socio = :socio ")
@NamedQuery(name = "ParticExpoSocio.ObtenerParticipacion", query = "SELECT pe FROM ParticExpoSocio pe JOIN pe.socio s JOIN pe.exposicion e JOIN pe.usuarioCreacion u  WHERE Pe.socio = :socio AND pe.exposicion = :exposicion ")
public class ParticExpoSocio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_socio" , nullable = true)
	private Socio socio;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_exposicion" , nullable = true)
	private Exposicion exposicion;
	
	@Column(name = "cancelo_participacion", columnDefinition="boolean",  nullable = true)
	private boolean canceloParticipacion;
	
	@Column(name = "fecha_cancelacion", columnDefinition="DATE", nullable = true)
	private LocalDateTime fechaCancelacion;
	
	@Column(name = "fecha_creacion", columnDefinition="DATE", nullable = true)
	private LocalDateTime fechaCreacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creacion" , nullable = true)
	private Usuario usuarioCreacion;
	
	
	public static ParticExpoSocio ofDTO(ParticExpoSocioDTO dto) {
		ParticExpoSocio particExpoSocio = new ParticExpoSocio();
		
		return particExpoSocio;
	}

	public ParticExpoSocioDTO toDTO() {
		ParticExpoSocioDTO partic = new ParticExpoSocioDTO();
		
		return partic;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ParticExpoSocioDTO [id=" + id + ", socio=" + socio + ", exposicion=" + exposicion
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
