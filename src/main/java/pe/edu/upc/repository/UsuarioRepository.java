package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
