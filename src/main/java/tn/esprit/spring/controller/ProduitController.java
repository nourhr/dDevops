package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.ProduitServiceImpl;

@RestController
@RequestMapping(value = "/api/product")
public class ProduitController {
	@Autowired
	ProduitServiceImpl agent;

	@GetMapping
	public List<Produit> getAllProduct() {
		return (List<Produit>) agent.retrieveAllProduit();
	}

	@GetMapping(path = "/{id}")

	public Produit getProductByID(@PathVariable Long id) {
		return agent.retrieveProduit(id);
	}
	
	@PostMapping
	public Produit updateProduct (Produit p){
		return agent.addProduit(p);
	}
@DeleteMapping (path ="/{id}")
public void deleteProduct (@PathVariable Long id){
	agent.deleteProduit(id);
}
}
