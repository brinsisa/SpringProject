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
import tn.esprit.elife.persistance.classes.DetailsFacture;
import tn.esprit.elife.services.Interfaces.IDetailsFactureService;
@RestController
@Api(tags = "Gestion des DetailsFactures")
@RequestMapping("/detailsFacture")
public class DetailsFactureRestController {

	@Autowired
	IDetailsFactureService detailsFactureService;
	
	// http://localhost:8089/SpringMVC/detailsFacture/retrieve-all-detailsFactures
		@ApiOperation(value = "Récupérer la liste des detailsFactures")
		@GetMapping("/retrieve-all-detailsFactures")
		public List<DetailsFacture> getRayons() {
		List<DetailsFacture> listdetailsFactures = detailsFactureService.retrieveAllDetailsFactures();
		return listdetailsFactures;
	}
		
		// http://localhost:8089/SpringMVC/detailsFacture/retrieve-detailsFacture/8
		@ApiOperation(value = "Récupérer un detailsFacture par id")
		@GetMapping("/retrieve-detailsFacture/{detailsFacture-id}")
		@ResponseBody
		public DetailsFacture retrieveDetailsFacture(@PathVariable("detailsFacture-id") Long detailsFactureId) {
		return detailsFactureService.retrieveDetailsFacture(detailsFactureId);
		}

		// http://localhost:8089/SpringMVC/detailsFacture/add-detailsFacture
		
		  @ApiOperation(value = "Add detailsFacture")
		  
		  @PostMapping("/add-detailsFacture")
		  
		  @ResponseBody 
		  public DetailsFacture addDetailsFacture(@RequestBody DetailsFacture d, long idF, long idP) 
		  {
			  DetailsFacture detailsFacture =detailsFactureService.addDetailsFacture(d, idF, idP); 
		  return detailsFacture; 
		  }
		 
		
		// http://localhost:8089/SpringMVC/detailsFacture/remove-detailsFacture/{detailsFacture-id}
		@ApiOperation(value = "Remove detailsFacture")
		@DeleteMapping("/remove-detailsFacture/{detailsFacture-id}")
		@ResponseBody
		public void removeDetailsFacture(@PathVariable("detailsFacture-id") Long detailsFactureId) {
			detailsFactureService.deleteDetailsFacture(detailsFactureId);
		}

		// http://localhost:8089/SpringMVC/detailsFacture/modify-detailsFacture
		@ApiOperation(value = "Modify detailsFacture")
		@PutMapping("/modify-detailsFacture")
		@ResponseBody
		public DetailsFacture modifyDetailsFacture(@RequestBody DetailsFacture detailsFacture) {
		return detailsFactureService.updateDetailsFacture(detailsFacture);
		}
}
