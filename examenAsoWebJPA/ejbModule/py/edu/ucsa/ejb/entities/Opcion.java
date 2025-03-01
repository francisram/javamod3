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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import py.edu.ucsa.ejb.dto.DominioDTO;
import py.edu.ucsa.ejb.dto.OpcionDTO;

@Entity
@Table(name = "opciones")
@NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o ORDER BY o.codigo ASC")
@NamedQuery(name = "Opcion.getOpcionByDominioCodOpcion",
	    	query = "SELECT o, d.codigo as codDominio, d.descripcion as descDominio,padre.codigo as codOpcionPadre, padre.descripcion as descOpcionPadre "
	    			+ "FROM Opcion o JOIN o.dominio d LEFT JOIN o.padre padre "
	    			+ "WHERE d.codigo = :dominio and o.codigo = :opcion")
@NamedQuery(name = "Opcion.getOpcionByDominio",query = "SELECT o FROM Opcion o JOIN o.dominio d JOIN o.padre p WHERE o.dominio = :dominio")


public class Opcion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "codigo",  nullable = true)
	private String codigo;
	@Column(name = "descripcion",  nullable = true)
	private String descripcion;
	@Column(name = "estado",  nullable = true)
	private String estado;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_dominio" , nullable = true)
	private Dominio dominio;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_opcion_padre" , nullable = true)
	private Opcion padre;
	
	
	public static Opcion ofDTO(OpcionDTO dto) {
		Opcion opcion = new Opcion();
		if(!Objects.isNull(dto.getCodigo())) {
			opcion.setCodigo(dto.getCodigo());			
		}
		opcion.setDescripcion(dto.getDescripcion());
		if(!Objects.isNull(dto.getDominio())) {
			opcion.setDominio(Dominio.ofDTO(dto.getDominio()));			
		}
		opcion.setEstado(dto.getEstado());
		if(!Objects.isNull(dto.getId())) {
			opcion.setId(dto.getId());			
		}
		if(!Objects.isNull(dto.getPadre())) {
			opcion.setPadre(Opcion.ofDTO(dto.getPadre()));			
		}
		return opcion;
	}
	
	public OpcionDTO toDTO() {
		OpcionDTO opcion = new OpcionDTO();
		opcion.setCodigo(this.getCodigo());
		opcion.setDescripcion(this.getDescripcion());
		if(!Objects.isNull(this.getDominio())) {
			opcion.setDominio(this.getDominio().toDTO());			
		}
		if(!Objects.isNull(this.getEstado())) {
			opcion.setEstado(this.getEstado());			
		}
		opcion.setId(this.getId());
		if(!Objects.isNull(this.getPadre())) {
			opcion.setPadre(this.getPadre().toDTO());			
		}
		return opcion;
	}

	
	
	
	public Opcion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
	    return "Opcion [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion 
	           + ", estado=" + estado 
	           + ", dominio=" + (dominio != null ? dominio.getId() : null) 
	           + ", padre=" + (padre != null ? padre.getId() : null) + "]";
	}

	public Opcion(Integer id) {
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

	public Dominio getDominio() {
		return dominio;
	}

	public void setDominio(Dominio dominioPadre) {
		this.dominio = dominioPadre;
	}

	public Opcion getPadre() {
		return padre;
	}

	public void setPadre(Opcion padre) {
		this.padre = padre;
	}
}
