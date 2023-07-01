package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Produit;
import tn.esprit.elife.persistance.interfaces.ProduitRepository;
import tn.esprit.elife.services.Interfaces.IProduitService;
@Service
@Slf4j
public class ProduitService implements IProduitService {
	@Autowired
	ProduitRepository produitRep;
	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRep.findAll();
		
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {

		log.info("debut de l'execution de la methode addProduit");
		produitRep.save(p);
		log.info("fin de l'execution de la methode addProduit");
		return p;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		
	
			return produitRep.findById(id).get();
	}

	@Override
	public void deleteProduit(Long id) {
		log.info("debut de l'execution de la methode deleteProduit");
		produitRep.deleteById(id);
		log.info("fin de l'execution de la methode deleteProduit");
		
	}

	@Override
	public Produit updateProduit(Produit p) {
		log.info("debut de l'execution de la methode updateProduit");
		produitRep.save(p);
		log.info("fin de l'execution de la methode updateProduit");
		return p;
	}

}
