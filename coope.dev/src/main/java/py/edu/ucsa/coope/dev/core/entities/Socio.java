package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


/**
 * The persistent class for the socios database table.
 * 
 */
@Entity
@Table(name="socios")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String apellido;

	private String direccion;

	private String email;

	@Column(name="fecha_alta")
	private Timestamp fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	@Column(name="numero_documento")
	private String numeroDocumento;

	private String telefono;

	//bi-directional many-to-one association to CajaAhorro
	@OneToMany(mappedBy="socio")
	private List<CajaAhorro> cajaAhorros;

	//bi-directional many-to-one association to Prestamo
	@JsonBackReference
	@OneToMany(mappedBy="socio")
	private List<Prestamo> prestamos;

	//bi-directional many-to-one association to Barrio
	@ManyToOne
	@JoinColumn(name="id_barrio")
	private Barrio barrio;

	//uni-directional many-to-one association to EstadoCivil
	@ManyToOne
	@JoinColumn(name="estado_civil")
	private EstadoCivil estadoCivil;

	//uni-directional many-to-one association to Sexo
	@ManyToOne
	@JoinColumn(name="sexo")
	private Sexo sexo;

	//uni-directional many-to-one association to TipoDocumento
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="tipo_documento")
	private TipoDocumento tipoDocumento;

	//uni-directional many-to-one association to Usuario
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_alta")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to Usuario
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_modificacion")
	private Usuario usuarioModificacion;

	public Socio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<CajaAhorro> getCajaAhorros() {
		return this.cajaAhorros;
	}

	public void setCajaAhorros(List<CajaAhorro> cajaAhorros) {
		this.cajaAhorros = cajaAhorros;
	}

	public CajaAhorro addCajaAhorro(CajaAhorro cajaAhorro) {
		getCajaAhorros().add(cajaAhorro);
		cajaAhorro.setSocio(this);

		return cajaAhorro;
	}

	public CajaAhorro removeCajaAhorro(CajaAhorro cajaAhorro) {
		getCajaAhorros().remove(cajaAhorro);
		cajaAhorro.setSocio(null);

		return cajaAhorro;
	}

	public List<Prestamo> getPrestamos() {
		return this.prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Prestamo addPrestamo(Prestamo prestamo) {
		getPrestamos().add(prestamo);
		prestamo.setSocio(this);

		return prestamo;
	}

	public Prestamo removePrestamo(Prestamo prestamo) {
		getPrestamos().remove(prestamo);
		prestamo.setSocio(null);

		return prestamo;
	}

	public Barrio getBarrio() {
		return this.barrio;
	}

	public void setBarrio(Barrio barrio) {
		this.barrio = barrio;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Sexo getSexo() {
		return this.sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
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