package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.DetailsProduit;

public interface IDetailsProduitService {
	List<DetailsProduit> retrieveAllDetailsProduits();

	DetailsProduit addDetailsProduit(DetailsProduit dp, Long idProduit);

	DetailsProduit retrieveDetailsProduit(Long id);
	
	void deleteDetailsProduit(Long id);

	DetailsProduit updateDetailsProduit(DetailsProduit dp);
}
