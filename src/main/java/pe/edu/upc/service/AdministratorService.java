package pe.edu.upc.service;

import pe.edu.upc.dto.AdministratorDTO;
import pe.edu.upc.dto.AdministratorRegisterDTO;
import pe.edu.upc.dto.AdministratorUpdateDTO;

public interface AdministratorService {
	AdministratorDTO listByEmail(String email);
	int validateLogin(String email, String password);
	int register(AdministratorRegisterDTO administratorRegisterDTO);
	int update(AdministratorUpdateDTO administratorUpdateDTO);
}
