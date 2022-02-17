package pe.edu.upc.service;

import java.text.ParseException;
import java.util.List;

import pe.edu.upc.dto.SubscriptionCreateDTO;
import pe.edu.upc.dto.SubscriptionDTO;

public interface SubscriptionService {
	SubscriptionDTO create(SubscriptionCreateDTO subscriptionCreateDTO) throws ParseException;
	SubscriptionDTO cancel(int idSubscription);
	List<SubscriptionDTO> listByEmail(String email);
	List<SubscriptionDTO> listTodaySubscription();
	List<SubscriptionDTO> listSubscription();
	List<SubscriptionDTO> listTodaySubscriptionByEmail(String email);
	void updateDeliveredThisMonth(int idSubscription, boolean deliveredThisMonth) throws ParseException;
}
