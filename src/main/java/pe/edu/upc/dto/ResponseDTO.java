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
public class ResponseDTO {
	private int status;
	private String message;
	private List<CategoryDTO> categories;
	private List<ProductDTO> products;
	private ClientDTO client;
	private AdministratorDTO administrator;
	private List<BoxDTO> boxes;
	private BoxDTO box;
}
