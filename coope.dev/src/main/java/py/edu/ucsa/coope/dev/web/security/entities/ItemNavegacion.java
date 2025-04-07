package py.edu.ucsa.coope.dev.web.security.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.web.dto.usuarios.ItemNavegacionDto;


/**
 * The persistent class for the usu_items_navegacion database table.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_items_navegacion", schema = "usu_usuarios")
@NamedQuery(name = "ItemNavegacion.findAll", query = "SELECT i FROM ItemNavegacion i")
@NamedQuery(name = "ItemNavegacion.getByTitulo", query = "SELECT i FROM ItemNavegacion i WHERE i.title = :titulo")
@NamedQuery(name = "ItemNavegacion.getById", query = "SELECT i FROM ItemNavegacion i WHERE i.id = :id")
public class ItemNavegacion implements Serializable, BaseEntity {

	private static final long serialVersionUID = 5307990771257681308L;

	@Id
	private String id;

	@Column(name = "fecha_alta")
	private Timestamp fechaAlta;

	@Column(name = "fecha_modificacion")
	private Timestamp fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_alta")
	private Usuario usuarioAlta;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_modificacion")
	private Usuario usuarioModificacion;

	@Column(name = "titulo")
	private String title;
	
	@Column(name = "sub_titulo")
	private String subtitle;
	
	@Column(name = "tipo")
	private String type;
	
	@Column(name = "oculto")
	private Boolean hidden;
	
	@Column(name = "activo")
	private Boolean active;
	
	@Column(name = "deshabilitado")
	private Boolean disabled;
	
	@Column(name = "tooltip")
	private String tooltip;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "target")
	private String target;
	
	@Column(name = "badge_titulo")
	private String badgeTitle;
	
	@Column(name = "badge_classes")
	private String badgeClasses;
	
	@Column(name = "icono")
	private String icon;

	@Column(name = "id_padre")
	private String idPadre;
	
	public ItemNavegacion(String id, String title) {
		super();
		this.id = id;
		this.title = title;
	}	



	public ItemNavegacionDto toDto() {
		ItemNavegacionDto dto = new ItemNavegacionDto();
		BeanUtils.copyProperties(this, dto);

		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}



	public static ItemNavegacion fromDto(ItemNavegacionDto dto) {
		ItemNavegacion entity = new ItemNavegacion();
		BeanUtils.copyProperties(dto, entity);

		BaseDataCopier.copyBaseDataFromDtoToEntity(dto, entity);
		return entity;
	}

}
