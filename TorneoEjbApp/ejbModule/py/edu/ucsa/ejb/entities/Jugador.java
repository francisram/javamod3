package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;

@Entity
@Table(name = "jugadores")
@NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j ORDER BY j.nombres ASC")
@NamedQuery(name = "Jugador.findJugadoresSinEquipo", query = "SELECT j FROM Jugador j WHERE j.equipo is NULL")
@NamedQuery(name = "Jugador.findJugadoresPorEquipo", query = "SELECT j FROM Jugador j WHERE j.equipo = :equipo")
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombres", nullable = true)
	private String nombres;
	@Column(name = "apellidos", nullable = true)
	private String apellidos;
	@Column(name = "fecha_nacimiento", columnDefinition = "DATE", nullable = true)
	private LocalDate fechaNacimiento;
	@Column(name = "nro_ficha", nullable = true)
	private int nroFicha;
	@Column(name = "nacionalidad", nullable = true)
	private String nacionalidad;
	@Column(name = "telefono", nullable = true)
	private String telefono;
	@Column(name = "email", nullable = true)
	private String email;

	@ManyToOne(optional = true)
	@JoinColumn(name = "equipo_id")
	private Equipo equipo;

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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




	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getNroFicha() {
		return nroFicha;
	}

	public void setNroFicha(int nroFicha) {
		this.nroFicha = nroFicha;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", nroFicha=" + nroFicha + ", nacionalidad=" + nacionalidad + ", telefono="
				+ telefono + ", email=" + email + ", equipo=" + equipo + "]";
	}

	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public JugadorDTO toDTO() {
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());
		dto.setNroFicha(this.getNroFicha());
		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		if(!Objects.isNull(this.getFechaNacimiento())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dto.setFechaNacimiento(this.getFechaNacimiento().format(dtf));
		}
		dto.setNacionalidad(this.getNacionalidad());
		dto.setTelefono(this.getTelefono());
		dto.setEmail(this.getEmail());
		if(!Objects.isNull(this.getEquipo())) {
			dto.setEquipo(this.getEquipo().toListaDTO());
		}
		return dto;
	}
	
	public JugadorDTO toListaDTO() {
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());
		dto.setNroFicha(this.getNroFicha());
		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		if(!Objects.isNull(this.getFechaNacimiento())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dto.setFechaNacimiento(this.getFechaNacimiento().format(dtf));
		}
		dto.setNacionalidad(this.getNacionalidad());
		dto.setTelefono(this.getTelefono());
		dto.setEmail(this.getEmail());
		if(!Objects.isNull(this.getEquipo())) {
			dto.setEquipo(this.getEquipo().toListaDTO());			
		}
		return dto;
	}
	
	public JugadorDTO toListaBusqueda() {
		JugadorDTO dto = new JugadorDTO();
		dto.setId(this.getId());
		dto.setNroFicha(this.getNroFicha());
		dto.setNombres(this.getNombres());
		dto.setApellidos(this.getApellidos());
		dto.setNacionalidad(this.getNacionalidad());
		return dto;
	}
	
	public static Jugador ofDTO(JugadorDTO dto) {
		Jugador entity = new Jugador();
		entity.setId(dto.getId());
		entity.setNroFicha(dto.getNroFicha());
		entity.setNombres(dto.getNombres());
		entity.setApellidos(dto.getApellidos());
		if(!Objects.isNull(dto.getFechaNacimiento())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			entity.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento(),dtf));
		}
		entity.setNacionalidad(dto.getNacionalidad());
		entity.setTelefono(dto.getTelefono());
		entity.setEmail(dto.getEmail());
		if(!Objects.isNull(dto.getEquipo())) {
			entity.setEquipo(Equipo.ofDTO(dto.getEquipo()));
		}
		return entity;
	}

}
