package py.edu.ucsa.coope.dev.web.validators;

import java.util.List;

import py.edu.ucsa.coope.dev.web.dto.ErrorDto;


/**
 * Interface que será implementada por aquellas clases que necesitan ser validadas
 * @author pablo
 *
 * @param <T> Tipo del validador
 */
public interface Validable<T> {
	/**
	 * Se encargará de recorrer los validadores agregados al objeto Validable 
	 * y ejecutará el método validar de cada uno de dichos validadores
	 * @return Lista con errores generados por la valid
* @return Lista con errores generados por la validación
	 */
	List<ErrorDto> ejecutarValidadores();
	
	/**
	 * Método que se encargará de agregar validador/es a la lista de 
	 * validadores que debe existir en el objeto validable 
	 * @param v Validador a ser agregado
	 */
	void agregarValidador(Validador<T> v);
}