package py.edu.ucsa.coope.dev.web.security.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;

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
import py.edu.ucsa.coope.dev.core.entities.BaseDataCopier;
import py.edu.ucsa.coope.dev.core.entities.BaseEntity;
import py.edu.ucsa.coope.dev.core.entities.Opcion;
import py.edu.ucsa.coope.dev.web.dto.usuarios.OperacionesXItemNavegacionDto;


/**
 * The persistent class for the usu_operaciones_x_item_nav database table.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_operaciones_x_item_nav", schema = "usuarios")
@NamedQuery(name = "OperacionesXItemNavegacion.findAll", query = "SELECT u FROM OperacionesXItemNavegacion u")
public class OperacionesXItemNavegacion implements Serializable, BaseEntity {

	private static final long serialVersionUID = 4457389547022614207L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_hora_modificacion")
	private Timestamp fecha_hora_creacion;
	
	@Column(name = "fecha_hora_ult_modif")
	private Timestamp fechaModificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_creacion")
	private Usuario usuarioAlta;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_ult_modif")
	private Usuario usuarioModificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Opcion estado;

	@ManyToOne
	@JoinColumn(name = "id_accion")
	private Opcion accion;

	@ManyToOne
	@JoinColumn(name = "id_item_navegacion")
	private ItemNavegacion itemNavegacion;
	
	public OperacionesXItemNavegacion(Long id, Opcion estado, Opcion accion, ItemNavegacion itemNavegacion) {
		super();
		this.id = id;
		this.estado = estado;
		this.accion = accion;
		this.itemNavegacion = itemNavegacion;
	}

	public OperacionesXItemNavegacionDto toDto() {
		OperacionesXItemNavegacionDto dto = new OperacionesXItemNavegacionDto();
		BeanUtils.copyProperties(this, dto);

		if (this.getItemNavegacion() != null) {
			dto.setItemNavegacion(this.getItemNavegacion().toDto());
		}
		if (this.getAccion() != null) {
			dto.setAccion(this.getAccion().toDto());
		}
		if (this.getEstado() != null) {
			dto.setEstado(this.getEstado().toDto());
		}
		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}

	public static OperacionesXItemNavegacion fromDto(OperacionesXItemNavegacionDto dto) {
		OperacionesXItemNavegacion entity = new OperacionesXItemNavegacion();
		BeanUtils.copyProperties(dto, entity);

		if (dto.getItemNavegacion() != null) {
			entity.setItemNavegacion(ItemNavegacion.fromDto(dto.getItemNavegacion()));
		}
		if (dto.getAccion() != null) {
			entity.setAccion(Opcion.fromDto(dto.getAccion()));
		}
		if (dto.getEstado() != null) {
			entity.setEstado(Opcion.fromDto(dto.getEstado()));
		}
		
		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		return entity;
	}

	@Override
	public Timestamp getFechaAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaAlta(Timestamp fechaAlta) {
		// TODO Auto-generated method stub
		
	}
}