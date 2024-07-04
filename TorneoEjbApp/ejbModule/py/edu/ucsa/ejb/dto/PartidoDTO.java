package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.time.LocalDate;



public class PartidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private EquipoDTO equipoLocal;
	private EquipoDTO equipoVisitante;
	private TorneoDTO torneoDTO;
	private String fecha;
	private String hora;
	private int goleLocal;
	private int goleVisitante;
	private int fechaNro;
	
	
	
	
	public PartidoDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public EquipoDTO getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(EquipoDTO equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public EquipoDTO getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(EquipoDTO equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public TorneoDTO getTorneo() {
		return torneoDTO;
	}

	public void setTorneo(TorneoDTO torneoDTO) {
		this.torneoDTO = torneoDTO;
	}



	public TorneoDTO getTorneoDTO() {
		return torneoDTO;
	}

	public void setTorneoDTO(TorneoDTO torneoDTO) {
		this.torneoDTO = torneoDTO;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
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
		return "PartidoDTO [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", torneoDTO=" + torneoDTO + ", fecha=" + fecha + ", hora=" + hora + ", goleLocal=" + goleLocal
				+ ", goleVisitante=" + goleVisitante + ", fechaNro=" + fechaNro + "]";
	}

}
