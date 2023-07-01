package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Fournisseur;
import tn.esprit.elife.persistance.interfaces.FournisseurRepository;
import tn.esprit.elife.services.Interfaces.IFournisseurService;

@Service
@Slf4j
public class FournisseurService implements IFournisseurService {
	@Autowired
FournisseurRepository fournisseurRep;
	@Override
	public List<Fournisseur> retrieveAllFournisseurs() {
		
		return (List<Fournisseur>) fournisseurRep.findAll();
	}

	@Override
	public Fournisseur addFournisseur(Fournisseur f) {
		log.info("debut de l'execution de la methode addFournisseur");
		fournisseurRep.save(f);
		log.info("fin de l'execution de la methode addFournisseur");
		return f;
	}

	@Override
	public void deleteFournisseur(Long id) {
		log.info("debut de l'execution de la methode deleteFournisseur");
		fournisseurRep.deleteById(id);
		log.info("fin de l'execution de la methode deleteFournisseur");
		
	}

	@Override
	public Fournisseur updateFournisseur(Fournisseur f) {
		log.info("debut de l'execution de la methode updateFournisseur");
		fournisseurRep.save(f);
		log.info("fin de l'execution de la methode updateFournisseur");
		return f;
	}

	@Override
	public Fournisseur retrieveFournisseur(Long id) {
		
		return fournisseurRep.findById(id).get();
	}

}
