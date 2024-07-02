package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partidos")
@NamedQuery(name = "Partido.findAll", query = "SELECT p FROM  Partido p ORDER BY p.fechaNro ASC")
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
	private String hora;
	@Column(name = "goles_local")
	private int goleLocal;
	@Column(name = "goles_visitante")
	private int goleVisitante;
	@Column(name = "fecha_nro")
	private int fechaNro;
	
	
	
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

	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
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
		return "Partido [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", torneo=" + torneo + ", fecha=" + fecha + ", hora=" + hora + ", goleLocal=" + goleLocal
				+ ", goleVisitante=" + goleVisitante + ", fechaNro=" + fechaNro + "]";
	}
	
	
	
}
