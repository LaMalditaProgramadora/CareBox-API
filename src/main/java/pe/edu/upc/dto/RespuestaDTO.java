package pe.edu.upc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RespuestaDTO {
	private int estado;
	private String mensaje;
	private List<CategoriaDTO> categorias;
	private List<ProductoDTO> productos;
}
