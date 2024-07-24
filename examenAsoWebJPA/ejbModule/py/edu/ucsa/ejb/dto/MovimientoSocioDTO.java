package py.edu.ucsa.ejb.dto;

import java.time.LocalDateTime;

public class MovimientoSocioDTO {
	private Integer id;
	private LocalDateTime fechaPago;
	private double monto;
	private OpcionDTO concepto;
	private OpcionDTO estado;
	private OpcionDTO medioPago;
	private SocioDTO socioDTO;
	private TipoMovimientoDTO tipoMovimientoDTO;
	private UsuarioDTO usuarioAprobacion;
	private UsuarioDTO usuarioCreacion;

	
	
	
	public MovimientoSocioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovimientoSocioDTO(Integer id) {
		super();
		this.id = id;
	}

	public TipoMovimientoDTO getTipoMovimiento() {
		return tipoMovimientoDTO;
	}

	public void setTipoMovimiento(TipoMovimientoDTO tipoMovimientoDTO) {
		this.tipoMovimientoDTO = tipoMovimientoDTO;
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

	public OpcionDTO getConcepto() {
		return concepto;
	}

	public void setConcepto(OpcionDTO concepto) {
		this.concepto = concepto;
	}

	public OpcionDTO getEstado() {
		return estado;
	}

	public void setEstado(OpcionDTO estado) {
		this.estado = estado;
	}

	public OpcionDTO getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(OpcionDTO medioPago) {
		this.medioPago = medioPago;
	}

	public SocioDTO getSocio() {
		return socioDTO;
	}

	public void setSocio(SocioDTO socioDTO) {
		this.socioDTO = socioDTO;
	}

	public UsuarioDTO getUsuarioAprobacion() {
		return usuarioAprobacion;
	}

	public void setUsuarioAprobacion(UsuarioDTO usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}

	public UsuarioDTO getUsuarioCreacion() {
		return usuarioCreacion;
	}

	public void setUsuarioCreacion(UsuarioDTO usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	@Override
	public String toString() {
		return "MovimientoSocioDTO [id=" + id + ", fechaPago=" + fechaPago + ", monto=" + monto + ", concepto=" + concepto
				+ ", estado=" + estado + ", medioPago=" + medioPago + ", socioDTO=" + socioDTO + ", tipoMovimientoDTO="
				+ tipoMovimientoDTO + ", usuarioAprobacion=" + usuarioAprobacion + ", usuarioCreacion=" + usuarioCreacion
				+ "]";
	}

}
