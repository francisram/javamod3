package py.edu.ucsa.ejb.entities;

import java.util.List;

public class Torneo {
	private int id;
	private String anho;
	private String nombre;
	private int numeroEquipo;
	private String fechaInicio;
	private String fechaFin;
	private List<Partido> partidos;
	
	
	
	
	public List<Partido> getPartidos() {
		return partidos;
	}
	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
		return "Torneo [id=" + id + ", anho=" + anho + ", nombre=" + nombre + ", numeroEquipo=" + numeroEquipo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	

}
