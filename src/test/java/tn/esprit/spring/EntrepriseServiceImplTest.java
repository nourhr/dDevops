package tn.esprit.spring;

import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;

import tn.esprit.spring.services.IEntreprise;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EntrepriseServiceImplTest {
	@Autowired
	IEntreprise IE;

	@Test
	@Order(1)
	public void testRestrieveAllEntreprises() {
		List<Entreprise> listEntreprises = IE.retrieveAllEntreprises();
		Assertions.assertEquals(0, listEntreprises.size());
	}

	@Test
	@Order(2)
	public void testAddEntreprise() throws ParseException {
		Entreprise ent = new Entreprise("perolla", "jhutge2");
		Entreprise entAded = IE.addEntreprise(ent);
		Assertions.assertEquals(ent.getName(), entAded.getName());
	}

	@Test
	@Order(3)
	public void testRestrieveAllEntreprisesSecond() {
		List<Entreprise> listEnts = IE.retrieveAllEntreprises();
		int j = 0;
		for (int i = 1; i <= listEnts.size(); i++) {
			j = j++;
		}
		Assertions.assertEquals(j, listEnts.size());
	}

	@Test
	@Order(4)
	public void testUpdateEntreprise() throws ParseException {
		Entreprise e = new Entreprise(1L, "MB", "1548dsf");
		Entreprise entAded = IE.addEntreprise(e);
		Assertions.assertEquals(e.getName(), entAded.getName());
	}

	@Test
	@Order(5)
	public void testRetrieveEntreprise() {
		List<Entreprise> listEnts = IE.retrieveAllEntreprises();
		int l = listEnts.size();
		Entreprise EntRetrived = IE.retrieveEntreprise((long) l);
		Assertions.assertEquals(l, EntRetrived.getId());
	}

	@Test
	@Order(6)
	public void testDeletEntreprise() {
		List<Entreprise> listEnts = IE.retrieveAllEntreprises();
		int l = listEnts.size();
		IE.deleteEntreprise((long) l);
		int i = l - 1;
		List<Entreprise> listEntreprises = IE.retrieveAllEntreprises();
		Assertions.assertEquals(i, listEntreprises.size());
	}

}
