package py.edu.ucsa.ejb.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ParticExpoSocioDTO {
	private Integer id;
	private SocioDTO socioDTO;
	private ExposicionDTO exposicionDTO;
	private boolean canceloParticipacion;
	private LocalDateTime fechaCancelacion;
	private LocalDateTime fechaCreacion;
	private UsuarioDTO usuarioCreacion;
	
	
	
	
	
	
	@Override
	public String toString() {
		return "ParticExpoSocioDTO [id=" + id + ", socioDTO=" + socioDTO + ", exposicionDTO=" + exposicionDTO
				+ ", canceloParticipacion=" + canceloParticipacion + ", fechaCancelacion=" + fechaCancelacion
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SocioDTO getSocio() {
		return socioDTO;
	}
	public void setSocio(SocioDTO socioDTO) {
		this.socioDTO = socioDTO;
	}
	public ExposicionDTO getExposicion() {
		return exposicionDTO;
	}
	public void setExposicion(ExposicionDTO exposicionDTO) {
		this.exposicionDTO = exposicionDTO;
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
	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public ParticExpoSocioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
