package py.edu.ucsa.coope.dev.web.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DepartamentoDto extends BaseDto  {
	private Integer id;
	private String nombre;

}
