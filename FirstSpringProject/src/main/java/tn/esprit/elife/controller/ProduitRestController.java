package tn.esprit.elife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import tn.esprit.elife.persistance.classes.Produit;
import tn.esprit.elife.services.Interfaces.IProduitService;

@RestController
@Api(tags = "Gestion des Produits")
@RequestMapping("/produit")
public class ProduitRestController {
	@Autowired
	IProduitService produitService;
	
	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
		@ApiOperation(value = "Récupérer la liste des produits")
		@GetMapping("/retrieve-all-produits")
		public List<Produit> getProduits() {
		List<Produit> listProduits = produitService.retrieveAllProduits();
		return listProduits;
	}
		
		// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
		@ApiOperation(value = "Récupérer un produit par id")
		@GetMapping("/retrieve-produit/{produit-id}")
		@ResponseBody
		public Produit retrieveProduit(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
		}

		
		  // http://localhost:8089/SpringMVC/produit/add-produit
		  
		  @ApiOperation(value = "Add produit")
		  
		  @PostMapping("/add-produit")
		  
		  @ResponseBody public Produit addProduit(@RequestBody Produit p, long idR, long idS) 
		  {
			  Produit produit = produitService.addProduit(p, idR, idS);
		  return produit; 
		  }
		 
		// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
		@ApiOperation(value = "Remove produit")
		@DeleteMapping("/remove-produit/{produit-id}")
		@ResponseBody
		public void removeProduit(@PathVariable("produit-id") Long produitId) {
			produitService.deleteProduit(produitId);
		}

		// http://localhost:8089/SpringMVC/produit/modify-produit
		@ApiOperation(value = "Modify produit")
		@PutMapping("/modify-produit")
		@ResponseBody
		public Produit modifyProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
		}

}
