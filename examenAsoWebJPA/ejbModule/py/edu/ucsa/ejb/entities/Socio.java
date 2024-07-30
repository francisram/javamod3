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
import py.edu.ucsa.ejb.dto.SocioDTO;

@Entity
@Table(name = "socios")
@NamedQuery(name = "Socio.findAll", query = "SELECT s FROM Socio s ORDER BY s.nombres ASC")
public class Socio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "nombres", nullable = true)
	private String nombres;
	@Column(name = "apellidos", nullable = true)
	private String apellidos;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "nro_socio", nullable = true)
	private int nroSocio;
	@Column(name = "nro_cedula", nullable = true)
	private int nroCedula;
	@Column(name = "fecha_ingreso", columnDefinition = "	TIMESTAMP", nullable = true)
	private LocalDate fechaIngreso;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private Opcion estadoActual;
	@Column(name = "fecha_estado_actual", columnDefinition = "	TIMESTAMP", nullable = true)
	private LocalDate fechaEstadoActual;
	@Column(name = "fundador",  columnDefinition = "boolean" , nullable = true)
	private boolean fundador;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private Usuario usuarioCreacion;
	@Column(name = "fecha_creacion", columnDefinition = "	TIMESTAMP", nullable = true)
	private LocalDate fecha_creacion;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socios_id" , nullable = true)
	private Socio socioProponente;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_socio_id" , nullable = true)
	private Opcion tipoSocio;
	
	
	public static Socio ofDTO(SocioDTO dto) {
		Socio socio = new Socio();
		return socio;
	}
	
	public SocioDTO toDTO() {
		SocioDTO socio = new SocioDTO();
		return socio;
	}
	
	
	public Socio(int id) {
		super();
		this.id = id;
	}
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(int nroSocio) {
		this.nroSocio = nroSocio;
	}
	public int getNroCedula() {
		return nroCedula;
	}
	public void setNroCedula(int nroCedula) {
		this.nroCedula = nroCedula;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Opcion getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(Opcion estadoActual) {
		this.estadoActual = estadoActual;
	}
	public LocalDate getFechaEstadoActual() {
		return fechaEstadoActual;
	}
	public void setFechaEstadoActual(LocalDate fechaEstadoActual) {
		this.fechaEstadoActual = fechaEstadoActual;
	}
	public boolean isFundador() {
		return fundador;
	}
	public void setFundador(boolean fundador) {
		this.fundador = fundador;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public Socio getSocioProponente() {
		return socioProponente;
	}
	public void setSocioProponente(Socio socioProponente) {
		this.socioProponente = socioProponente;
	}
	public Opcion getTipoSocio() {
		return tipoSocio;
	}
	public void setTipoSocio(Opcion tipoSocio) {
		this.tipoSocio = tipoSocio;
	}
	@Override
	public String toString() {
		return "SocioDTO [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", nroSocio=" + nroSocio + ", nroCedula=" + nroCedula + ", fechaIngreso=" + fechaIngreso
				+ ", estadoActual=" + estadoActual + ", fechaEstadoActual=" + fechaEstadoActual + ", fundador="
				+ fundador + ", usuarioCreacion=" + usuarioCreacion + ", fecha_creacion=" + fecha_creacion
				+ ", socioProponente=" + socioProponente + ", tipoSocio=" + tipoSocio + "]";
	}
	
	
	
	
	
	
	
	

}
