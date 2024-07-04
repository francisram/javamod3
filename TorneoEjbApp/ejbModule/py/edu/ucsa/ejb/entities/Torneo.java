package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import py.edu.ucsa.ejb.dto.TorneoDTO;

@Entity
@NamedQuery(name = "TorneoDTO.findAll",query = "SELECT t FROM TorneoDTO t ORDER BY t.id ASC")
public class Torneo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "anho")
	private String anho;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "num_equipos")
	private int numEquipos;
	@Column(name = "fecha_inicio" , columnDefinition = "DATE")
	private LocalDate fechaInicio;
	@Column(name = "fecha_fin" , columnDefinition = "DATE")
	private LocalDate fechaFin;

	
	
	public TorneoDTO toDTO(){
		TorneoDTO dto = new TorneoDTO();
		dto.setId(this.getId());
		dto.setAnho(this.getAnho());
		dto.setNombre(this.getNombre());
		dto.setNumEquipo(this.getNumEquipos());
		if(!Objects.isNull(this.getFechaInicio())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaInicio(this.getFechaInicio().format(dtf));
		}
		if(!Objects.isNull(this.getFechaFin())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFechaFin(this.getFechaFin().format(dtf));
		}
		
		return dto;
	}
	public static Torneo ofDTO(TorneoDTO dto){
		
		Torneo entity = new Torneo();
		entity.setId(dto.getId());
		entity.setAnho(dto.getAnho());
		entity.setNombre(dto.getNombre());
		entity.setNumEquipo(dto.getNumEquipo());
		if(!Objects.isNull(dto.getFechaInicio())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			entity.setFechaInicio(LocalDate.parse(dto.getFechaInicio(),dtf));
		}
		if(!Objects.isNull(dto.getFechaFin())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			entity.setFechaFin(LocalDate.parse(dto.getFechaInicio(),dtf));
		}
		
		return entity;

	}
	


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

	public int getNumEquipos() {
		return numEquipos;
	}
	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
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
		return "Torneo [id=" + id + ", anho=" + anho + ", nombre=" + nombre + ", numEquipos=" + numEquipos
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + "]";
	}

	

}
