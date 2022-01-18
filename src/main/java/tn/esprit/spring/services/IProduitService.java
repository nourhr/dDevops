package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Produit;

public interface IProduitService {
	List<Produit> retrieveAllProduit();
	Produit addProduit (Produit p);
	void deleteProduit (Long idProduit);
	Produit updateProduit (Produit p);
	Produit retrieveProduit (Long id);

}
