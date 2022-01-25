package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.EntrepriseService;

@RestController
@RequestMapping(value="/api/entreprise")
public class EntrepriseRestController {
	@Autowired
	EntrepriseService agent;
	//http://localhost:8082/timesheet-devops/api/entreprise/
	@GetMapping
	public List<Entreprise> getAllEntreprise() {
		return (List<Entreprise>) agent.retrieveAllEntreprises();
	}

	@GetMapping(path = "/{id}")

	public Entreprise getEntrepriseByID(@PathVariable Long id) {
		return agent.retrieveEntreprise(id);
	}
	//http://localhost:8082/timesheet-devops/api/entreprise/updateEntreprise/
	@PostMapping(path = "/updateEntreprise/{id}")
	public Entreprise updateEntreprise (@RequestBody Entreprise ent){
		return agent.addEntreprise(ent);
	}
	//http://localhost:8082/timesheet-devops/api/entreprise/addEntreprise
	@PostMapping (path ="/addEntreprise")
	public Entreprise addEntreprise (@RequestBody Entreprise ent){
		Entreprise entreprise = agent.addEntreprise(ent); 
		return entreprise;
		
	}
	//http://localhost:8082/timesheet-devops/api/entreprise/deletEnt/
@DeleteMapping (path ="/deletEnt/{id}")
public void deleteEntreprise (@PathVariable Long id){
	agent.deleteEntreprise(id);
}

}
