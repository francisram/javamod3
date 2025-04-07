package py.edu.ucsa.coope.dev.web.security.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.web.dto.usuarios.PerfilDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_perfiles", schema = "usu_usuarios")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
@NamedQuery(name = "Perfil.getByCodigo", query = "SELECT i FROM Perfil i WHERE i.codigo = :codigo")
@NamedQuery(name = "Perfil.getByEstado", query = "SELECT i FROM Perfil i WHERE i.estado.codigo = :codEstado")
public class Perfil implements Serializable, BaseEntity {
	
	private static final long serialVersionUID = -5940974995128562743L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_hora_creacion")
	private Timestamp fechaHoraCreacion;

	@Column(name = "fecha_hora_ult_modif")
	private Timestamp fechaHoraUltModif;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_creacion")
	private Usuario usuarioCreacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario_ult_modif")
	private Usuario usuarioUltModif;
	
	@ManyToOne(targetEntity = Opcion.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado")
	private Opcion estado;

	private String codigo;
	private String nombre;
	private String descripcion;
	
	public PerfilDto toDto() {// public OpcionDTO fromOpcionToDTO() {
		PerfilDto dto = new PerfilDto();
		BeanUtils.copyProperties(this, dto);
		dto.setId(this.getId());
		if (this.getEstado() != null) {
			dto.setEstado(this.getEstado().toDto());
		}
		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}

	public static Perfil fromDto(PerfilDto dto) {// public static Opcion fromDTO(OpcionDTO dto)
		Perfil entity = new Perfil();
		BeanUtils.copyProperties(dto, entity);
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

	@Override
	public Timestamp getFechaModificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFechaModificacion(Timestamp fechaModificacion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuarioAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsuarioAlta(Usuario usuarioAlta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getUsuarioModificacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUsuarioModificacion(Usuario usuarioModificacion) {
		// TODO Auto-generated method stub
		
	}
	
	
}
