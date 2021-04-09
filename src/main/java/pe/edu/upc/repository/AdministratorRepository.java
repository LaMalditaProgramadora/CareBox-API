package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
	Administrator findByUserLoginEmail(String email);
}
