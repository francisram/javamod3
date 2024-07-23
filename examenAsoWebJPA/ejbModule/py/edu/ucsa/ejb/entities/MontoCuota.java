package py.edu.ucsa.ejb.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "montos_cuota")
@NamedQuery(name = "MontoCuota.findAll", query = "SELECT m FROM MontoCuota m ORDER BY m.monto ASC")
public class MontoCuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "monto", nullable = true)
	private double monto;
	@Column(name = "fecha_creacion", nullable = true)
	private LocalDateTime fechaCreacion;
	@Column(name = "fecha_inicio_vigencia", nullable = true)
	private LocalDateTime fechaInicioVigencia;
	@Column(name = "fecha_fin_vigencia", nullable = true)
	private LocalDateTime fechaFinVigencia;
	@Column(name = "fecha_inactivacion", nullable = true)
	private LocalDateTime fechaInactivacion;
	@Column(name = "estado", nullable = true)
	private String estado;
	@Column(name = "usuario_id", nullable = true)
	private Usuario usuarioInactivacion;
	
	
	
	
	@Override
	public String toString() {
		return "MontoCuota [id=" + id + ", monto=" + monto + ", fechaCreacion=" + fechaCreacion
				+ ", fechaInicioVigencia=" + fechaInicioVigencia + ", fechaFinVigencia=" + fechaFinVigencia
				+ ", fechaInactivacion=" + fechaInactivacion + ", estado=" + estado + ", usuarioInactivacion="
				+ usuarioInactivacion + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public LocalDateTime getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(LocalDateTime fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	public LocalDateTime getFechaFinVigencia() {
		return fechaFinVigencia;
	}
	public void setFechaFinVigencia(LocalDateTime fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}
	public LocalDateTime getFechaInactivacion() {
		return fechaInactivacion;
	}
	public void setFechaInactivacion(LocalDateTime fechaInactivacion) {
		this.fechaInactivacion = fechaInactivacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getUsuarioInactivacion() {
		return usuarioInactivacion;
	}
	public void setUsuarioInactivacion(Usuario usuarioInactivacion) {
		this.usuarioInactivacion = usuarioInactivacion;
	}
	
	

	
}
