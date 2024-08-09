package py.edu.ucsa.ejb.entities;

import java.io.Serializable;

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
		dominio.setCodigo(dto.getCodigo());
		dominio.setDescripcion(dto.getDescripcion());
		dominio.setDominioPadre(Dominio.ofDTO(dto.getDominioPadre()));
		dominio.setEstado(dto.getEstado());
		dominio.setId(dto.getId());
		return dominio;
	}
	
	public DominioDTO toDTO() {
		DominioDTO dominio = new DominioDTO();
		dominio.setCodigo(this.getCodigo());
		dominio.setDescripcion(this.getDescripcion());
		dominio.setDominioPadre(this.getDominioPadre().toDTO());
		dominio.setEstado(this.getEstado());
		dominio.setId(this.getId());
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
