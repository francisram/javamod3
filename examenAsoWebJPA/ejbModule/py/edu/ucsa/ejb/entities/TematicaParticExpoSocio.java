package py.edu.ucsa.ejb.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.OpcionDTO;
import py.edu.ucsa.ejb.dto.UsuarioDTO;

@Entity
@Table(name = "tematica_partic_expo_socios")
@NamedQuery(name = "TematicaParticExpoSocio.findAll", query = "SELECT t FROM TematicaParticExpoSocio t ORDER BY t.id ASC")
public class TematicaParticExpoSocio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partic_expo_socios_id" , nullable = true)
	private ParticExpoSocio particExpoSocio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private OpcionDTO tematicaGeneral;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private String tematicaEspecifica;
	
	@Column(name = "cancelo_participacion", columnDefinition="boolean",  nullable = true)
	private boolean canceloPartidoTematica;
	
	@Column(name = "fecha_cancelacion", columnDefinition="TIMESTAMPS",  nullable = true)
	private LocalDate fechaCancelacion;
	
	@Column(name = "cancelo_creacion", columnDefinition="TIMESTAMPS",  nullable = true)
	private LocalDate fechaCreacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private UsuarioDTO usuarioCreacion;

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

	public OpcionDTO getTematicaGeneral() {
		return tematicaGeneral;
	}

	public void setTematicaGeneral(OpcionDTO tematicaGeneral) {
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

	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	

	
	
	
	

}
