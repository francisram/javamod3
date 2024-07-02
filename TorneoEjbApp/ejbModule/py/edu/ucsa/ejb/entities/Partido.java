package py.edu.ucsa.ejb.entities;

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
@NamedQuery(name = "Partido.findAll", query = "SELECT p FROM  Partido p ORDER BY p.numeroFechaTorneo ASC")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
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
	private String fecha;
	private int numeroFechaTorneo;
	private String hora;
	private String resultado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNumeroFechaTorneo() {
		return numeroFechaTorneo;
	}
	public void setNumeroFechaTorneo(int numeroFechaTorneo) {
		this.numeroFechaTorneo = numeroFechaTorneo;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	@Override
	public String toString() {
		return "Partido [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", torneo=" + torneo + ", fecha=" + fecha + ", numeroFechaTorneo=" + numeroFechaTorneo + ", hora="
				+ hora + ", resultado=" + resultado + "]";
	}
	
	
	
}
