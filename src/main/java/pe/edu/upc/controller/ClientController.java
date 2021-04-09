package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.ClientDTO;
import pe.edu.upc.dto.ClientUpdateDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping(path = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping(path = "/listByEmail", produces = "application/json")
	public ResponseEntity<?> listByEmail(@RequestParam String email) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			ClientDTO clientDTO = clientService.listByEmail(email);
			if (clientDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Cliente encontrado");
				respuestaDTO.setClient(clientDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@PutMapping(path = "/updateProfile", produces = "application/json")
	public ResponseEntity<?> updateProfile(@RequestBody ClientUpdateDTO clientUpdateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			int result = clientService.update(clientUpdateDTO);
			if (result == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Cliente no encontrado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Actualización exitosa");
				respuestaDTO.setClient(clientService.listByEmail(clientUpdateDTO.getEmail()));
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
