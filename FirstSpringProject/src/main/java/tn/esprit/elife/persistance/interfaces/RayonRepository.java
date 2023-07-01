package tn.esprit.elife.persistance.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.elife.persistance.classes.Rayon;

@Repository
public interface RayonRepository extends CrudRepository<Rayon, Long>{

}
