package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

public class OpcionDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String codigo;
	private String descripcion;
	private String estado;
	private DominioDTO dominioDTO;
	private OpcionDTO padre;
	
	
	

	
	
	
	public OpcionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "OpcionDTO [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", dominioDTO=" + dominioDTO + ", padre=" + padre + "]";
	}

	public OpcionDTO(Integer id) {
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

	public DominioDTO getDominio() {
		return dominioDTO;
	}

	public void setDominio(DominioDTO dominioPadre) {
		this.dominioDTO = dominioPadre;
	}

	public OpcionDTO getPadre() {
		return padre;
	}

	public void setPadre(OpcionDTO padre) {
		this.padre = padre;
	}
}
