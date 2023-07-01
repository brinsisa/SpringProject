package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Facture;

public interface IFactureService {
	List<Facture> retrieveAllFactures();
	void cancelFacture(Long id);
	Facture retrieveFacture(Long id);
	Facture addFacture(Facture f);
}
