package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorRegisterDTO {

	private String email;
	private String password;
	private String names;
	private String lastNames;
	private String phone;
}
