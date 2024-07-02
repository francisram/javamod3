package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
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

@Entity
@NamedQuery(name = "Torneo.findAll",query = "SELECT t FROM Torneo t ORDER BY t.id ASC")
public class Torneo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "anho")
	private String anho;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "numero_equipo")
	private int numeroEquipo;
	@Column(name = "fecha_inicio" , columnDefinition = "DATE")
	private LocalDate fechaInicio;
	@Column(name = "fecha_fin" , columnDefinition = "DATE")
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
		return "Torneo [id=" + id + ", anho=" + anho + ", nombre=" + nombre + ", numeroEquipo=" + numeroEquipo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	

}
