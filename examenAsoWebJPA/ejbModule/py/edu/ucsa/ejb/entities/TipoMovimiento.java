package py.edu.ucsa.ejb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiposmovimientos")
@NamedQuery(name = "TipoMovimiento.findAll", query = "SELECT t FROM TipoMovimiento t ORDER BY t.codigo ASC")
public class TipoMovimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String codigo;
    private String descripcion;
    private String estado;
    private String tipoDebCred;
    
    
    
       
    
    
	public TipoMovimiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TipoMovimiento [id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", estado=" + estado
				+ ", tipoDebCred=" + tipoDebCred + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getTipoDebCred() {
		return tipoDebCred;
	}
	public void setTipoDebCred(String tipoDebCred) {
		this.tipoDebCred = tipoDebCred;
	}
    
    

}
