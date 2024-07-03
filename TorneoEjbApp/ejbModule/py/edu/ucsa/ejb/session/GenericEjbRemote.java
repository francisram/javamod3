package py.edu.ucsa.ejb.session;

import java.io.Serializable;
import java.util.List;

public interface GenericEjbRemote< PK extends Serializable ,T> {
	
	public List<T> findAll() throws Exception;
	
	public void insert(T dto) throws Exception;

	public List<T> listar();

	public T getById(Long id);

	public T insertar(T obj);

	public void actualizar(T obj);

	public void eliminar(Long id);
}
