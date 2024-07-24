package py.edu.ucsa.ejb.dto;

import java.time.LocalDate;

public class ExposicionDTO {
	
	private Integer id;
	private String nombre;
	private String descripcion;
	private String organiza;
	private String ubicacion;
	private LocalDate fechaExpo;
	private String contacto;
	private LocalDate fechaCreacion;
	private UsuarioDTO usuarioCreacion;
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
	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	@Override
	public String toString() {
		return "ExposicionDTO [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", organiza=" + organiza
				+ ", ubicacion=" + ubicacion + ", fechaExpo=" + fechaExpo + ", contacto=" + contacto
				+ ", fechaCreacion=" + fechaCreacion + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
	
	
	

}
