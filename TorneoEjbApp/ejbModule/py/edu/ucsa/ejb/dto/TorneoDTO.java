package py.edu.ucsa.ejb.dto;

import java.io.Serializable;



public class TorneoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String anho;
	private String nombre;
	private int numEquipo;
	private String fechaInicio;
	private String fechaFin;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnho() {
		return anho;
	}

	public void setAnho(String anho) {
		this.anho = anho;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getNumEquipo() {
		return numEquipo;
	}

	public void setNumEquipo(int numEquipo) {
		this.numEquipo = numEquipo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "TorneoDTO [id=" + id + ", anho=" + anho + ", nombre=" + nombre + ", numEquipo=" + numEquipo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

}
