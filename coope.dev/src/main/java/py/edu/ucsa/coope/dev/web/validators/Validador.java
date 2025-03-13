package py.edu.ucsa.coope.dev.web.validators;

import java.util.List;

import py.edu.ucsa.coope.dev.web.dto.ErrorDto;



/**
 * Interface que será implementada por las clases validadoras, 
 * que se encargarán de realizar algún tipo de validación
 * @author pablo
 *
 * @param <T>
 */
public interface Validador<T> {
/**
	 * Método que será utilizado para realizar la validación en sí sobre
	 * el objeto que recibe como parámetro
	 * @param obj Objeto a ser validado
	 * @return Lista de errores que pueda surgir a partir de la validación
	 */
	List<ErrorDto> validar(T obj);
}