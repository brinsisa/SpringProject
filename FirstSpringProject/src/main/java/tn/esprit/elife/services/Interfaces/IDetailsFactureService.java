package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.DetailsFacture;

public interface IDetailsFactureService {
	List<DetailsFacture> retrieveAllDetailsFactures();

	DetailsFacture addDetailsFacture(DetailsFacture df, Long idFacture, Long idProduit);

	DetailsFacture retrieveDetailsFacture(Long id);
	
	void deleteDetailsFacture(Long id);

	DetailsFacture updateDetailsFacture(DetailsFacture df);
}
