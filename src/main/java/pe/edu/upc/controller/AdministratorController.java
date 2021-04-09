package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.AdministratorUpdateDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.service.AdministratorService;

@CrossOrigin
@RestController
@RequestMapping(path = "/administrators")
public class AdministratorController {
	
	@Autowired
	private AdministratorService administratorService;
	
	@PutMapping(path = "/updateProfile", produces = "application/json")
	public ResponseEntity<?> updateProfile(@RequestBody AdministratorUpdateDTO administratorUpdateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = administratorService.update(administratorUpdateDTO);
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Administrador no encontrado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Actualización exitosa");
				respuestaDTO.setAdministrator(administratorService.listByEmail(administratorUpdateDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
