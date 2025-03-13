package py.edu.ucsa.coope.dev.web.security;

import static py.edu.ucsa.coope.dev.web.security.Permiso.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Rol {

  USER(Collections.emptySet()),
  ADMIN(
          Set.of(
                  ADMIN_READ,
                  ADMIN_UPDATE,
                  ADMIN_DELETE,
                  ADMIN_CREATE,
                  MANAGER_READ,
                  MANAGER_UPDATE,
                  MANAGER_DELETE,
                  MANAGER_CREATE
          )
  ),
  MANAGER(
          Set.of(
                  MANAGER_READ,
                  MANAGER_UPDATE,
                  MANAGER_DELETE,
                  MANAGER_CREATE
          )
  ),
  CATASTRO(
          Set.of(
                  CATASTRO_READ,
                  CATASTRO_UPDATE,
                  CATASTRO_DELETE,
                  CATASTRO_CREATE
          )
  );

  @Getter
  private final Set<Permiso> permisos;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermisos()
            .stream()
            .map(permiso -> new SimpleGrantedAuthority(permiso.getPermiso()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
