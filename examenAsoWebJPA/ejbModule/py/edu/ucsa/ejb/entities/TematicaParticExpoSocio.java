package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.Opcion;
import py.edu.ucsa.ejb.dto.Usuario;

@Entity
@Table(name = "tematica_partic_expo_socios")
@NamedQuery(name = "TematicaParticExpoSocio.findAll", query = "SELECT r FROM TematicaParticExpoSocio r ORDER BY r.rol ASC")
public class TematicaParticExpoSocio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "descripcion", nullable = true)
	private ParticExpoSocio particExpoSocio;
	@Column(name = "descripcion", nullable = true)
	private Opcion tematicaGeneral;
	
	private String tematicaEspecifica;
	
	private boolean canceloPartidoTematica;
	
	private LocalDate fechaCancelacion;
	
	private LocalDate fechaCreacion;
	
	private Usuario usuarioCreacion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParticExpoSocio getParticExpoSocio() {
		return particExpoSocio;
	}

	public void setParticExpoSocio(ParticExpoSocio particExpoSocio) {
		this.particExpoSocio = particExpoSocio;
	}

	public Opcion getTematicaGeneral() {
		return tematicaGeneral;
	}

	public void setTematicaGeneral(Opcion tematicaGeneral) {
		this.tematicaGeneral = tematicaGeneral;
	}

	public String getTematicaEspecifica() {
		return tematicaEspecifica;
	}

	public void setTematicaEspecifica(String tematicaEspecifica) {
		this.tematicaEspecifica = tematicaEspecifica;
	}

	public boolean isCanceloPartidoTematica() {
		return canceloPartidoTematica;
	}

	public void setCanceloPartidoTematica(boolean canceloPartidoTematica) {
		this.canceloPartidoTematica = canceloPartidoTematica;
	}

	public LocalDate getFechaCancelacion() {
		return fechaCancelacion;
	}

	public void setFechaCancelacion(LocalDate fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	

	
	
	
	

}
