package tn.esprit.elife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.elife.persistance.classes.Stock;
import tn.esprit.elife.services.Interfaces.IStockService;

@RestController
@Api(tags = "Gestion des Stock")
@RequestMapping("/stock")
public class StockRestController {
	@Autowired
	IStockService stockService;
	// http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
		@ApiOperation(value = "Récupérer la liste des stocks")
		@GetMapping("/retrieve-all-stocks")
		public List<Stock> getStocks() {
		List<Stock> liststocks = stockService.retrieveAllStocks();
		return liststocks;
	}
		
		// http://localhost:8089/SpringMVC/stock/retrieve-stock/8
		@ApiOperation(value = "Récupérer un stock par id")
		@GetMapping("/retrieve-stock/{stock-id}")
		@ResponseBody
		public Stock retrievestock(@PathVariable("stock-id") Long stockId) {
		return stockService.retrieveStock(stockId);
		}

		// http://localhost:8089/SpringMVC/stock/add-stock
		@ApiOperation(value = "Add stock")
		@PostMapping("/add-stock")
		@ResponseBody
		public Stock addStock(@RequestBody Stock s)
		{
			Stock stock = stockService.addStock(s);
		return stock;
		}
	

		// http://localhost:8089/SpringMVC/stock/modify-stock
		@ApiOperation(value = "Modify stock")
		@PutMapping("/modify-stock")
		@ResponseBody
		public Stock modifyStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
		}

}
