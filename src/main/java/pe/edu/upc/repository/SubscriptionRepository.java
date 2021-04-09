package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	List<Subscription> findByClientUserLoginEmail(String email);
	List<Subscription> findByDeliveryDate(String deliveryDate);
	List<Subscription> findByDeliveryDateAndClientUserLoginEmailContainingIgnoreCase(String deliveryDate, String email);
}