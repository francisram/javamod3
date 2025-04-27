package py.edu.ucsa.coope.dev.web.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.ucsa.coope.dev.web.security.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	Optional<Usuario> findByUsuario(String usuario);
}
