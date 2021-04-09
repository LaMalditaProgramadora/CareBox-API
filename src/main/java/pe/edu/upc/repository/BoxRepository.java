package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
	List<Box> findByPersonalized(boolean personalized);
	List<Box> findByClientsUserLoginEmail(String email);
	List<Box> findByPersonalizedAndName(boolean personalized, String name);
	List<Box> findByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, float priceMin, float priceMax);
	List<Box> findByPersonalizedAndNameAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, String name, float priceMin, float priceMax);
}
