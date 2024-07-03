package py.edu.ucsa.ejb.dto;

import java.time.LocalDate;



public class PartidoDTO {

	private Long id;

	private EquipoDTO equipoLocal;

	private EquipoDTO equipoVisitante;

	private TorneoDTO torneoDTO;

	private LocalDate fecha;

	private String hora;

	private int goleLocal;

	private int goleVisitante;

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
		return "PartidoDTO [id=" + id + ", equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante
				+ ", torneoDTO=" + torneoDTO + ", fecha=" + fecha + ", hora=" + hora + ", goleLocal=" + goleLocal
				+ ", goleVisitante=" + goleVisitante + ", fechaNro=" + fechaNro + "]";
	}

}
