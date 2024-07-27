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
@Table(name = "menus")
@NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m ORDER BY m.columnaMenu ASC")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "columna_menu", nullable = true)
	private String columnaMenu;
	@Column(name = "estado", nullable = true)
	private String estado;
	@Column(name = "icono", nullable = true)
	private String icono;
	@Column(name = "nombre", nullable = true)
	private String nombre;
	@Column(name = "tipo_menu", nullable = true)
	private String tipoMenu;
	@Column(name = "tipo_usuario", nullable = true)
	private String tipoUsuario;
	@Column(name = "vista", nullable = true)
	private String vista;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_menu_id" )
	private Menu subMenu;
	
	
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", columnaMenu=" + columnaMenu + ", estado=" + estado + ", icono=" + icono
				+ ", nombre=" + nombre + ", tipoMenu=" + tipoMenu + ", tipoUsuario=" + tipoUsuario + ", vista=" + vista
				+ ", subMenu=" + subMenu + "]";
	}
	
	

	public Menu getSubMenu() {
		return subMenu;
	}



	public void setSubMenu(Menu subMenu) {
		this.subMenu = subMenu;
	}



	public Long getId() {
		return id;
	}



	public String getColumnaMenu() {
		return columnaMenu;
	}
	public void setColumnaMenu(String columnaMenu) {
		this.columnaMenu = columnaMenu;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipoMenu() {
		return tipoMenu;
	}
	public void setTipoMenu(String tipoMenu) {
		this.tipoMenu = tipoMenu;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	

}
