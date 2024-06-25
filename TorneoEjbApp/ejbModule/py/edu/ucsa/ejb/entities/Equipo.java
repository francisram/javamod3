package py.edu.ucsa.ejb.entities;

import java.util.List;

public class Equipo {

	private Integer id;
	private String nombre;
	private String slogan;
	private String capitan;
	private List<Jugador> jugadores;
	
	
	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
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
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getCapitan() {
		return capitan;
	}
	public void setCapitan(String capitan) {
		this.capitan = capitan;
	}
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", slogan=" + slogan + ", capitan=" + capitan
				+ ", jugadores=" + jugadores + "]";
	}
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
