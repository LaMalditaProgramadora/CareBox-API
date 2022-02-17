package pe.edu.upc.service.impl;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.SubscriptionCreateDTO;
import pe.edu.upc.dto.SubscriptionDTO;
import pe.edu.upc.model.Box;
import pe.edu.upc.model.Client;
import pe.edu.upc.model.Subscription;
import pe.edu.upc.repository.BoxRepository;
import pe.edu.upc.repository.ClientRepository;
import pe.edu.upc.repository.SubscriptionRepository;
import pe.edu.upc.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;
	@Autowired
	private BoxRepository boxRepository;
	@Autowired
	private ClientRepository clientRepository;
	ModelMapper modelMapper = new ModelMapper();
	private double shippingFee = 0.05;

	@Override
	public SubscriptionDTO create(SubscriptionCreateDTO subscriptionCreateDTO) throws ParseException {
		Box box = boxRepository.findById(subscriptionCreateDTO.getIdBox()).get();
		Client client = clientRepository.findByUserLoginEmail(subscriptionCreateDTO.getEmail());
		Subscription subscription = new Subscription();
		subscription.setAddress(client.getAddress());
		double price = box.getPrice() + shippingFee * box.getPrice();
		DecimalFormat df = new DecimalFormat("#.##");
		subscription.setPrice(Double.valueOf(df.format(price)));
		subscription.setDeliveryDate(addDay(subscriptionCreateDTO.getDeliveryDate()));
		subscription.setDeliveredThisMonth(false);
		subscription.setDeliveries(0);
		subscription.setBox(box);
		subscription.setClient(client);
		subscriptionRepository.save(subscription);
		return modelMapper.map(subscription, SubscriptionDTO.class);
	}

	@Override
	public SubscriptionDTO cancel(int idSubscription) {
		Subscription subscription = subscriptionRepository.findById(idSubscription).get();
		subscriptionRepository.deleteById(idSubscription);
		return modelMapper.map(subscription, SubscriptionDTO.class);
	}

	@Override
	public List<SubscriptionDTO> listByEmail(String email) {
		List<Subscription> subscriptions = subscriptionRepository.findByClientUserLoginEmail(email);
		return subscriptions.stream().map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<SubscriptionDTO> listTodaySubscription() {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(date);
		List<Subscription> subscriptions = subscriptionRepository.findByDeliveryDate(strDate);
		return subscriptions.stream().map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<SubscriptionDTO> listTodaySubscriptionByEmail(String email) {
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String strDate = dateFormat.format(date);
		List<Subscription> subscriptions = subscriptionRepository
				.findByDeliveryDateAndClientUserLoginEmailContainingIgnoreCase(strDate, email);
		return subscriptions.stream().map(subscription -> modelMapper.map(subscription, SubscriptionDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void updateDeliveredThisMonth(int idSubscription, boolean deliveredThisMonth) throws ParseException {
		Subscription subscription = subscriptionRepository.findById(idSubscription).get();
		subscription.setDeliveredThisMonth(deliveredThisMonth);
		subscription.setDeliveryDate(addMonth(subscription.getDeliveryDate()));
		subscriptionRepository.save(subscription);
	}

	private String addMonth(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date dateAux = dateFormat.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateAux);
		cal.add(Calendar.MONTH, 1);
		Date dateAsObjAfterAMonth = cal.getTime();
		return dateFormat.format(dateAsObjAfterAMonth);
	}
	
	private String addDay(String date) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date dateAux = dateFormat.parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateAux);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date dateAsObjAfterAMonth = cal.getTime();
		return dateFormat.format(dateAsObjAfterAMonth);
	}

}
