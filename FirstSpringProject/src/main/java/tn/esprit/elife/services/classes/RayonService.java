package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Rayon;
import tn.esprit.elife.persistance.interfaces.RayonRepository;
import tn.esprit.elife.services.Interfaces.IRayonService;

@Service
@Slf4j
public class RayonService implements IRayonService  {
	@Autowired
	RayonRepository rayonRep;
	@Override
	public List<Rayon> retrieveAllRayons() {
		return (List<Rayon>) rayonRep.findAll();
	}

	@Override
	public Rayon addRayon(Rayon r) {
		log.info("debut de l'execution de la methode addRayon");
		rayonRep.save(r);
		log.info("fin de l'execution de la methode addRayon");
		return r;
	}

	@Override
	public void deleteRayon(Long id) {
		log.info("debut de l'execution de la methode deleteRayon");
		rayonRep.deleteById(id);
		log.info("fin de l'execution de la methode deleteRayon");
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		log.info("debut de l'execution de la methode updateRayon");
		rayonRep.save(r);
		log.info("fin de l'execution de la methode updateRayon");
		return r;
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		
		return rayonRep.findById(id).get();
	}

}
