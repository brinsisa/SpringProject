package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.DetailsFacture;
import tn.esprit.elife.persistance.interfaces.DetailsFactureRepository;
import tn.esprit.elife.services.Interfaces.IDetailsFactureService;

@Service
@Slf4j
public class DetailsFactureService implements IDetailsFactureService {
	@Autowired
	DetailsFactureRepository dFactureRep;
	@Override
	public List<DetailsFacture> retrieveAllDetailsFactures() {
		
		return (List<DetailsFacture>) dFactureRep.findAll();
	}

	@Override
	public DetailsFacture addDetailsFacture(DetailsFacture df, Long idFacture, Long idProduit) {
		log.info("debut de l'execution de la methode addDetailsFacture ");
		dFactureRep.save(df);
		log.info("fin de l'execution de la methode addDetailsFacture ");
		return df;
	}

	@Override
	public DetailsFacture retrieveDetailsFacture(Long id) {
		
		return dFactureRep.findById(id).get();
	}

	@Override
	public void deleteDetailsFacture(Long id) {
		log.info("debut de l'execution de la methode deleteDetailsFacture ");
		dFactureRep.deleteById(id);
		log.info("fin de l'execution de la methode deleteDetailsFacture");
		
	}

	@Override
	public DetailsFacture updateDetailsFacture(DetailsFacture df) {
		log.info("debut de l'execution de la methode updateDetailsFacture ");
		dFactureRep.save(df);
		log.info("fin de l'execution de la methode updateDetailsFacture ");
		return df;
	}

}
