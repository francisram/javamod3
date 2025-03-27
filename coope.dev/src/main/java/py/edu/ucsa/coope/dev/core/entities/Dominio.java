package py.edu.ucsa.coope.dev.core.entities;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import py.edu.ucsa.coope.dev.web.dto.usuarios.DominioDto;



/**
 * The persistent class for the dominios database table.
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="dominios", schema = "munisys")
@NamedQuery(name="Dominio.findAll", query="SELECT d FROM Dominio d")
public class Dominio implements Serializable {
	private static final long serialVersionUID = 844145437183003457L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String descripcion;

	private String estado;

	//uni-directional many-to-one association to Dominio
	@ManyToOne
	@JoinColumn(name="id_dominio_padre")
	@JsonBackReference
	private Dominio dominioPadre;

	
	/*se agrega para copiar propiedades */
	public DominioDto toDto() {
		DominioDto dto = new DominioDto();
		BeanUtils.copyProperties(this, dto);
		
		if (this.dominioPadre != null) {
			dto.setDominioPadre(this.dominioPadre.toDto());
		}
		return dto;
	}
	
	public static Dominio fromDto(DominioDto dto) {
		Dominio d = new Dominio();
		BeanUtils.copyProperties(dto, d);
		if (dto.getDominioPadre() != null)
			d.setDominioPadre(fromDto(dto.getDominioPadre()));
		return d;
	}

/*
	public static Dominio fromDTOwithModelMap(DominioDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		Dominio d = modelMapper.map(dto, Dominio.class);
		return d;
	}
	*/
}