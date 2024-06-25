package py.edu.ucsa.ejb.session;

import java.util.List;

public interface GenericEjbRemote<T> {

	public List<T> listar();

	public T getById(Integer id);

	public T insertar(T obj);

	public void actualizar(T obj);

	public void eliminar(Integer id);
}
