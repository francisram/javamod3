package py.edu.ucsa.coope.dev.core.services;

import py.edu.ucsa.coope.dev.web.dto.usuarios.UsuarioDto;

public interface UsuarioService extends GenericService<Integer, UsuarioDto> {
  public void eliminar(Integer id);
}
