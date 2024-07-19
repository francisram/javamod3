package py.edu.ucsa.ejb.dao;

import java.util.List;

public interface GenericDao<T> {
List<T> listar();
T getById(Integer  id);
T insertar(T objecto);
T modificar(T objecto);
void eliminar(T objecto);

}
