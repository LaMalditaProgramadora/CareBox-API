package pe.edu.upc.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.dto.ClientDTO;
import pe.edu.upc.dto.ClientRegisterDTO;
import pe.edu.upc.dto.ClientUpdateDTO;
import pe.edu.upc.model.Client;
import pe.edu.upc.model.UserLogin;
import pe.edu.upc.repository.ClientRepository;
import pe.edu.upc.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public ClientDTO listByEmail(String email) {
		Client client = clientRepository.findByUserLoginEmail(email);
		if (client == null)
			return null;
		else
			return modelMapper.map(client, ClientDTO.class);
	}

	@Override
	public int validateLogin(String email, String password) {
		Client client = clientRepository.findByUserLoginEmail(email);
		if (client == null)
			return 0;
		else if (!client.getUserLogin().getPassword().equals(password))
			return -1;
		else
			return 1;
	}

	@Transactional
	@Override
	public int register(ClientRegisterDTO clientRegisterDTO) {
		if (clientRepository.findByUserLoginEmail(clientRegisterDTO.getEmail()) == null) {
			Client client = new Client();
			UserLogin userLogin = new UserLogin();
			userLogin.setEmail(clientRegisterDTO.getEmail());
			userLogin.setPassword(clientRegisterDTO.getPassword());
			client = modelMapper.map(clientRegisterDTO, Client.class);
			client.setUserLogin(userLogin);
			clientRepository.save(client);
			return 1;
		} else
			return 0;
	}

	@Transactional
	@Override
	public int update(ClientUpdateDTO clientUpdateDTO) {
		Client client = clientRepository.findByUserLoginEmail(clientUpdateDTO.getEmail());
		if (client != null) {
			client.setAddress(clientUpdateDTO.getAddress());
			client.setLastNames(clientUpdateDTO.getLastNames());
			client.setNames(clientUpdateDTO.getNames());
			client.setPhone(clientUpdateDTO.getPhone());
			clientRepository.save(client);
			return 1;
		} else
			return 0;
	}

}
