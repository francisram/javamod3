package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.ExposicionDTO;

@Entity
@Table(name = "exposiciones")
@NamedQuery(name = "Exposicion.findAll", query = "SELECT e FROM Exposicion e ORDER BY e.nombre ASC")
@NamedQuery(name = "Exposicion.listarPorFechas" , query = "SELECT e FROM Exposicion  e "
		+ "	JOIN e.usuarioCreacion u WHERE e.fechaExpo BETWEEN :fechaInicio and :fechaFin" )

public class Exposicion implements Serializable {
	

	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nombre", nullable = true)
	private String nombre;
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	@Column(name = "organiza", nullable = true)
	private String organiza;
	@Column(name = "ubicacion", nullable = true)
	private String ubicacion;
	@Column(name = "fecha_expo", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaExpo;
	@Column(name = "contacto", nullable = true)
	private String contacto;
	@Column(name = "fecha_creacion", columnDefinition = "DATE",nullable = true)
	private LocalDate fechaCreacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_creacion" )
	private Usuario usuarioCreacion;
	
	public static Exposicion ofDTO(ExposicionDTO dto) {
			Exposicion exposicion = new Exposicion();
			exposicion.setContacto(dto.getContacto());
			exposicion.setDescripcion(dto.getDescripcion());
			exposicion.setFechaCreacion(dto.getFechaCreacion());
			exposicion.setFechaExpo(dto.getFechaExpo());
			exposicion.setId(dto.getId());
			exposicion.setNombre(dto.getNombre());
			exposicion.setOrganiza(dto.getOrganiza());
			exposicion.setUbicacion(dto.getUbicacion());
			exposicion.setUbicacion(dto.getUbicacion());
			exposicion.setUsuarioCreacion(Usuario.ofDTO(dto.getUsuarioCreacion()));
			return exposicion;
	}
	
	
	public ExposicionDTO toDTO() {
		ExposicionDTO exposicion = new ExposicionDTO();
		exposicion.setContacto(this.getContacto());
		exposicion.setDescripcion(this.getDescripcion());
		exposicion.setFechaCreacion(this.getFechaCreacion());
		exposicion.setFechaExpo(this.getFechaExpo());
		exposicion.setId(this.getId());
		exposicion.setNombre(this.getNombre());
		exposicion.setOrganiza(this.getOrganiza());
		exposicion.setUbicacion(this.getUbicacion());
		exposicion.setUbicacion(this.getUbicacion());
		exposicion.setUsuarioCreacion(this.getUsuarioCreacion().toDTO());
		return exposicion;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getOrganiza() {
		return organiza;
	}
	public void setOrganiza(String organiza) {
		this.organiza = organiza;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public LocalDate getFechaExpo() {
		return fechaExpo;
	}
	public void setFechaExpo(LocalDate fechaExpo) {
		this.fechaExpo = fechaExpo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	
	@Override
	public String toString() {
		return "Exposicion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", organiza=" + organiza
				+ ", ubicacion=" + ubicacion + ", fechaExpo=" + fechaExpo + ", contacto=" + contacto
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	
	
	

}
