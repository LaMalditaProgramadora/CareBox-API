package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
