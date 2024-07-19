package py.edu.ucsa.ejb.dto;

import java.io.Serializable;

public class JugadorDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private int nroFicha;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	private String email;
	private EquipoDTO equipo;

	public EquipoDTO getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoDTO equipoDTO) {
		this.equipo = equipoDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getNroFicha() {
		return nroFicha;
	}

	public void setNroFicha(int nroFicha) {
		this.nroFicha = nroFicha;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "JugadorDTO [id=" + id + ", nroFicha=" + nroFicha + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", nacionalidad=" + nacionalidad + ", telefono=" + telefono
				+ ", email=" + email + ", equipo=" + equipo + "]";
	}

	public JugadorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
