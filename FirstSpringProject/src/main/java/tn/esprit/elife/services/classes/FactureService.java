package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Facture;
import tn.esprit.elife.persistance.interfaces.FactureRepository;
import tn.esprit.elife.services.Interfaces.IFactureService;
@Service
@Slf4j
public class FactureService implements IFactureService{
	@Autowired
	FactureRepository factureRep;
	@Override
	public List<Facture> retrieveAllFactures() {
		// TODO Auto-generated method stub
		return (List<Facture>) factureRep.findAll();
		
	}

	@Override
	public void cancelFacture(Long id) {
		// TODO Auto-generated method stub
		log.info("début d'execution de la méthode deleteFacture");
		factureRep.deleteById(id);
		log.info("début d'execution de la méthode deleteFacture");
		
	}

	@Override
	public Facture retrieveFacture(Long id) {
		// TODO Auto-generated method stub
		return factureRep.findById(id).get();
	}

	@Override
	public Facture addFacture(Facture f) {
		log.info("début d'execution de la méthode addFacture");
		factureRep.save(f);
		log.info("début d'execution de la méthode addFacture");
		return f;
	}

}
