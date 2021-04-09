package pe.edu.upc.service;

import pe.edu.upc.dto.ClientDTO;
import pe.edu.upc.dto.ClientRegisterDTO;
import pe.edu.upc.dto.ClientUpdateDTO;

public interface ClientService {
	ClientDTO listByEmail(String email);
	int validateLogin(String email, String password);
	int register(ClientRegisterDTO clientRegisterDTO);
	int update(ClientUpdateDTO clientUpdateDTO);
}
