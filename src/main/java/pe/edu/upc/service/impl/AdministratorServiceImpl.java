package pe.edu.upc.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.AdministratorDTO;
import pe.edu.upc.dto.AdministratorRegisterDTO;
import pe.edu.upc.dto.AdministratorUpdateDTO;
import pe.edu.upc.model.Administrator;
import pe.edu.upc.model.UserLogin;
import pe.edu.upc.repository.AdministratorRepository;
import pe.edu.upc.service.AdministratorService;

@Service
public class AdministratorServiceImpl implements AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public AdministratorDTO listByEmail(String email) {
		Administrator administrator = administratorRepository.findByUserLoginEmail(email);
		if (administrator == null)
			return null;
		else
			return modelMapper.map(administrator, AdministratorDTO.class);
	}

	@Override
	public int validateLogin(String email, String password) {
		Administrator administrator = administratorRepository.findByUserLoginEmail(email);
		if (administrator == null)
			return 0;
		else if (!administrator.getUserLogin().getPassword().equals(password))
			return -1;
		else
			return 1;
	}

	@Transactional
	@Override
	public int register(AdministratorRegisterDTO administratorRegisterDTO) {
		if (administratorRepository.findByUserLoginEmail(administratorRegisterDTO.getEmail()) == null) {
			Administrator administrator = new Administrator();
			UserLogin userLogin = new UserLogin();
			userLogin.setEmail(administratorRegisterDTO.getEmail());
			userLogin.setPassword(administratorRegisterDTO.getPassword());
			administrator = modelMapper.map(administratorRegisterDTO, Administrator.class);
			administrator.setUserLogin(userLogin);
			administratorRepository.save(administrator);
			return 1;
		} else
			return 0;
	}

	@Transactional
	@Override
	public int update(AdministratorUpdateDTO administratorUpdateDTO) {
		Administrator administrator = administratorRepository.findByUserLoginEmail(administratorUpdateDTO.getEmail());
		if (administrator != null) {
			administrator.setLastNames(administratorUpdateDTO.getLastNames());
			administrator.setNames(administratorUpdateDTO.getNames());
			administrator.setPhone(administratorUpdateDTO.getPhone());
			administratorRepository.save(administrator);
			return 1;
		} else
			return 0;
	}

}
