package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;
import java.sql.Timestamp;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.OpcionDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;



/**
 * The persistent class for the opciones database table.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "opciones")
@NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o")
@NamedQuery(name = "Opcion.getOpcionesByCodDominio", query = "SELECT o FROM Opcion o where o.dominio.codigo = :codDominio ")
@NamedQuery(name = "Opcion.getOpcionByCodDominioAndCodOpcion", query = "SELECT o FROM Opcion o WHERE o.dominio.codigo = :codDominio AND o.codigo = :codOpcion")
public class Opcion implements Serializable, BaseEntity {

	private static final long serialVersionUID = 8684304265164236620L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_hora_creacion")
	private Timestamp fechaAlta;

	@Column(name = "fecha_hora_ult_modif")
	private Timestamp fechaModificacion;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_usuario_creacion")
	private Usuario usuarioAlta;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_usuario_ult_modif")
	private Usuario usuarioModificacion;

	private String codigo;

	private String descripcion;

	private String estado;

	@Column(name = "por_defecto")
	private Boolean porDefecto;

	private String icono;

	@ManyToOne
	@JoinColumn(name = "id_dominio")
	private Dominio dominio;

	@ManyToOne
	@JoinColumn(name = "id_opcion_padre")
	@JsonBackReference
	private Opcion opcionPadre;

	@Column(name = "orden_preferido")
	private Integer ordenPreferido;

	public OpcionDto toDto() {// public OpcionDTO fromOpcionToDTO() {
		OpcionDto dto = new OpcionDto();
		BeanUtils.copyProperties(this, dto);
		dto.setId(this.getId());
		if (this.getDominio() != null) {
			dto.setDominio(this.getDominio().toDto());
		}
		if (this.getOpcionPadre() != null) {
			dto.setOpcionPadre(this.getOpcionPadre().toDto());
		}
		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}

	public static Opcion fromDto(OpcionDto dto) {// public static Opcion fromDTO(OpcionDTO dto)
		Opcion entity = new Opcion();
		BeanUtils.copyProperties(dto, entity);
		if (dto.getDominio() != null) {
			entity.setDominio(Dominio.fromDto(dto.getDominio()));
		}
		if (dto.getOpcionPadre() != null) {
			entity.setOpcionPadre(Opcion.fromDto(dto.getOpcionPadre()));
		}
		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		return entity;
	}
	/*
	 * public static Opcion fromDTOwithModelMapper(OpcionDTO dto) { ModelMapper
	 * modelMapper = new ModelMapper(); Opcion opcionEntity = modelMapper.map(dto,
	 * Opcion.class); return opcionEntity; }
	 */

}