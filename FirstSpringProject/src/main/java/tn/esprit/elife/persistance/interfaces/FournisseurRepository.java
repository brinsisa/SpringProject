package tn.esprit.elife.persistance.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.elife.persistance.classes.Fournisseur;
@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long>{

}
