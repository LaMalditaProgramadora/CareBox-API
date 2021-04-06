package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
