package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
	List<Box> findByPersonalized(boolean personalized);
	List<Box> findByClientsUserLoginEmail(String email);
	List<Box> findByPersonalizedAndNameContainingIgnoreCaseAndClientsUserLoginEmail(boolean personalized, String name,String email);
	List<Box> findByPersonalizedAndNameContainingIgnoreCase(boolean personalized, String name);
	List<Box> findByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, double priceMin, double priceMax);
	List<Box> findByPersonalizedAndNameContainingIgnoreCaseAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, String name, double priceMin, double priceMax);
}
