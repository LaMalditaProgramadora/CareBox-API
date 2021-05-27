package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.dto.SubscriptionCreateDTO;
import pe.edu.upc.dto.SubscriptionDTO;
import pe.edu.upc.dto.SuscriptionUpdateDTO;
import pe.edu.upc.service.SubscriptionService;

@CrossOrigin
@RestController
@RequestMapping(path = "/subscriptions")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody SubscriptionCreateDTO subscriptionCreateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			SubscriptionDTO subscriptionDTO = subscriptionService.create(subscriptionCreateDTO);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Creación exitosa");
			respuestaDTO.setSubscription(subscriptionDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@DeleteMapping(path = "/cancel", produces = "application/json")
	public ResponseEntity<?> cancel(@RequestParam int idSubscription) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			SubscriptionDTO subscriptionDTO = subscriptionService.cancel(idSubscription);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Suscripción cancelada");
			respuestaDTO.setSubscription(subscriptionDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listByEmail", produces = "application/json")
	public ResponseEntity<?> listByEmail(@RequestParam String email) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<SubscriptionDTO> subscriptionsDTO = subscriptionService.listByEmail(email);
			if (subscriptionsDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Subscripciones encontradas");
				respuestaDTO.setSubscriptions(subscriptionsDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listTodaySubscription", produces = "application/json")
	public ResponseEntity<?> listTodaySubscription() {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<SubscriptionDTO> subscriptionsDTO = subscriptionService.listTodaySubscription();
			if (subscriptionsDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Subscripciones encontradas");
				respuestaDTO.setSubscriptions(subscriptionsDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listTodaySubscriptionByEmail", produces = "application/json")
	public ResponseEntity<?> listTodaySubscriptionByEmail(@RequestParam String email) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<SubscriptionDTO> subscriptionsDTO = subscriptionService.listTodaySubscriptionByEmail(email);
			if (subscriptionsDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Subscripciones encontradas");
				respuestaDTO.setSubscriptions(subscriptionsDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@PutMapping(path = "/montlyUpdate", produces = "application/json")
	public ResponseEntity<?> montlyUpdate() {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			subscriptionService.montlyUpdate();
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Actualización exitosa");
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
	
	@PutMapping(path = "/updateDeliveredThisMonth", produces = "application/json")
	public ResponseEntity<?> updateDeliveredThisMonth(@RequestBody SuscriptionUpdateDTO suscriptionUpdateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			subscriptionService.updateDeliveredThisMonth(suscriptionUpdateDTO.getIdSubscription(), suscriptionUpdateDTO.isDeliveredThisMonth());
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Actualización exitosa");
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}
}
