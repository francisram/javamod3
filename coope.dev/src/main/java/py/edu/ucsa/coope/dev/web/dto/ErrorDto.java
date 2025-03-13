package py.edu.ucsa.coope.dev.web.dto;

public class ErrorDto {
	private String mensajeError;

	public ErrorDto(String mensajeError) {
		super();
		this.mensajeError = mensajeError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

}