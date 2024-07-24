package py.edu.ucsa.ejb.dto;

import java.time.LocalDateTime;

public class CodigoDeSeguridadDTO {
	private Integer id;
	private String codigo;
	private LocalDateTime horaPeticion;
	private Integer tipoActivacion;
	private UsuarioDTO usuarioDTO;
	
	
	
	@Override
	public String toString() {
		return "CodigoDeSeguridadDTO [id=" + id + ", codigo=" + codigo + ", horaPeticion=" + horaPeticion
				+ ", tipoActivacion=" + tipoActivacion + ", usuarioDTO=" + usuarioDTO + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getHoraPeticion() {
		return horaPeticion;
	}
	public void setHoraPeticion(LocalDateTime horaPeticion) {
		this.horaPeticion = horaPeticion;
	}
	public Integer getTipoActivacion() {
		return tipoActivacion;
	}
	public void setTipoActivacion(Integer tipoActivacion) {
		this.tipoActivacion = tipoActivacion;
	}
	public UsuarioDTO getUsuario() {
		return usuarioDTO;
	}
	public void setUsuario(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
	

}
