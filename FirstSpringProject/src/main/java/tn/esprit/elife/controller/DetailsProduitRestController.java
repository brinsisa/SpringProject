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
import tn.esprit.elife.persistance.classes.DetailsProduit;
import tn.esprit.elife.services.Interfaces.IDetailsProduitService;

@RestController
@Api(tags = "Gestion des DetailsProduits")
@RequestMapping("/detailsProduit")
public class DetailsProduitRestController {
	@Autowired
	IDetailsProduitService detailsProduitService;
	
	// http://localhost:8089/SpringMVC/detailsProduit/retrieve-all-detailsProduits
		@ApiOperation(value = "Récupérer la liste des detailsProduits")
		@GetMapping("/retrieve-all-detailsProduits")
		public List<DetailsProduit> getDetailsProduits() {
		List<DetailsProduit> listdetailsProduits = detailsProduitService.retrieveAllDetailsProduits();
		return listdetailsProduits;
	}
		
		// http://localhost:8089/SpringMVC/detailsProduit/retrieve-detailsProduit/8
		@ApiOperation(value = "Récupérer un detailsProduit par id")
		@GetMapping("/retrieve-detailsProduit/{detailsProduit-id}")
		@ResponseBody
		public DetailsProduit retrieveDetailsProduit(@PathVariable("detailsProduit-id") Long detailsProduitId) {
		return detailsProduitService.retrieveDetailsProduit(detailsProduitId);
		}

		
		  // http://localhost:8089/SpringMVC/detailsProduit/add-detailsProduit
		  
		  @ApiOperation(value = "Add detailsProduit")
		  
		  @PostMapping("/add-detailsProduit")
		  
		  @ResponseBody 
		  public DetailsProduit addDetailsProduit(@RequestBody DetailsProduit dp, long idP)
		  { 
			  DetailsProduit detailsProduit =detailsProduitService.addDetailsProduit(dp, idP); 
		  return detailsProduit; 
		  }
		 
		// http://localhost:8089/SpringMVC/detailsProduit/remove-detailsProduit/{detailsProduit-id}
		@ApiOperation(value = "Remove detailsProduit")
		@DeleteMapping("/remove-detailsProduit/{detailsProduit-id}")
		@ResponseBody
		public void removeDetailsProduit(@PathVariable("detailsProduit-id") Long detailsProduitId) {
			detailsProduitService.deleteDetailsProduit(detailsProduitId);
		}

		// http://localhost:8089/SpringMVC/detailsProduit/modify-detailsProduit
		@ApiOperation(value = "Modify detailsProduit")
		@PutMapping("/modify-detailsProduit")
		@ResponseBody
		public DetailsProduit modifyDetailsProduit(@RequestBody DetailsProduit detailsProduit) {
		return detailsProduitService.updateDetailsProduit(detailsProduit);
		}
}
