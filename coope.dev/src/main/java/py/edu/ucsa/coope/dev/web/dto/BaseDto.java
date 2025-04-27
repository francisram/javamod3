package py.edu.ucsa.coope.dev.web.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto implements Serializable {


	private static final long serialVersionUID = 3192435694803666889L;
	private UsuarioDto usuarioAlta;
	private UsuarioDto usuarioModificacion;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime fechaAlta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime fechaModificacion;

}
