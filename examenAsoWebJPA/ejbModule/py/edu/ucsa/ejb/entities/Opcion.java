package py.edu.ucsa.ejb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "opciones")
@NamedQuery(name = "Opcion.findAll", query = "SELECT o FROM Opcion o ORDER BY o.codigo ASC")

public class Opcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private String descripcion;
	private String estado;
	private Dominio dominio;
	private Opcion padre;
	
	
	

	
	
	
	public Opcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Opcion [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", dominio=" + dominio + ", padre=" + padre + "]";
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
