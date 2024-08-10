package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_socio", nullable = true)
	private Socio socio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_exposicion", nullable = true)
	private Exposicion exposicion;

	@Column(name = "cancelo_participacion", columnDefinition = "boolean", nullable = true)
	private boolean canceloParticipacion;

	@Column(name = "fecha_cancelacion", columnDefinition = "DATE", nullable = true)
	private LocalDateTime fechaCancelacion;

	@Column(name = "fecha_creacion", columnDefinition = "DATE", nullable = true)
	private LocalDateTime fechaCreacion;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_creacion", nullable = true)
	private Usuario usuarioCreacion;

	public static ParticExpoSocio ofDTO(ParticExpoSocioDTO dto) {
		ParticExpoSocio pes = new ParticExpoSocio();
		pes.setCanceloParticipacion(dto.isCanceloParticipacion());
		pes.setExposicion(Exposicion.ofDTO(dto.getExposicion()));
		if (!Objects.isNull(dto.getFechaCancelacion())) {
			pes.setFechaCancelacion(dto.getFechaCancelacion());
		}
		if (!Objects.isNull(dto.getFechaCreacion())) {
			pes.setFechaCreacion(dto.getFechaCreacion());
		}
		pes.setId(dto.getId());
		if (Objects.isNull(dto.getSocio())) {
			pes.setSocio(Socio.ofDTO(dto.getSocio()));
		}
		pes.setUsuarioCreacion(Usuario.ofDTO(dto.getUsuarioCreacion()));
		return pes;
	}

	public ParticExpoSocioDTO toDTO() {
		ParticExpoSocioDTO pes = new ParticExpoSocioDTO();
		pes.setCanceloParticipacion(this.isCanceloParticipacion());
		pes.setExposicion(this.getExposicion().toDTO());
		if (!Objects.isNull(this.getFechaCancelacion())) {
			pes.setFechaCancelacion(this.getFechaCancelacion());
		}
		if (!Objects.isNull(this.getFechaCreacion())) {
			pes.setFechaCreacion(this.getFechaCreacion());
		}
		pes.setId(this.getId());
		pes.setSocio(this.getSocio().toDTO());
		pes.setUsuarioCreacion(this.getUsuarioCreacion().toDTO());
		return pes;
	}

	@Override
	public String toString() {
		return "ParticExpoSocioDTO [id=" + id + ", " + "socio=" + (socio != null ? socio : null) + ", " + "exposicion="
				+ (exposicion != null ? exposicion : null) + ", canceloParticipacion=" + canceloParticipacion
				+ ", fechaCancelacion=" + fechaCancelacion + ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion="
				+ usuarioCreacion + "]";
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
