package tn.esprit.elife.persistance.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.elife.persistance.classes.Stock;
@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {

}
