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
import tn.esprit.elife.persistance.classes.Rayon;
import tn.esprit.elife.services.Interfaces.IRayonService;
@RestController
@Api(tags = "Gestion des Rayons")
@RequestMapping("/rayon")
public class RayonRestController {
	@Autowired
	IRayonService rayonService;
	
	// http://localhost:8089/SpringMVC/rayon/retrieve-all-rayons
		@ApiOperation(value = "Récupérer la liste des rayons")
		@GetMapping("/retrieve-all-rayons")
		public List<Rayon> getRayons() {
		List<Rayon> listRayons = rayonService.retrieveAllRayons();
		return listRayons;
	}
		
		// http://localhost:8089/SpringMVC/rayon/retrieve-rayon/8
		@ApiOperation(value = "Récupérer un rayon par id")
		@GetMapping("/retrieve-rayon/{rayon-id}")
		@ResponseBody
		public Rayon retrieveRayon(@PathVariable("rayon-id") Long rayonId) {
		return rayonService.retrieveRayon(rayonId);
		}

		// http://localhost:8089/SpringMVC/rayon/add-rayon
		@ApiOperation(value = "Add rayon")
		@PostMapping("/add-rayon")
		@ResponseBody
		public Rayon addRayon(@RequestBody Rayon r)
		{
			Rayon rayon = rayonService.addRayon(r);
		return rayon;
		}
		
		// http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
		@ApiOperation(value = "Remove rayon")
		@DeleteMapping("/remove-rayon/{rayon-id}")
		@ResponseBody
		public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
			rayonService.deleteRayon(rayonId);
		}

		// http://localhost:8089/SpringMVC/rayon/modify-rayon
		@ApiOperation(value = "Modify rayon")
		@PutMapping("/modify-rayon")
		@ResponseBody
		public Rayon modifyRayon(@RequestBody Rayon rayon) {
		return rayonService.updateRayon(rayon);
		}
}
