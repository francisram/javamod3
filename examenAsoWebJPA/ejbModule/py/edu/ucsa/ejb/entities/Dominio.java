package py.edu.ucsa.ejb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dominios")
@NamedQuery(name = "DominioDTO.findAll", query = "SELECT c FROM DominioDTO c ORDER BY c.codigo ASC")
public class Dominio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "codigo", nullable = true, unique = true)
	private String codigo;
	@Column(name = "descripcion", nullable = true)
	private String descripcion;
	@Column(name = "estado" , nullable = true)
	private String estado;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dominios_id" , nullable = true)
	private Dominio dominioPadre;

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
		return "DominioDTO [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", dominioPadre=" + dominioPadre + "]";
	}

}
