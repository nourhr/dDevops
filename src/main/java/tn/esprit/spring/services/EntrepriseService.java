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
		Entreprise savedE = ent; 
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
	public Entreprise retrieveEntreprise(long id) {
		Entreprise ent = null;
		try {
			l.info("In Methode retrieve Entreprise:"+id);
			ent =  EntrepriseRepo.findById(id).get(); 
			l.info("Entreprise retrieved");
			
		} catch (Exception e) {
			l.error("error with Methode delete Entreprise : " + e);
		}
		
		return ent;
	}

	@Override
	public void deleteEntreprise(Long id) {
		try {
		    l.info("In Methode delete Entreprise:"+id);
			EntrepriseRepo.deleteById(id); 
			l.info("Entreprise was deleted successfully");
			
		} catch (Exception e) {
			l.error("error with Methode delete Entreprise : " + e);
		}
		
		
	}



}
