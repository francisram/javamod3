package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the extractos_caja database table.
 * 
 */
@Entity
@Table(name="extractos_caja")
@NamedQuery(name="ExtractoCaja.findAll", query="SELECT e FROM ExtractoCaja e")
public class ExtractoCaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	@Column(name="fecha_hora_creacion")
	private Timestamp fechaAlta;

	@Column(name="fecha_hora_ult_modif")
	private Timestamp fechaModificacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_movimiento")
	private Date fechaMovimiento;

	private BigDecimal monto;

	@Column(name="tipo_movimiento")
	private String tipoMovimiento;

	//bi-directional many-to-one association to CajaAhorro
	@ManyToOne
	@JoinColumn(name="id_caja")
	private CajaAhorro cajaAhorro;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_ult_modif")
	private Usuario usuarioModificacion;

	public ExtractoCaja() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Timestamp getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public CajaAhorro getCajaAhorro() {
		return this.cajaAhorro;
	}

	public void setCajaAhorro(CajaAhorro cajaAhorro) {
		this.cajaAhorro = cajaAhorro;
	}

	public Usuario getUsuarioAlta() {
		return this.usuarioAlta;
	}

	public void setUsuarioAlta(Usuario usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	public Usuario getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

}