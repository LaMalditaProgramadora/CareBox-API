package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.dto.BoxCreateDTO;
import pe.edu.upc.dto.BoxDTO;
import pe.edu.upc.dto.BoxUpdateDTO;
import pe.edu.upc.dto.SaveDefaultBoxDTO;

public interface BoxService {
	List<BoxDTO> listByPersonalized(boolean personalized);
	List<BoxDTO> listByClientsUserLoginEmail(String email);
	List<BoxDTO> listByPersonalizedAndName(boolean personalized, String name);
	List<BoxDTO> listByPersonalizedAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, float priceMin, float priceMax);
	List<BoxDTO> listByPersonalizedAndNameAndPriceGreaterThanEqualAndPriceLessThanEqual(boolean personalized, String name, float priceMin, float priceMax);
	BoxDTO createPersonalized(BoxCreateDTO boxCreateDTO);
	BoxDTO createDefault(BoxCreateDTO boxCreateDTO);
	BoxDTO saveDefaultBox(SaveDefaultBoxDTO saveDefaultBoxDTO);
	BoxDTO update(BoxUpdateDTO boxUpdateDTO);
}
