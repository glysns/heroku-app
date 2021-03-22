package digytal.java.exemplos.herokuapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import digytal.java.exemplos.herokuapp.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
}
