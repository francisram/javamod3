package py.edu.ucsa.ejb.dto;

import java.time.LocalDateTime;

public class EstadoSocioDTO {
	private Integer id;
	private SocioDTO socioDTO;
	private EstadoSocioDTO estado;
	private LocalDateTime fechaEstado;
	private UsuarioDTO usuarioCreacion;
	private LocalDateTime fechaCreacion;
	private String observacion;
	
	
	
	
	@Override
	public String toString() {
		return "EstadoSocioDTO [id=" + id + ", socioDTO=" + socioDTO + ", estado=" + estado + ", fechaEstado=" + fechaEstado
				+ ", usuarioCreacion=" + usuarioCreacion + ", fechaCreacion=" + fechaCreacion + ", observacion="
				+ observacion + "]";
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
	public EstadoSocioDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoSocioDTO estado) {
		this.estado = estado;
	}
	public LocalDateTime getFechaEstado() {
		return fechaEstado;
	}
	public void setFechaEstado(LocalDateTime fechaEstado) {
		this.fechaEstado = fechaEstado;
	}
	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
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