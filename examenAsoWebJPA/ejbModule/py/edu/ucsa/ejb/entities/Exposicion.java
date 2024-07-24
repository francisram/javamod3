package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;

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
@Table(name = "exposiciones")
@NamedQuery(name = "Exposicion.findAll", query = "SELECT e FROM Exposicion e ORDER BY e.nombre ASC")
public class Exposicion {
	
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
	@Column(name = "fecha_expo", columnDefinition = "	TIMESTAMP", nullable = true)
	private LocalDate fechaExpo;
	@Column(name = "contacto", nullable = true)
	private String contacto;
	@Column(name = "fecha_creacion", columnDefinition = "	TIMESTAMP",nullable = true)
	private LocalDate fechaCreacion;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" )
	private Usuario usuarioCreacion;
	
	
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
