package tn.esprit.elife.services.Interfaces;

import java.util.List;

import tn.esprit.elife.persistance.classes.Stock;

public interface IStockService {
	
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
}
