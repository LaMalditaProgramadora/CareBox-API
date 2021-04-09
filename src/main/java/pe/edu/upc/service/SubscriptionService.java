package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.dto.SubscriptionCreateDTO;
import pe.edu.upc.dto.SubscriptionDTO;

public interface SubscriptionService {
	SubscriptionDTO create(SubscriptionCreateDTO subscriptionCreateDTO);
	SubscriptionDTO cancel(int idSubscription);
	List<SubscriptionDTO> listByEmail(String email);
	List<SubscriptionDTO> listTodaySubscription();
	void montlyUpdate();
	List<SubscriptionDTO> listTodaySubscriptionByEmail(String email);
	void updateDeliveredThisMonth(int idSubscription, boolean deliveredThisMonth);
}
