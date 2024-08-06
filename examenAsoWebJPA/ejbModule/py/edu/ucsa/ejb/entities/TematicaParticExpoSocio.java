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
	@JoinColumn(name = "tematica_general_id" , nullable = true)
	private Opcion tematicaGeneral;
	
	@Column(name = "tematica_especifica",   nullable = true)
	private String tematicaEspecifica;
	
	@Column(name = "cancelo_participacion", columnDefinition="boolean",  nullable = true)
	private boolean canceloPartidoTematica;
	
	@Column(name = "fecha_cancelacion", columnDefinition="DATE",  nullable = true)
	private LocalDate fechaCancelacion;
	
	@Column(name = "cancelo_creacion", columnDefinition="DATE",  nullable = true)
	private LocalDate fechaCreacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_creacion_id" , nullable = true)
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
