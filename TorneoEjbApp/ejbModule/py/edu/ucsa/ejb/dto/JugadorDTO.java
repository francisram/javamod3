package py.edu.ucsa.ejb.dto;



public class JugadorDTO {

	private Long id;

	private String nombres;

	private String apellidos;

	private String fechaNacimiento;

	private int numeroFicha;

	private String nacionalidad;

	private String telefono;

	private String email;

	private EquipoDTO equipoDTO;

	public EquipoDTO getEquipo() {
		return equipoDTO;
	}

	public void setEquipo(EquipoDTO equipoDTO) {
		this.equipoDTO = equipoDTO;
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

	public int getNumeroFicha() {
		return numeroFicha;
	}

	public void setNumeroFicha(int numeroFicha) {
		this.numeroFicha = numeroFicha;
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
		return "JugadorDTO [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", numeroFicha=" + numeroFicha + ", nacionalidad=" + nacionalidad + ", telefono="
				+ telefono + ", email=" + email + ", equipoDTO=" + equipoDTO + "]";
	}

	public JugadorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
