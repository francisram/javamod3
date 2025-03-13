package py.edu.ucsa.coope.dev.core.services;

import py.edu.ucsa.coope.dev.web.dto.UsuarioDto;

public interface UsuarioServices extends GenericService<Integer, UsuarioDto> {
  public void eliminar(Integer id);
}
