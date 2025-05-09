package py.edu.ucsa.coope.dev.core.entities;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import py.edu.ucsa.coope.dev.web.dto.DepartamentoDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;


/**
 * The persistent class for the departamentos database table.
 * 
 */
@Entity
@Table(name="departamentos")
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="fecha_hora_creacion")
	private Timestamp fechaAlta;

	@Column(name="fecha_hora_ult_modif")
	private Timestamp fechaModificacion;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@JsonBackReference
	@OneToMany(mappedBy="departamento")
	private List<Ciudad> ciudades;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to UsuarioDto
	@ManyToOne
	@JoinColumn(name="id_usuario_ult_modif")
	private Usuario usuarioModificacion;

	public Departamento() {
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

	public List<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
/*
	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setDepartamento(this);

		return ciudade;
	}
	*/

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setDepartamento(null);

		return ciudade;
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

	public static Departamento fromDto(DepartamentoDto dto) {
		Departamento entity = new Departamento();
		BeanUtils.copyProperties(dto, entity);
		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		return entity;
	}

	public DepartamentoDto toDto() {
		DepartamentoDto dto = new DepartamentoDto();
		BeanUtils.copyProperties(this, dto);
		
		BaseDataCopier.copyBaseDataToDto(this, dto);
		
		return dto;
	}

}