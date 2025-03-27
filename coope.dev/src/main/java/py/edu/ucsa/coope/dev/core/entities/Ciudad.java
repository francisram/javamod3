package py.edu.ucsa.coope.dev.core.entities;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;

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
import py.edu.ucsa.coope.dev.web.dto.CiudadDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;


/**
 * The persistent class for the ciudades database table.
 * 
 */
@Entity
@Table(name="ciudades")
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
@NamedQuery(name="Ciudad.getCiudadesByDepto", query="SELECT c FROM Ciudad c WHERE c.departamento.id =:idDepartamento")
public class Ciudad implements BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_alta")
	private Timestamp fechaAlta;

	@Column(name="fecha_modificacion")
	private Timestamp fechaModificacion;

	private String nombre;

	//bi-directional many-to-one association to Barrio
	@JsonBackReference
	@OneToMany(mappedBy="ciudad")
	private List<Barrio> barrios;

	//bi-directional many-to-one association to Departamento
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//uni-directional many-to-one association to UsuarioDto
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_alta")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to UsuarioDto
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_modificacion")
	private Usuario usuarioModificacion;

	public Ciudad() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Barrio> getBarrios() {
		return this.barrios;
	}

	public void setBarrios(List<Barrio> barrios) {
		this.barrios = barrios;
	}

	public Barrio addBarrio(Barrio barrio) {
		getBarrios().add(barrio);
		barrio.setCiudad(this);

		return barrio;
	}

	public Barrio removeBarrio(Barrio barrio) {
		getBarrios().remove(barrio);
		barrio.setCiudad(null);

		return barrio;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
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

	public CiudadDto toDto() {
		CiudadDto dto = new CiudadDto();
		BeanUtils.copyProperties(this, dto);
		if(this.getDepartamento() != null) {
			dto.setDepartamento(this.getDepartamento().toDto());
		}
		return dto;
	}
	
	public static Ciudad fromDto(CiudadDto dto) {
		Ciudad entity = new Ciudad();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getDepartamento() != null) {
			entity.setDepartamento(Departamento.fromDto(dto.getDepartamento()));
		}
		return entity;
	}

}