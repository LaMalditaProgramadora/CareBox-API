package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findByCategoriaIdCategoria(int idCategoria);
	List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
