package py.edu.ucsa.ejb.entities;

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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.JugadorDTO;

@Entity
@Table(name = "equipos")
@NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e ORDER BY e.nombre ASC")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre" , nullable = true, unique = true)
	private String nombre;
	 @Column(name = "slogan" , nullable = true)
	private String slogan;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "capitan_id" , nullable = true)
	private Jugador capitan;
	@OneToMany(mappedBy = "equipo")
	private List<Jugador> jugadores;

	public List<Jugador> getJugadores() {
		if (this.jugadores == null) {
			this.jugadores = new ArrayList<>();
		}
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Jugador getCapitan() {
		return capitan;
	}

	public void setCapitan(Jugador capitan) {
		this.capitan = capitan;
	}

	@Override
	public String toString() {
		return "EquipoDTO [id=" + id + ", nombre=" + nombre + ", slogan=" + slogan + ", capitan=" + capitan
				+ ", jugadores=" + jugadores + "]";
	}

	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EquipoDTO toDTO() {
		EquipoDTO dto = new EquipoDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		dto.setSlogan(this.getSlogan());
		if(!Objects.isNull(this.getCapitan())) {
			dto.setCapitan(this.getCapitan().toDTO());
		}
		if(!this.getJugadores().isEmpty()) {
			List<JugadorDTO> jugadores = new ArrayList<>();
			for (Jugador j : this.getJugadores()) {
				jugadores.add(j.toDTO());
			}
			dto.setJugadores(jugadores);
		}
		return dto;
	}

	public EquipoDTO toListaDTO() {
		EquipoDTO dto = new EquipoDTO();
		dto.setId(this.getId());
		dto.setNombre(this.getNombre());
		dto.setSlogan(this.getSlogan());
		return dto;
	}
	
	
	public static Equipo ofDTO(EquipoDTO dto) {
		Equipo entity = new Equipo();
		entity.setId(dto.getId());
		entity.setNombre(dto.getNombre());
		entity.setSlogan(dto.getSlogan());
		if(!Objects.isNull(dto.getCapitan())) {
			entity.setCapitan(Jugador.ofDTO(dto.getCapitan()));
		}
		if(!dto.getJugadores().isEmpty()) {
			List<Jugador> jugadores = new ArrayList<>();
			for (JugadorDTO j : dto.getJugadores()) {
				jugadores.add(Jugador.ofDTO(j));
			}
			entity.setJugadores(jugadores);
		}
		return entity;
		
	}
	
}
