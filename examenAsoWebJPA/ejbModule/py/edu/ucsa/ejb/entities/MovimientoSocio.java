package py.edu.ucsa.ejb.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;


@Entity
@Table(name = "movimientos_socios")
@NamedQuery(name = "MovimientoSocio.findAll", query = "SELECT m FROM MovimientoSocio m ORDER BY m.monto ASC")
public class MovimientoSocio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "fecha_pago", nullable = true)
	private LocalDateTime fechaPago;
	@Column(name = "monto", nullable = true)
	private double monto;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private Opcion concepto;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private Opcion estado;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
	private Opcion medioPago;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socios_id" , nullable = true)
	private Socio socio;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipos_movimientos_id" , nullable = true)
	private TipoMovimiento tipoMovimiento;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private Usuario usuarioAprobacion;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
	private Usuario usuarioCreacion;

	
	
	
	public MovimientoSocio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovimientoSocio(Integer id) {
		super();
		this.id = id;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDateTime fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Opcion getConcepto() {
		return concepto;
	}

	public void setConcepto(Opcion concepto) {
		this.concepto = concepto;
	}

	public Opcion getEstado() {
		return estado;
	}

	public void setEstado(Opcion estado) {
		this.estado = estado;
	}

	public Opcion getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(Opcion medioPago) {
		this.medioPago = medioPago;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Usuario getUsuarioAprobacion() {
		return usuarioAprobacion;
	}

	public void setUsuarioAprobacion(Usuario usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		return "MovimientoSocio [id=" + id + ", fechaPago=" + fechaPago + ", monto=" + monto + ", concepto=" + concepto
				+ ", estado=" + estado + ", medioPago=" + medioPago + ", socio=" + socio + ", tipoMovimiento="
				+ tipoMovimiento + ", usuarioAprobacion=" + usuarioAprobacion + ", usuarioCreacion=" + usuarioCreacion
				+ "]";
	}

}
