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
import py.edu.ucsa.ejb.dto.CodigoDeSeguridadDTO;
import py.edu.ucsa.ejb.dto.UsuarioDTO;

@Entity
@Table(name = "codigo_de_seguridad")
@NamedQuery(name = "CodigoDeSeguridad.findAll", query = "SELECT c FROM CodigoDeSeguridad c ORDER BY c.codigo ASC")
public class CodigoDeSeguridad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "codigo" , nullable = true, unique = true)
	private String codigo;
	@Column(name = "hora_peticion", columnDefinition = "	TIMESTAMP", nullable = true)
	private LocalDateTime horaPeticion;
	@Column(name = "tipo_activacion", columnDefinition = "	TIMESTAMP", nullable = true)
	private Integer tipoActivacion;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id" , nullable = true)
	private Usuario usuario;
	
		
	
	public static CodigoDeSeguridad ofDTO(CodigoDeSeguridadDTO dto) {
		CodigoDeSeguridad cds= new CodigoDeSeguridad();
		cds.setCodigo(dto.getCodigo());
		cds.setId(dto.getId());
		cds.setHoraPeticion(dto.getHoraPeticion());
		cds.setTipoActivacion(dto.getTipoActivacion());
		cds.setUsuario(Usuario.ofDTO(dto.getUsuario()));
		
		return cds;
		
	}
	/*
	
	public CodigoDeSeguridadDTO toListaDTO() {
		
	}
	
	public CodigoDeSeguridadDTO toDTO() {
		
	}
	*/

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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "CodigoDeSeguridadDTO [id=" + id + ", codigo=" + codigo + ", horaPeticion=" + horaPeticion
				+ ", tipoActivacion=" + tipoActivacion + ", usuario=" + usuario + "]";
	}

}
