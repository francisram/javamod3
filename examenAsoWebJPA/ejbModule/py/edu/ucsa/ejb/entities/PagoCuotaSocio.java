package py.edu.ucsa.ejb.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagocuotasocios")
@NamedQuery(name = "PagoCuotaSocio.findAll", query = "SELECT pc FROM PagoCuotaSocio pc ORDER BY pc.id ASC")
public class PagoCuotaSocio {
	private Integer id;
    private Integer anhoCuota;
    private boolean exonerado;
    private Date fechaCreacion;
    private Integer mesCuota;
    private double montoCuota;
    private Opcion idEstado;
    private Opcion motivoExoneracion;
    private MovimientoSocio movimientoSocio;
    private Socio socio;
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
		return "PagoCuotaSocio [id=" + id + ", anhoCuota=" + anhoCuota + ", exonerado=" + exonerado + ", fechaCreacion="
				+ fechaCreacion + ", mesCuota=" + mesCuota + ", montoCuota=" + montoCuota + ", idEstado=" + idEstado
				+ ", motivoExoneracion=" + motivoExoneracion + ", movimientoSocio=" + movimientoSocio + ", socio="
				+ socio + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
    
    

}
