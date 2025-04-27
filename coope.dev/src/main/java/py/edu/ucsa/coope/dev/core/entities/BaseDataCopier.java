package py.edu.ucsa.coope.dev.core.entities;

import java.sql.Timestamp;
import java.util.Objects;

import py.edu.ucsa.coope.dev.web.dto.BaseDto;
import py.edu.ucsa.coope.dev.web.security.entities.Usuario;



public abstract class BaseDataCopier {

	public static void copyBaseDataToDto(BaseEntity entityOrigen, BaseDto dtoDestino) {
		if(Objects.nonNull(entityOrigen.getFechaAlta())){
			dtoDestino.setFechaAlta(entityOrigen.getFechaAlta().toLocalDateTime());
		}
		if(Objects.nonNull(entityOrigen.getFechaModificacion())){
			dtoDestino.setFechaModificacion(entityOrigen.getFechaModificacion().toLocalDateTime());
}

		if(Objects.nonNull(entityOrigen.getUsuarioAlta())){
			dtoDestino.setUsuarioAlta(entityOrigen.getUsuarioAlta().toDto());
		}
		if(Objects.nonNull(entityOrigen.getUsuarioModificacion())){
			dtoDestino.setUsuarioModificacion(entityOrigen.getUsuarioModificacion().toDto());
		}
	}
	public static void copyBaseDataFromDtoToEntity(BaseDto dtoOrigen, BaseEntity entityDestino) {
		if(Objects.nonNull(dtoOrigen.getFechaAlta())){
			entityDestino.setFechaAlta(Timestamp.valueOf(dtoOrigen.getFechaAlta()));
		}
		if(Objects.nonNull(dtoOrigen.getFechaModificacion())){
			entityDestino.setFechaModificacion(Timestamp.valueOf(dtoOrigen.getFechaModificacion()));
		}
		
		if(Objects.nonNull(dtoOrigen.getUsuarioAlta())){
			entityDestino.setUsuarioAlta(Usuario.fromDto(dtoOrigen.getUsuarioAlta()));
		}
		if(Objects.nonNull(dtoOrigen.getUsuarioModificacion())){
			entityDestino.setUsuarioModificacion(Usuario.fromDto(dtoOrigen.getUsuarioModificacion()));
		}
	}
		
}
