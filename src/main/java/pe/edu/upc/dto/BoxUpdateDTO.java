package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoxUpdateDTO {

	private int idBox;
	private String email;
	private String name;
	private int[] idProducts;

}
