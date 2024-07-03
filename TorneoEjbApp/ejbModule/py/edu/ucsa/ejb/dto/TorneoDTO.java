package py.edu.ucsa.ejb.dto;

import java.time.LocalDate;


public class TorneoDTO {

	private Long id;

	private String anho;

	private String nombre;

	private int numeroEquipo;

	private LocalDate fechaInicio;

	private LocalDate fechaFin;

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

	public int getNumeroEquipo() {
		return numeroEquipo;
	}

	public void setNumeroEquipo(int numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "TorneoDTO [id=" + id + ", anho=" + anho + ", nombre=" + nombre + ", numeroEquipo=" + numeroEquipo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

}
