package fr.insee.bar.service;

import fr.insee.bar.dao.ClientDao;
import fr.insee.bar.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

	@Autowired
	private ClientDao clientDao;

	public List<Client> clients() {
		return clientDao.findAll();
	}
}
