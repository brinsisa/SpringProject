package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Rayon;

public interface IRayonService {
	List<Rayon> retrieveAllRayons();

	Rayon addRayon(Rayon r);

	void deleteRayon(Long id);

	Rayon updateRayon(Rayon r);

	Rayon retrieveRayon(Long id);
}
