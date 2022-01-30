package pe.edu.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.dto.BoxCreateDTO;
import pe.edu.upc.dto.BoxDTO;
import pe.edu.upc.dto.BoxUpdateDTO;
import pe.edu.upc.dto.ResponseDTO;
import pe.edu.upc.dto.SaveDefaultBoxDTO;
import pe.edu.upc.service.BoxService;

@CrossOrigin
@RestController
@RequestMapping(path = "/boxes")
public class BoxController {

	@Autowired
	private BoxService boxService;

	@GetMapping(path = "/listById", produces = "application/json")
	public ResponseEntity<?> listSavedBoxes(@RequestParam int idBox) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			BoxDTO boxDTO = boxService.listById(idBox);
			if (boxDTO == null) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultado");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Box encontrado");
				respuestaDTO.setBox(boxDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listSavedBoxes", produces = "application/json")
	public ResponseEntity<?> listSavedBoxes(@RequestParam String email) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<BoxDTO> boxesDTO = boxService.listByClientsUserLoginEmail(email);
			if (boxesDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Boxes encontrados");
				respuestaDTO.setBoxes(boxesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listSavedBoxesByName", produces = "application/json")
	public ResponseEntity<?> listSavedBoxes(@RequestParam String email, @RequestParam String name) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<BoxDTO> boxesDTO = boxService.listByPersonalizedAndNameAndClientsUserLoginEmail(true, name, email);
			if (boxesDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Boxes encontrados");
				respuestaDTO.setBoxes(boxesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listDefault", produces = "application/json")
	public ResponseEntity<?> listDefault() {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<BoxDTO> boxesDTO = boxService.listByPersonalized(false);
			if (boxesDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Boxes encontrados");
				respuestaDTO.setBoxes(boxesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listDefaultByName", produces = "application/json")
	public ResponseEntity<?> listDefaultAndName(@RequestParam String name) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<BoxDTO> boxesDTO = boxService.listByPersonalizedAndName(false, name);
			if (boxesDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Boxes encontrados");
				respuestaDTO.setBoxes(boxesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listDefaultByPriceMinAndPriceMax", produces = "application/json")
	public ResponseEntity<?> listDefaultAndPriceMinAndPriceMax(@RequestParam double priceMin,
			@RequestParam double priceMax) {
		ResponseDTO respuestaDTO = new ResponseDTO();

		List<BoxDTO> boxesDTO = boxService.listByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(false,
				priceMin, priceMax);
		if (boxesDTO.size() == 0) {
			respuestaDTO.setStatus(0);
			respuestaDTO.setMessage("Sin resultados");
		} else {
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Boxes encontrados");
			respuestaDTO.setBoxes(boxesDTO);
		}

		return ResponseEntity.ok(respuestaDTO);
	}

	@GetMapping(path = "/listDefaultByNameAndPriceMinAndPriceMax", produces = "application/json")
	public ResponseEntity<?> listDefaultAndNameAndPriceMinAndPriceMax(@RequestParam String name,
			@RequestParam double priceMin, @RequestParam double priceMax) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			List<BoxDTO> boxesDTO = boxService.listByPersonalizedAndNameAndPriceGreaterThanEqualAndPriceLessThanEqual(
					false, name, priceMin, priceMax);
			if (boxesDTO.size() == 0) {
				respuestaDTO.setStatus(0);
				respuestaDTO.setMessage("Sin resultados");
			} else {
				respuestaDTO.setStatus(1);
				respuestaDTO.setMessage("Boxes encontrados");
				respuestaDTO.setBoxes(boxesDTO);
			}
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}
		return ResponseEntity.ok(respuestaDTO);
	}

	@PostMapping(path = "/createPersonalized", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createPersonalized(@RequestBody BoxCreateDTO boxCreateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			BoxDTO boxDTO = boxService.createPersonalized(boxCreateDTO);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Creación exitosa");
			respuestaDTO.setBox(boxDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}

		return ResponseEntity.ok(respuestaDTO);
	}

	@PostMapping(path = "/createDefault", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createDeafult(@RequestBody BoxCreateDTO boxCreateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			BoxDTO boxDTO = boxService.createDefault(boxCreateDTO);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Creación exitosa");
			respuestaDTO.setBox(boxDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}

		return ResponseEntity.ok(respuestaDTO);
	}

	@PutMapping(path = "/saveDefaultBox", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> saveDefaultBox(@RequestBody SaveDefaultBoxDTO saveDefaultBoxDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			BoxDTO boxDTO = boxService.saveDefaultBox(saveDefaultBoxDTO);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Asociación exitosa");
			respuestaDTO.setBox(boxDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}

		return ResponseEntity.ok(respuestaDTO);
	}

	@PutMapping(path = "/updateBoxPersonalized", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> updateBoxPersonalized(@RequestBody BoxUpdateDTO boxUpdateDTO) {
		ResponseDTO respuestaDTO = new ResponseDTO();
		try {
			BoxDTO boxDTO = boxService.update(boxUpdateDTO);
			respuestaDTO.setStatus(1);
			respuestaDTO.setMessage("Actualización exitosa");
			respuestaDTO.setBox(boxDTO);
		} catch (Exception e) {
			respuestaDTO.setStatus(-2);
			respuestaDTO.setMessage("Error en el servidor");
		}

		return ResponseEntity.ok(respuestaDTO);
	}
}
