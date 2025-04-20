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
import py.edu.ucsa.coope.dev.core.entities.Usuario;
import py.edu.ucsa.coope.dev.web.dto.usuarios.PerfilXUsuarioDto;


/**
 * The persistent class for the usu_perfiles_x_usuario database table.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usu_perfiles_x_usuario", schema = "usuarios")
@NamedQuery(name = "PerfilXUsuario.findAll", query = "SELECT u FROM PerfilXUsuario u")
public class PerfilXUsuario implements Serializable, BaseEntity {

	private static final long serialVersionUID = 4457389547022614207L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_hora_creacion")
	private Timestamp fechaHoraCreacion;
	
	@Column(name = "fecha_hora_ult_modif")
	private Timestamp fechaHoraUltModif;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_creacion")
	private Usuario usuarioCreacion;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario_ult_modif")
	private Usuario usuarioUltModif;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Opcion estado;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public PerfilXUsuarioDto toDto() {
		PerfilXUsuarioDto dto = new PerfilXUsuarioDto();
		BeanUtils.copyProperties(this, dto);

		if (this.getUsuario() != null) {
			dto.setUsuario(this.getUsuario().toDto());
		}
		if (this.getPerfil() != null) {
			dto.setPerfil(this.getPerfil().toDto());
		}
		if (this.getEstado() != null) {
			dto.setEstado(this.getEstado().toDto());
		}
		BaseDataCopier.copyBaseDataToDto(this, dto);
		return dto;
	}

	public static PerfilXUsuario fromDto(PerfilXUsuarioDto dto) {
		PerfilXUsuario entity = new PerfilXUsuario();
		BeanUtils.copyProperties(dto, entity);

		if (dto.getUsuario() != null) {
			entity.setUsuario(Usuario.fromDto(dto.getUsuario()));
		}
		if (dto.getPerfil() != null) {
			entity.setPerfil(Perfil.fromDto(dto.getPerfil()));
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