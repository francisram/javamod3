package py.edu.ucsa.ejb.dto;

import java.io.Serializable;
import java.sql.Date;

public class PagoCuotaSocioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
    private Integer anhoCuota;
    private boolean exonerado;
    private Date fechaCreacion;
    private Integer mesCuota;
    private double montoCuota;
    private OpcionDTO idEstado;
    private OpcionDTO motivoExoneracion;
    private MovimientoSocioDTO movimientoSocioDTO;
    private SocioDTO socioDTO;
    private UsuarioDTO usuarioCreacion;
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

	public OpcionDTO getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(OpcionDTO idEstado) {
		this.idEstado = idEstado;
	}
	public OpcionDTO getMotivoExoneracion() {
		return motivoExoneracion;
	}
	public void setMotivoExoneracion(OpcionDTO motivoExoneracion) {
		this.motivoExoneracion = motivoExoneracion;
	}
	public MovimientoSocioDTO getMovimientoSocio() {
		return movimientoSocioDTO;
	}
	public void setMovimientoSocio(MovimientoSocioDTO movimientoSocioDTO) {
		this.movimientoSocioDTO = movimientoSocioDTO;
	}
	public SocioDTO getSocio() {
		return socioDTO;
	}
	public void setSocio(SocioDTO socioDTO) {
		this.socioDTO = socioDTO;
	}
	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	@Override
	public String toString() {
		return "PagoCuotaSocioDTO [id=" + id + ", anhoCuota=" + anhoCuota + ", exonerado=" + exonerado + ", fechaCreacion="
				+ fechaCreacion + ", mesCuota=" + mesCuota + ", montoCuota=" + montoCuota + ", idEstado=" + idEstado
				+ ", motivoExoneracion=" + motivoExoneracion + ", movimientoSocioDTO=" + movimientoSocioDTO + ", socioDTO="
				+ socioDTO + ", usuarioCreacion=" + usuarioCreacion + "]";
	}
    
    

}
