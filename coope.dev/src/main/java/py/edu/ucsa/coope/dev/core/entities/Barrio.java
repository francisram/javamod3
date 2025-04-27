package py.edu.ucsa.coope.dev.core.entities;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
import py.edu.ucsa.coope.dev.web.dto.BarrioDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;

/**
 * The persistent class for the barrios database table.
 * 
 */
@Entity
@Table(name="barrios")
@NamedQuery(name="Barrio.findAll", query="SELECT b FROM Barrio b")
@NamedQuery(name="Barrio.getBarriosByIdCiudad", query="SELECT b FROM Barrio b WHERE b.ciudad = :idCiudad ")
public class Barrio implements BaseEntity {
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
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//uni-directional many-to-one association to Usuario
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_usuario_creacion")
	private Usuario usuarioAlta;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario_ult_modif")
	private Usuario usuarioModificacion;

	//bi-directional many-to-one association to Socio
	@JsonIgnore
	@OneToMany(mappedBy="barrio")
	private List<Socio> socios;

	public Barrio() {
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

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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

	public List<Socio> getSocios() {
		return this.socios;
	}

	public void setSocios(List<Socio> socios) {
		this.socios = socios;
	}

	public Socio addSocio(Socio socio) {
		getSocios().add(socio);
		socio.setBarrio(this);

		return socio;
	}

	public Socio removeSocio(Socio socio) {
		getSocios().remove(socio);
		socio.setBarrio(null);

		return socio;
	}

	public BarrioDto toDto() {
		BarrioDto dto = new BarrioDto();
		BeanUtils.copyProperties(this, dto);
		if(this.getCiudad() != null) {
			dto.setCiudad(this.getCiudad().toDto());
		}
		
		BaseDataCopier.copyBaseDataToDto(this, dto);
		
		return dto;
	}
	
	public static Barrio fromDto(BarrioDto dto) {
		Barrio entity = new Barrio();
		BeanUtils.copyProperties(dto,entity);
		if(dto.getCiudad() != null) {
			entity.setCiudad(Ciudad.fromDto(dto.getCiudad()));
		}
		
		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		
		return entity;
	}
}