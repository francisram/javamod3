package py.edu.ucsa.coope.dev.core.services;

import java.util.List;

import py.edu.ucsa.coope.dev.web.dto.PaginadoDto;

public interface GenericService <PK,T>{
List<T> listar();
PaginadoDto<T> listar(int pagina ,int tamanhoPagina,String ordenarPor , String orden , String busqueda);
T getById(PK id);
T persistir (T entity);
T actualizar(T entity);
void eliminar(T entity);

}
