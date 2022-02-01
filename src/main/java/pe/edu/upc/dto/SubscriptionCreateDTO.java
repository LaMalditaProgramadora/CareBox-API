package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionCreateDTO {
	private CardDetailsDTO cardDetails;
	private String email;
	private String deliveryDate;
	private String address;
	private int idBox;
	
}
