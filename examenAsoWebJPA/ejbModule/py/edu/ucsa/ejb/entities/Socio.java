package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
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
public class Socio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estado_actual" , nullable = true)
	private Opcion estadoActual;
	@Column(name = "fecha_estado_actual", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaEstadoActual;
	@Column(name = "fundador",  columnDefinition = "boolean" , nullable = true)
	private boolean fundador;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_creacion" , nullable = true)
	private Usuario usuarioCreacion;
	@Column(name = "fecha_creacion", columnDefinition = "DATE", nullable = true)
	private LocalDate fecha_creacion;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_socio_proponente" , nullable = true)
	private Socio socioProponente;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_socio" , nullable = true)
	private Opcion tipoSocio;
	
	
	public static Socio ofDTO(SocioDTO dto) {
		Socio socio = new Socio();
		socio.setApellidos(dto.getApellidos());
		socio.setEmail(dto.getEmail());
		if(!Objects.isNull(dto.getEstadoActual())) {
			socio.setEstadoActual(Opcion.ofDTO(dto.getEstadoActual()));			
		}
		if(!Objects.isNull(dto.getFecha_creacion())) {
			socio.setFecha_creacion(dto.getFecha_creacion());			
		}
		if(!Objects.isNull(dto.getFechaEstadoActual())) {
			socio.setFechaEstadoActual(dto.getFechaEstadoActual());			
		}
		if(!Objects.isNull(dto.getFechaIngreso())) {
			socio.setFechaIngreso(dto.getFechaIngreso());			
		}
		if(!Objects.isNull(dto.isFundador())) {
			socio.setFundador(dto.isFundador());			
		}
		if(!Objects.isNull(dto.getId())) {
			socio.setId(dto.getId());			
		}
		if(!Objects.isNull(dto.getNombres())) {
			socio.setNombres(dto.getNombres());			
		}
		if(!Objects.isNull(dto.getNroCedula())) {
			socio.setNroCedula(dto.getNroCedula());			
		}
		if(!Objects.isNull(dto.getNroSocio())) {
			socio.setNroSocio(dto.getNroSocio());			
		}
		if(!Objects.isNull(dto.getSocioProponente())) {
			socio.setSocioProponente(Socio.ofDTO(dto.getSocioProponente()));			
		}
		if(!Objects.isNull(dto.getTipoSocio())) {
			socio.setTipoSocio(Opcion.ofDTO(dto.getTipoSocio()));			
		}
		if(!Objects.isNull(dto.getUsuarioCreacion())) {
			socio.setUsuarioCreacion(Usuario.ofDTO(dto.getUsuarioCreacion()));			
		}
		return socio;
	}
	
	public SocioDTO toDTO() {
		SocioDTO socio = new SocioDTO();
		if(!Objects.isNull(this.getApellidos())) {
			socio.setApellidos(this.getApellidos());			
		}
		if(!Objects.isNull(this.getEmail())) {
			socio.setEmail(this.getEmail());			
		}
		if(!Objects.isNull(this.getEstadoActual())) {
			socio.setEstadoActual(this.getEstadoActual().toDTO());			
		}
		if(!Objects.isNull(this.fecha_creacion)) {
			socio.setFecha_creacion(this.fecha_creacion);			
		}
		if(Objects.isNull(this.fechaEstadoActual)) {
			socio.setFechaEstadoActual(this.fechaEstadoActual);			
		}
		if(Objects.isNull(this.fechaIngreso)) {
			socio.setFechaIngreso(this.fechaIngreso);		
		}
		if(!Objects.isNull(this.fundador)) {
			socio.setFundador(this.fundador);			
		}
		if(!Objects.isNull(this.id)) {
			socio.setId(this.id);			
		}
		if(!Objects.isNull(this.nombres)) {
			socio.setNombres(this.getNombres());			
		}
		if(!Objects.isNull(this.nroCedula)) {
			socio.setNroCedula(this.getNroCedula());			
		}
		if(!Objects.isNull(this.nroSocio)) {
			socio.setNroSocio(this.getNroSocio());			
		}
		if(!Objects.isNull(this.getSocioProponente())) {
			socio.setSocioProponente(this.getSocioProponente().toDTO());			
		}
		if(!Objects.isNull(this.getTipoSocio())) {
			socio.setTipoSocio(this.getTipoSocio().toDTO());			
		}
		if(!Objects.isNull(this.getUsuarioCreacion())) {
			socio.setUsuarioCreacion(this.getUsuarioCreacion().toDTO());			
		}
		
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
	    return "Socio [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email 
	           + ", nroSocio=" + nroSocio + ", nroCedula=" + nroCedula + ", fechaIngreso=" + fechaIngreso 
	           + ", estadoActual=" + (estadoActual != null ? estadoActual.getId() : null) 
	           + ", fechaEstadoActual=" + fechaEstadoActual + ", fundador=" + fundador 
	           + ", usuarioCreacion=" + (usuarioCreacion != null ? usuarioCreacion.getId() : null) 
	           + ", fecha_creacion=" + fecha_creacion 
	           + ", socioProponente=" + (socioProponente != null ? socioProponente.getId() : null) 
	           + ", tipoSocio=" + (tipoSocio != null ? tipoSocio.getId() : null) + "]";
	}

	
	
	
	
	
	
	
	

}
