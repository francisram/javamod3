package py.edu.ucsa.coope.dev.web.dto;


import java.time.LocalDateTime;
import lombok.Data;


@Data
public class BarrioDto extends BaseDto {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private CiudadDto ciudad;

}
