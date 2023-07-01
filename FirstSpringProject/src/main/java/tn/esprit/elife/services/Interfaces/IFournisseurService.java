package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Fournisseur;

public interface IFournisseurService {
	List<Fournisseur> retrieveAllFournisseurs();

	Fournisseur addFournisseur(Fournisseur f);

	void deleteFournisseur(Long id);

	Fournisseur updateFournisseur(Fournisseur f);

	Fournisseur retrieveFournisseur(Long id);
}
