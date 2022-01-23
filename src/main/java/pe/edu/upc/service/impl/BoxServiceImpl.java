package pe.edu.upc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.BoxCreateDTO;
import pe.edu.upc.dto.BoxDTO;
import pe.edu.upc.dto.BoxUpdateDTO;
import pe.edu.upc.dto.SaveDefaultBoxDTO;
import pe.edu.upc.model.Box;
import pe.edu.upc.model.Client;
import pe.edu.upc.model.Product;
import pe.edu.upc.repository.BoxRepository;
import pe.edu.upc.repository.ClientRepository;
import pe.edu.upc.repository.ProductRepository;
import pe.edu.upc.service.BoxService;

@Service
public class BoxServiceImpl implements BoxService {

	@Autowired
	private BoxRepository boxRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ClientRepository clientRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<BoxDTO> listByPersonalized(boolean personalized) {
		List<Box> boxes = boxRepository.findByPersonalized(personalized);
		return boxes.stream().map(box -> modelMapper.map(box, BoxDTO.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<BoxDTO> listByClientsUserLoginEmail(String email) {
		List<Box> boxes = boxRepository.findByClientsUserLoginEmail(email);
		return boxes.stream().map(box -> modelMapper.map(box, BoxDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<BoxDTO> listByPersonalizedAndName(boolean personalized, String name) {
		List<Box> boxes = boxRepository.findByPersonalized(personalized);
		return boxes.stream().map(box -> modelMapper.map(box, BoxDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<BoxDTO> listByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized,
			double priceMin, double priceMax) {
		List<Box> boxes = boxRepository.findByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(personalized,
				priceMin, priceMax);
		return boxes.stream().map(box -> modelMapper.map(box, BoxDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<BoxDTO> listByPersonalizedAndNameAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized,
			String name, double priceMin, double priceMax) {
		List<Box> boxes = boxRepository.findByPersonalizedAndNameAndPriceGreaterThanEqualAndPriceLessThanEqual(
				personalized, name, priceMin, priceMax);
		return boxes.stream().map(box -> modelMapper.map(box, BoxDTO.class)).collect(Collectors.toList());
	}

	@Transactional
	@Override
	public BoxDTO createPersonalized(BoxCreateDTO boxCreateDTO) {
		Box box = new Box();
		box.setName(boxCreateDTO.getName());
		box.setPrice(boxCreateDTO.getPrice());
		box.setPersonalized(true);
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		for (int idProduct : boxCreateDTO.getIdProducts()) {
			product = new Product();
			product = productRepository.findById(idProduct).get();
			products.add(product);
		}
		box.setProducts(products);
		boxRepository.save(box);
		Client client = clientRepository.findByUserLoginEmail(boxCreateDTO.getEmail());
		List<Box> savedBoxes = client.getSavedBoxes();
		savedBoxes.add(box);
		client.setSavedBoxes(savedBoxes);
		clientRepository.save(client);
		return modelMapper.map(box, BoxDTO.class);
	}

	@Transactional
	@Override
	public BoxDTO createDefault(BoxCreateDTO boxCreateDTO) {
		Box box = new Box();
		box.setName(boxCreateDTO.getName());
		box.setPrice(boxCreateDTO.getPrice());
		box.setPersonalized(false);
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		for (int idProduct : boxCreateDTO.getIdProducts()) {
			product = new Product();
			product = productRepository.findById(idProduct).get();
			products.add(product);
		}
		box.setProducts(products);
		boxRepository.save(box);
		return modelMapper.map(box, BoxDTO.class);
	}

	@Transactional
	@Override
	public BoxDTO saveDefaultBox(SaveDefaultBoxDTO saveDefaultBoxDTO) {
		Box box = boxRepository.findById(saveDefaultBoxDTO.getIdBox()).get();
		Client client = clientRepository.findByUserLoginEmail(saveDefaultBoxDTO.getEmail());
		List<Box> savedBoxes = client.getSavedBoxes();
		savedBoxes.add(box);
		client.setSavedBoxes(savedBoxes);
		clientRepository.save(client);
		return modelMapper.map(box, BoxDTO.class);
	}

	@Override
	public BoxDTO update(BoxUpdateDTO boxUpdateDTO) {
		Box box = boxRepository.findById(boxUpdateDTO.getIdBox()).get();
		box.setName(boxUpdateDTO.getName());
		box.setPrice(boxUpdateDTO.getPrice());
		List<Product> products = new ArrayList<Product>();
		Product product = new Product();
		for (int idProduct : boxUpdateDTO.getIdProducts()) {
			product = new Product();
			product = productRepository.findById(idProduct).get();
			products.add(product);
		}
		box.setProducts(products);
		boxRepository.save(box);
		return modelMapper.map(box, BoxDTO.class);
	}

}
