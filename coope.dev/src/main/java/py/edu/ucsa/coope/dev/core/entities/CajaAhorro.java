package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;


/**
 * The persistent class for the caja_ahorro database table.
 * 
 */
@Entity
@Table(name="caja_ahorro")
@NamedQuery(name="CajaAhorro.findAll", query="SELECT c FROM CajaAhorro c")
public class CajaAhorro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_hora_creacion")
	private Timestamp fechaAlta;

	@Column(name="fecha_hora_ult_modif")
	private Timestamp fechaModificacion;

	private BigDecimal saldo;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="id_socio")
	private Socio socio;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_ult_modif")
	private Usuario usuarioModificacion;

	//bi-directional many-to-one association to ExtractoCaja
	@OneToMany(mappedBy="cajaAhorro")
	private List<ExtractoCaja> extractosCajas;

	public CajaAhorro() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public BigDecimal getSaldo() {
		return this.saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
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

	public List<ExtractoCaja> getExtractosCajas() {
		return this.extractosCajas;
	}

	public void setExtractosCajas(List<ExtractoCaja> extractosCajas) {
		this.extractosCajas = extractosCajas;
	}

	public ExtractoCaja addExtractosCaja(ExtractoCaja extractosCaja) {
		getExtractosCajas().add(extractosCaja);
		extractosCaja.setCajaAhorro(this);

		return extractosCaja;
	}

	public ExtractoCaja removeExtractosCaja(ExtractoCaja extractosCaja) {
		getExtractosCajas().remove(extractosCaja);
		extractosCaja.setCajaAhorro(null);

		return extractosCaja;
	}

}