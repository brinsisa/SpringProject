package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Produit;

public interface IProduitService {
	List<Produit> retrieveAllProduits();

	Produit addProduit(Produit p, Long idRayon, Long idStock);

	Produit retrieveProduit(Long id);
	void deleteProduit(Long id);
	Produit updateProduit(Produit p );
}
