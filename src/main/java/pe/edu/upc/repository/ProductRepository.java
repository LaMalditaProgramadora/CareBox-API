package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategoryIdCategory(int idCategory);
	List<Product> findByNameContainingIgnoreCase(String name);
	List<Product> findByCategoryIdCategoryAndNameContainingIgnoreCase(int idCategory, String name);
}
