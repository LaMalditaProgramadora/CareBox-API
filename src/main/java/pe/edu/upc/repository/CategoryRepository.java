package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
