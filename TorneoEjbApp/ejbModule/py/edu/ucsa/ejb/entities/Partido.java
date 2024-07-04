package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.EquipoDTO;
import py.edu.ucsa.ejb.dto.PartidoDTO;

@Entity
@Table(name = "partidos")
@NamedQuery(name = "PartidoDTO.findAll", query = "SELECT p FROM  PartidoDTO p ORDER BY p.fechaNro ASC")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "equipo_local")
	private Equipo equipoLocal;
	@ManyToOne()
	@JoinColumn(name = "equipo_visitante")
	private Equipo equipoVisitante;
	@ManyToOne()
	@JoinColumn(name = "torneo_id")
	private Torneo torneo;
	@Column(name = "fecha_partido", columnDefinition = "DATE")
	private LocalDate fecha;
	@Column(name = "hora", columnDefinition = "	TIMESTAMP")
	private LocalDateTime  hora;
	@Column(name = "goles_local")
	private int goleLocal;
	@Column(name = "goles_visitante")
	private int goleVisitante;
	@Column(name = "fecha_nro")
	private int fechaNro;
	
	public PartidoDTO toDTO() {
		PartidoDTO dto = new PartidoDTO();
		dto.setId(this.getId());
		if(!Objects.isNull(this.getTorneo())) {
			dto.setTorneo(this.getTorneo().toDTO());
		}
		if(!Objects.isNull(this.getEquipoLocal())) {
			dto.setEquipoLocal(this.getEquipoLocal().toListaDTO());
		}
		if(!Objects.isNull(this.getEquipoVisitante())) {
			dto.setEquipoLocal(this.getEquipoVisitante().toListaDTO());
		}
		if(!Objects.isNull(this.getFecha())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dto.setFecha(this.getFecha().format(dtf));
		}
		if(!Objects.isNull(this.getHora())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			dto.setHora(this.getHora().format(dtf));
		}
		
		dto.setFechaNro(this.getFechaNro());
		dto.setGoleLocal(this.getGoleLocal());
		dto.setGoleVisitante(this.getGoleVisitante());
		return dto;
		
	}
	
	
	public static Partido ofDTO(PartidoDTO dto) {
		Partido entity = new Partido();
		entity.setId(dto.getId());
		if(!Objects.isNull(dto.getTorneo())) {
			entity.setTorneo(Torneo.ofDTO(dto.getTorneo()));
		}
		if(!Objects.isNull(dto.getEquipoLocal())) {
			entity.setEquipoLocal(Equipo.ofDTO(dto.getEquipoLocal()));
		}
		if(!Objects.isNull(dto.getEquipoVisitante())) {
			entity.setEquipoLocal(Equipo.ofDTO(dto.getEquipoVisitante()));
		}
		if(!Objects.isNull(dto.getFecha())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			entity.setFecha(LocalDate.parse(dto.getFecha(),dtf));
		}
		if(!Objects.isNull(dto.getHora())) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
			entity.setHora(LocalDateTime.parse(dto.getHora(),dtf));
		}
		entity.setFechaNro(dto.getFechaNro());
		entity.setGoleLocal(dto.getGoleLocal());
		entity.setGoleVisitante(dto.getGoleVisitante());
		
		return entity;
	}
	
	public int getFechaNro() {
		return fechaNro;
	}
	public void setFechaNro(int fechaNro) {
		this.fechaNro = fechaNro;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	public Torneo getTorneo() {
		return torneo;
	}
	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}

	public int getGoleLocal() {
		return goleLocal;
	}
	public void setGoleLocal(int goleLocal) {
		this.goleLocal = goleLocal;
	}
	public int getGoleVisitante() {
		return goleVisitante;
	}
	public void setGoleVisitante(int goleVisitante) {
		this.goleVisitante = goleVisitante;
	}
	@Override
	public String toString() {
		return "PartidoDTO [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", torneo=" + torneo + ", fecha=" + fecha + ", hora=" + hora + ", goleLocal=" + goleLocal
				+ ", goleVisitante=" + goleVisitante + ", fechaNro=" + fechaNro + "]";
	}
	
	
	
}
