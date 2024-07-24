package py.edu.ucsa.ejb.entities;

import java.sql.Date;

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

@Entity
@Table(name = "pagos_cuotas_socios")
@NamedQuery(name = "PagoCuotaSocioDTO.findAll", query = "SELECT pc FROM PagoCuotaSocioDTO pc ORDER BY pc.id ASC")
public class PagoCuotaSocio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "anho_cuota", nullable = true)
    private Integer anhoCuota;
	
	@Column(name = "exonerado", columnDefinition = "boolean" ,nullable = true)
    private boolean exonerado;
	
	@Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;
	
	@Column(name = "mes_cuota", nullable = true)
    private Integer mesCuota;
	
	@Column(name = "monto_cuota", nullable = true)
    private double montoCuota;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
    private Opcion idEstado;
	
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "opciones_id" , nullable = true)
    private Opcion motivoExoneracion;
    
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movimientos_socios_id" , nullable = true)
    private MovimientoSocio movimientoSocio;
    
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "socios_id" , nullable = true)
    private Socio socio;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarios_id" , nullable = true)
    private Usuario usuarioCreacion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAnhoCuota() {
		return anhoCuota;
	}
	public void setAnhoCuota(Integer anhoCuota) {
		this.anhoCuota = anhoCuota;
	}
	public boolean isExonerado() {
		return exonerado;
	}
	public void setExonerado(boolean exonerado) {
		this.exonerado = exonerado;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Integer getMesCuota() {
		return mesCuota;
	}
	public void setMesCuota(Integer mesCuota) {
		this.mesCuota = mesCuota;
	}
	public double getMontoCuota() {
		return montoCuota;
	}
	public void setMontoCuota(double montoCuota) {
		this.montoCuota = montoCuota;
	}

	public Opcion getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Opcion idEstado) {
		this.idEstado = idEstado;
	}
	public Opcion getMotivoExoneracion() {
		return motivoExoneracion;
	}
	public void setMotivoExoneracion(Opcion motivoExoneracion) {
		this.motivoExoneracion = motivoExoneracion;
	}
	public MovimientoSocio getMovimientoSocio() {
		return movimientoSocio;
	}
	public void setMovimientoSocio(MovimientoSocio movimientoSocio) {
		this.movimientoSocio = movimientoSocio;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Usuario getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(Usuario usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	@Override
	public String toString() {
		return "PagoCuotaSocioDTO [id=" + id + ", anhoCuota=" + anhoCuota + ", exonerado=" + exonerado + ", fechaCreacion="
				+ fechaCreacion + ", mesCuota=" + mesCuota + ", montoCuota=" + montoCuota + ", idEstado=" + idEstado
				+ ", motivoExoneracion=" + motivoExoneracion + ", movimientoSocio=" + movimientoSocio + ", socio="
				+ socio + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
    
    

}
