package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import py.edu.ucsa.ejb.entities.Opcion;

public class EstadoSocioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private SocioDTO socio;
	private OpcionDTO estado;
	private LocalDateTime fechaEstado;
	private UsuarioDTO usuarioCreacion;
	private LocalDateTime fechaCreacion;
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
	public SocioDTO getSocio() {
		return socio;
	}
	public void setSocio(SocioDTO socioDTO) {
		this.socio = socioDTO;
	}

	
	public OpcionDTO getEstado() {
		return estado;
	}
	public void setEstado(OpcionDTO estado) {
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
