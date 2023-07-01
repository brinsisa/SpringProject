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
import tn.esprit.elife.persistance.classes.Fournisseur;
import tn.esprit.elife.services.Interfaces.IFournisseurService;

@RestController
@Api(tags = "Gestion des Fournisseur")
@RequestMapping("/fournisseur")
public class FournisseurRestController {
	@Autowired
	IFournisseurService fournisseurService;
	
	// http://localhost:8089/SpringMVC/fournisseur/retrieve-all-fournisseurs
		@ApiOperation(value = "Récupérer la liste des fournisseurs")
		@GetMapping("/retrieve-all-fournisseurs")
		public List<Fournisseur> getFournisseurs() {
		List<Fournisseur> listFournisseurs = fournisseurService.retrieveAllFournisseurs();
		return listFournisseurs;
	}
		
		// http://localhost:8089/SpringMVC/fournisseur/retrieve-fournisseur/8
		@ApiOperation(value = "Récupérer un fournisseur par id")
		@GetMapping("/retrieve-fournisseur/{fournisseur-id}")
		@ResponseBody
		public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
		return fournisseurService.retrieveFournisseur(fournisseurId);
		}

		// http://localhost:8089/SpringMVC/fournisseur/add-fournisseur
		@ApiOperation(value = "Add fournisseur")
		@PostMapping("/add-fournisseur")
		@ResponseBody
		public Fournisseur addFournisseur(@RequestBody Fournisseur f)
		{
			Fournisseur fournisseur = fournisseurService.addFournisseur(f);
		return fournisseur;
		}
		
		// http://localhost:8089/SpringMVC/fournisseur/remove-fournisseur/{fournisseur-id}
		@ApiOperation(value = "Remove fournisseur")
		@DeleteMapping("/remove-fournisseur/{fournisseur-id}")
		@ResponseBody
		public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
			fournisseurService.deleteFournisseur(fournisseurId);;
		}

		// http://localhost:8089/SpringMVC/fournisseur/modify-fournisseur
		@ApiOperation(value = "Modify fournisseur")
		@PutMapping("/modify-fournisseur")
		@ResponseBody
		public Fournisseur modifyRayon(@RequestBody Fournisseur fournisseur) {
		return fournisseurService.updateFournisseur(fournisseur);
		}
}
