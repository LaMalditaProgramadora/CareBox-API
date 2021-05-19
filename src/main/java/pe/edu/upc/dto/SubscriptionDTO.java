package pe.edu.upc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {

	private int idSubscription;
	private String deliveryDate;
	private boolean deliveredThisMonth;
	private int deliveries;
	private String adress;
	private float price;
	private BoxDTO box;
	private ClientDTO client;
}
