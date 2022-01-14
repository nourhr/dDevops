package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
@Service 
public class EntrepriseService implements IEntreprise {
	@Autowired
	EntrepriseRepository EntrepriseRepo; 
private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null; 
try {
			
			l.info("In Method retrieveAllEntreprises :");
			entreprises = (List<Entreprise>) EntrepriseRepo.findAll(); 
			l.debug("connexion à la DB Ok :"); 
			for ( Entreprise ent : entreprises) {
				l.debug("ent :" + ent.getName()); 
			} 
			l.info("Out of Method retrieveAllEntreprises with Success" + entreprises.size());
		}catch (Exception e) {
			l.error("Out of Method retrieveAllEntreprises with Errors : " + e); 
		}
		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise ent) {
		Entreprise savedE = null; 
		try {
			l.info("In Methode AddEntreprise");
			 savedE = EntrepriseRepo.save(ent); 
			l.info("Entreprise added with succes"+ent.getName());
			
		} catch (Exception e) {
			l.error("error with Methode Add Entreprise : " + e); 
		}
		return  savedE;
	}

	@Override
	public void deleteEntreprise(String id) {
		try {
		    l.info("In Methode delete Entreprise:"+id);
			EntrepriseRepo.deleteById(Long.parseLong(id)); 
			l.info("Entreprise was deleted successfully");
			
		} catch (Exception e) {
			l.error("error with Methode delete Entreprise : " + e);
		}
		
		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise ent) {
    Entreprise entUpdated = null; 

	try {
		l.info("In Methode updateEntreprise");
		entUpdated = EntrepriseRepo.save(ent); 
		l.info("Entreprise updated with succes"+ent.getName());
		
	} catch (Exception e) {
		l.error("error with Methode update Entreprise : " + e); 
	}
		return entUpdated;
	}

	@Override
	public Entreprise retrieveEntreprise(String id) {
		Entreprise ent = null;
		try {
			l.info("In Methode retrieve Entreprise:"+id);
			ent =  EntrepriseRepo.findById(Long.parseLong(id)).get(); 
			l.info("Entreprise retrieved");
			
		} catch (Exception e) {
			l.error("error with Methode delete Entreprise : " + e);
		}
		
		return ent;
	}

}
