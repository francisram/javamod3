package py.edu.ucsa.ejb.dto;

public class DominioDTO {
 private Integer id;
 private String codigo;
 private String descripcion;
 private String estado;
 private DominioDTO dominioPadre;
 
 
 
 
public DominioDTO() {
	super();
}
public DominioDTO(Integer id) {
	super();
	this.id = id;
}
@Override
public String toString() {
	return "DominioDTO [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
			+ ", dominioPadre=" + dominioPadre + "]";
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
public DominioDTO getDominioPadre() {
	return dominioPadre;
}
public void setDominioPadre(DominioDTO dominioPadre) {
	this.dominioPadre = dominioPadre;
}

	
}
