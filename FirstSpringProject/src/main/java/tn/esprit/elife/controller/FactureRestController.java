package tn.esprit.elife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.elife.persistance.classes.Facture;
import tn.esprit.elife.services.Interfaces.IFactureService;
@RestController
@Api(tags = "Gestion des Factures")
@RequestMapping("/facture")
public class FactureRestController {
	@Autowired
	IFactureService factureService;
	
	// http://localhost:8089/SpringMVC/facture/retrieve-all-factures
		@ApiOperation(value = "Récupérer la liste des factures")
		@GetMapping("/retrieve-all-factures")
		public List<Facture> getFactures() {
		List<Facture> listFactures = factureService.retrieveAllFactures();
		return listFactures;
	}
		
		// http://localhost:8089/SpringMVC/facture/retrieve-facture/8
		@ApiOperation(value = "Récupérer une facture par id")
		@GetMapping("/retrieve-facture/{facture-id}")
		@ResponseBody
		public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
		return factureService.retrieveFacture(factureId);
		}

		// http://localhost:8089/SpringMVC/facture/add-facture
		@ApiOperation(value = "Add facture")
		@PostMapping("/add-facture")
		@ResponseBody
		public Facture addFacture(@RequestBody Facture f)
		{
			Facture facture = factureService.addFacture(f);
		return facture;
		}
		
		// http://localhost:8089/SpringMVC/facture/remove-facture/{facture-id}
		@ApiOperation(value = "Remove facture")
		@DeleteMapping("/remove-facture/{facture-id}")
		@ResponseBody
		public void removeFacture(@PathVariable("facture-id") Long factureId) {
			factureService.cancelFacture(factureId);
		}

	
}
