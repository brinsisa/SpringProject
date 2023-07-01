package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Client;
import tn.esprit.elife.persistance.interfaces.ClientRepository;
import tn.esprit.elife.services.Interfaces.IClientService;
@Service
@Slf4j
public class ClientService implements IClientService {
@Autowired
ClientRepository clientRep;
	@Override
	public List<Client> retrieveAllClients() {
		
		return (List<Client>) clientRep.findAll();
		
	}

	@Override
	public Client addClient(Client c) {
		log.info("debut de l'execution de la methode addClient");
		clientRep.save(c);
		log.info("fin de l'execution de la methode addClient");
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		
		log.info("début d'execution de la méthode deleteClient");
		clientRep.deleteById(id);
		log.info("début d'execution de la méthode deleteClient");
		
	}

	@Override
	public Client updateClient(Client c) {
		log.info("début d'execution de la méthode updateClient");
		clientRep.save(c);
		log.info("début d'execution de la méthode updateClient");
		return c;
	}

	@Override
	public Client retrieveClient(Long id) {
		return clientRep.findById(id).get();
		
	}

}
