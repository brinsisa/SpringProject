package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Client;

public interface IClientService {
	
	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Long id);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

}
