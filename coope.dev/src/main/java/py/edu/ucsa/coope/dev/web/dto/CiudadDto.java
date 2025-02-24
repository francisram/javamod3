package py.edu.ucsa.coope.dev.web.dto;

import lombok.Data;

@Data
public class CiudadDto extends BaseDto  {
	private Integer id;
	private String nombre;
	private DepartamentoDto departamento;

}
