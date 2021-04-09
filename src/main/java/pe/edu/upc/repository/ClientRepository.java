package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{
	Client findByUserLoginEmail(String email);
}
