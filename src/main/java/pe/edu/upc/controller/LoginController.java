package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.AdministratorRegisterDTO;
import pe.edu.upc.dto.ClientRegisterDTO;
import pe.edu.upc.dto.LoginDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.service.AdministratorService;
import pe.edu.upc.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping(path = "/login")
public class LoginController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AdministratorService administratorService;

	@PostMapping(path = "/clientLogin", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> clientLogin(@RequestBody LoginDTO loginDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = clientService.validateLogin(loginDTO.getEmail(), loginDTO.getPassword());
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Correo electrónico incorrecto");
			} else if (result == -1) {
				respuestaDTO.setStatus(-1);
				respuestaDTO.setMessage("Contraseña incorrecta");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Login exitoso");
				respuestaDTO.setClient(clientService.listByEmail(loginDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@PostMapping(path = "/administratorLogin", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> administratorLogin(@RequestBody LoginDTO loginDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = administratorService.validateLogin(loginDTO.getEmail(), loginDTO.getPassword());
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Correo electrónico incorrecto");
			} else if (result == -1) {
				respuestaDTO.setStatus(-1);
				respuestaDTO.setMessage("Contraseña incorrecta");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Login exitoso");
				respuestaDTO.setAdministrator(administratorService.listByEmail(loginDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
	
	@PostMapping(path = "/clientRegister", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> clientRegister(@RequestBody ClientRegisterDTO clientRegisterDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = clientService.register(clientRegisterDTO);
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Correo electrónico ya registrado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Registro exitoso");
				respuestaDTO.setClient(clientService.listByEmail(clientRegisterDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
	
	@PostMapping(path = "/administratorRegister", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> administratorRegister(@RequestBody AdministratorRegisterDTO administratorRegisterDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = administratorService.register(administratorRegisterDTO);
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Correo electrónico ya registrado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Registro exitoso");
				respuestaDTO.setAdministrator(administratorService.listByEmail(administratorRegisterDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
