package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.repository.ProduitRepository;

@Service

public class ProduitServiceImpl implements IProduitService {
	@Autowired
	ProduitRepository agent;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<Produit> retrieveAllProduit() {
		List<Produit> produits = null;
		try {

			l.info("In Method retrieveAllUsers :");
			produits = (List<Produit>) agent.findAll();
			l.debug("Connected to Data Base  :");
			for (Produit p : produits) {
				l.debug("user :" + p.getName());
			}
			l.info("Out of Method retrieveAllProduits with Success" + produits.size());
		} catch (Exception e) {
			l.error("Out of Method retrieveAllProduits with Errors : " + e);
		}

		return produits;
	}

	@Override
	public Produit addProduit(Produit p) {
		Produit newP = null;
		try {
			l.info("In Methode AddProduct");
			newP = agent.save(p);
			l.info("Product added with succes" + p.getName());

		} catch (Exception e) {
			l.error("error with Methode Add Product : " + e);
		}

		return newP;
	}

	@Override
	public void deleteProduit(Long idProduit) {
		try {
			l.info("In Methode delete Procut:" + idProduit);
			agent.deleteById(idProduit);
			l.info("Product  was deleted successfully");

		} catch (Exception e) {
			l.error("error with Methode delete Product : " + e);
		}
	}

	@Override
	public Produit updateProduit(Produit p) {
		Produit pUpdated = null;

		try {
			l.info("In Methode updateproduct");
			pUpdated = agent.save(p);
			l.info("Product updated with succes" + p.getName());

		} catch (Exception e) {
			l.error("error with Methode update Product : " + e);
		}

		return pUpdated;
	}

	@Override
	public Produit retrieveProduit(Long id) {
		Produit p = null;
		try {
			l.info("In Methode retrieve Product:" + id);
			p = agent.findById(id).get();
			l.info("User retrieved");

		} catch (Exception e) {
			// TODO log ici : l....("error in retrieveUser() : " + e);
			l.error("error with Methode retrieve Product : " + e);
		}

		return p;
	}

}
