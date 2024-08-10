package py.edu.ucsa.ejb.entities;

import java.io.Serializable;
import java.util.Objects;

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
import py.edu.ucsa.ejb.dto.DominioDTO;

@Entity
@Table(name = "dominios")
@NamedQuery(name = "Dominio.findAll", query = "SELECT c FROM Dominio c ORDER BY c.codigo ASC")
public class Dominio implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "codigo", nullable = true, unique = true)
	private String codigo;
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	@Column(name = "estado" , nullable = true)
	private String estado;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dominio_padre" , nullable = true)
	private Dominio dominioPadre;
	
	public static Dominio ofDTO(DominioDTO dto) {
		Dominio dominio = new Dominio();
		if(!Objects.isNull(dto.getCodigo())) {
			dominio.setCodigo(dto.getCodigo());			
		}
		if(!Objects.isNull(dto.getDescripcion())) {
			dominio.setDescripcion(dto.getDescripcion());			
		}
		if(!Objects.isNull(dto.getDominioPadre())) {
			dominio.setDominioPadre(Dominio.ofDTO(dto.getDominioPadre()));			
		}
		if(!Objects.isNull(dto.getEstado())) {
			dominio.setEstado(dto.getEstado());			
		}
		if(!Objects.isNull(dto.getId())) {
			dominio.setId(dto.getId());			
		}
		return dominio;
	}
	
	public DominioDTO toDTO() {
		DominioDTO dominio = new DominioDTO();
		if(!Objects.isNull(this.getCodigo())) {
			dominio.setCodigo(this.getCodigo());
		}
		if(!Objects.isNull(this.getDescripcion())) {
			dominio.setDescripcion(this.getDescripcion());			
		}
		if(!Objects.isNull(this.getDominioPadre())) {
			dominio.setDominioPadre(this.getDominioPadre().toDTO());			
		}
		if(!Objects.isNull(this.getEstado())) {
			dominio.setEstado(this.getEstado());			
		}
		if(!Objects.isNull(this.getId())) {
			dominio.setId(this.getId());			
		}
		return dominio;
	}

	public Dominio() {
		super();
	}

	public Dominio(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Dominio getDominioPadre() {
		return dominioPadre;
	}

	public void setDominioPadre(Dominio dominioPadre) {
		this.dominioPadre = dominioPadre;
	}

	
	
	@Override
	public String toString() {
	    return "Dominio [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
	            + ", dominioPadre=" + (dominioPadre != null ? dominioPadre.getId() : "null") + "]";
	}


}
