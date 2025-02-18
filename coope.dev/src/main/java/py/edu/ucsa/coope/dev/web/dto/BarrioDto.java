package py.edu.ucsa.coope.dev.web.dto;

import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import py.edu.ucsa.coope.dev.core.entities.Ciudad;
import py.edu.ucsa.coope.dev.core.entities.Socio;
import py.edu.ucsa.coope.dev.core.entities.Usuario;

@Data
public class BarrioDto {

	private Integer id;
	private String nombre;
	private CiudadDto ciudad;

}
