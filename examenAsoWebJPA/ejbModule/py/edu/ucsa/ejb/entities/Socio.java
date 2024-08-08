package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
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
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.dto.SocioDTO;
import py.edu.ucsa.ejb.dto.UsuarioDTO;

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
	@Column(name = "fecha_ingreso", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaIngreso;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private Opcion estadoActual;
	@Column(name = "fecha_estado_actual", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaEstadoActual;
	@Column(name = "fundador",  columnDefinition = "boolean" , nullable = true)
	private boolean fundador;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private Usuario usuarioCreacion;
	@Column(name = "fecha_creacion", columnDefinition = "DATE", nullable = true)
	private LocalDate fecha_creacion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_socio_proponente" , nullable = true)
	private Socio socioProponente;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_socio_id" , nullable = true)
	private Opcion tipoSocio;
	
	
	public static Socio ofDTO(SocioDTO dto) {
		Socio socio = new Socio();
		socio.setApellidos(dto.getApellidos());
		socio.setEmail(dto.getEmail());
		socio.setEstadoActual(Opcion.ofDTO(dto.getEstadoActual()));
		socio.setFecha_creacion(dto.getFecha_creacion());
		socio.setFechaEstadoActual(dto.getFechaEstadoActual());
		socio.setFechaIngreso(dto.getFechaIngreso());
		socio.setFundador(dto.isFundador());
		socio.setId(dto.getId());
		socio.setNombres(dto.getNombres());
		socio.setNroCedula(dto.getNroCedula());
		socio.setNroSocio(dto.getNroSocio());
		socio.setSocioProponente(Socio.ofDTO(dto.getSocioProponente()));
		socio.setTipoSocio(Opcion.ofDTO(dto.getTipoSocio()));
		socio.setUsuarioCreacion(Usuario.ofDTO(dto.getUsuarioCreacion()));
		return socio;
	}
	
	public SocioDTO toDTO() {
		SocioDTO socio = new SocioDTO();
		socio.setApellidos(this.apellidos);
		socio.setEmail(this.email);
		OpcionDTO opcion = new OpcionDTO();
		opcion.setId(this.estadoActual.getId());
		socio.setEstadoActual(opcion);
		if(!Objects.isNull(this.fecha_creacion)) {
			socio.setFecha_creacion(this.fecha_creacion);			
		}
		if(Objects.isNull(this.fechaEstadoActual)) {
			socio.setFechaEstadoActual(this.fechaEstadoActual);			
		}
		if(Objects.isNull(this.fechaIngreso)) {
			socio.setFechaIngreso(this.fechaIngreso);		
		}
		socio.setFundador(this.fundador);
		socio.setId(this.id);
		socio.setNombres(this.nombres);
		socio.setNroCedula(this.nroCedula);
		socio.setNroSocio(this.nroSocio);
		SocioDTO proponente = new SocioDTO();
		proponente.setId(this.socioProponente.getId());
		socio.setSocioProponente(proponente);
		OpcionDTO tipoSocio = new OpcionDTO();
		tipoSocio.setId(this.tipoSocio.getId());
		socio.setTipoSocio(tipoSocio);
		UsuarioDTO creador = new UsuarioDTO();
		creador.setId(this.usuarioCreacion.getId());
		socio.setUsuarioCreacion(creador);
		
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
