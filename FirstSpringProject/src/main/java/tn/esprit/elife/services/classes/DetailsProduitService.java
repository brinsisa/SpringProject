package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.DetailsProduit;
import tn.esprit.elife.persistance.interfaces.DetailsProduitRepository;
import tn.esprit.elife.services.Interfaces.IDetailsProduitService;

@Service
@Slf4j
public class DetailsProduitService implements IDetailsProduitService {
	@Autowired
	DetailsProduitRepository dProduitRep;
	@Override
	public List<DetailsProduit> retrieveAllDetailsProduits() {
	
		return (List<DetailsProduit>) dProduitRep.findAll();
	}

	@Override
	public DetailsProduit addDetailsProduit(DetailsProduit dp, Long idProduit) {
		log.info("debut de l'execution de la methode addDetailsProduit");
		dProduitRep.save(dp);
		log.info("fin de l'execution de la methode addDetailsProduit");
		return dp;
	}

	@Override
	public DetailsProduit retrieveDetailsProduit(Long id) {
	
		return dProduitRep.findById(id).get();
	}

	@Override
	public void deleteDetailsProduit(Long id) {
		dProduitRep.deleteById(id);
		
	}

	@Override
	public DetailsProduit updateDetailsProduit(DetailsProduit dp) {
		log.info("debut de l'execution de la methode updateDetailsProduit");
		dProduitRep.save(dp);
		log.info("fin de l'execution de la methode updateDetailsProduit");
		return dp;
	}

}
