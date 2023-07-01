package tn.esprit.elife.services.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.elife.persistance.classes.Stock;
import tn.esprit.elife.persistance.interfaces.StockRepository;
import tn.esprit.elife.services.Interfaces.IStockService;
@Service
@Slf4j
public class StockService implements IStockService {
	@Autowired
	StockRepository stockRep;
	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) stockRep.findAll();
		
	}

	@Override
	public Stock addStock(Stock s) {
		log.info("debut de l'execution de la methode addStock");
		stockRep.save(s);
		log.info("fin de l'execution de la methode addStock");
		return s;
	}

	@Override
	public Stock updateStock(Stock u) {
		log.info("debut de l'execution de la methode updateStock");
		stockRep.save(u);
		log.info("fin de l'execution de la methode updateStock");
		return u;
	}

	@Override
	public Stock retrieveStock(Long id) {
		return stockRep.findById(id).get();
	}

}
