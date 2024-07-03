package py.edu.ucsa.ejb.entities;

import java.util.ArrayList;
import java.util.List;

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

@Entity
@Table(name = "equipos")
@NamedQuery(name = "EquipoDTO.findAll", query = "SELECT e FROM EquipoDTO e ORDER BY e.nombre ASC")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	 @Column(name = "slogan")
	private String slogan;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "capitan_id")
	private Jugador capitan;
	@OneToMany(mappedBy = "equipo")
	private List<Jugador> jugadores;

	public List<Jugador> getJugadores() {
		if (this.jugadores == null) {
			this.jugadores = new ArrayList<Jugador>();
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

}
