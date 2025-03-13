package py.edu.ucsa.coope.dev.web.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permiso {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
    CATASTRO_READ("catastro:read"),
    CATASTRO_UPDATE("catastro:update"),
    CATASTRO_CREATE("catastro:create"),
    CATASTRO_DELETE("catastro:delete")

    ;

    @Getter
    private final String permiso;
}
