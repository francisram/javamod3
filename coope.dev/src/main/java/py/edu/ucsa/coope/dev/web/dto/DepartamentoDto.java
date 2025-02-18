package py.edu.ucsa.coope.dev.web.dto;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DepartamentoDto {
	private Integer id;
	private String nombre;

}
