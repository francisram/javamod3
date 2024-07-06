package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EquipoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String slogan;
	private JugadorDTO capitan;
	private List<JugadorDTO> jugadores;
	
	
	public List<JugadorDTO> getJugadores() {
		if (this.jugadores == null) {
			this.jugadores = new ArrayList<>();
		}
		return jugadores;
	}

	public void setJugadores(List<JugadorDTO> jugadores) {
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

	public JugadorDTO getCapitan() {
		return capitan;
	}

	public void setCapitan(JugadorDTO capitan) {
		this.capitan = capitan;
	}

	@Override
	public String toString() {
		return "EquipoDTO [id=" + id + ", nombre=" + nombre + ", slogan=" + slogan + ", capitan=" + capitan
				+ ", jugadores=" + jugadores + "]";
	}

	public EquipoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
