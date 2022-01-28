package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.services.ProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ProduitServiceImplTest {
	@Autowired
	ProduitServiceImpl agent;

	@Test
	@Order(1)
	public void testRetrieveAllProduct() {
		int j = 0;
		for (int i = 0; i < agent.retrieveAllProduit().size(); i++) {
			j = j++;
		}
		Assertions.assertEquals(1, agent.retrieveAllProduit().size());
	}

	@Test
	@Order(2)
	public void testAddproduct() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = date.parse("2021-10-10");
		Produit p = new Produit("Lait", "description", d);
		Produit pAdded = agent.addProduit(p);
		Assertions.assertEquals(p.getName(), pAdded.getName());
	}

	@Test
	@Order(3)
	public void testRetrieveAllProductSecond() {
		List<Produit> produits = agent.retrieveAllProduit();
		int j = 0;
		for (int i = 0; i < agent.retrieveAllProduit().size(); i++) {
			j = j++;
		}
		Assertions.assertEquals(1, produits.size());
	}

	@Test
	@Order(4)
	public void testUpdateProduct() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = (Date) date.parse("2022-10-11");
		Produit p = new Produit(1L, "gel", "description gel", d);
		Produit pAdded = agent.updateProduit(p);
		Assertions.assertEquals(p.getName(), pAdded.getName());

	}

	@Test
	@Order(5)
	public void testRetrieveProduct() {
		int l = agent.retrieveAllProduit().size();
		Produit p = agent.retrieveProduit((long) l);
		Assertions.assertEquals(l, p.getIdProduit());
	}

	@Test
	@Order(6)
	public void testDeleteProduct() {
		int l =  agent.retrieveAllProduit().size();
		agent.deleteProduit((long) l);
		int i = agent.retrieveAllProduit().size() - 1;
		List<Produit> listProduct = agent.retrieveAllProduit();
		Assertions.assertEquals(i, listProduct.size());
	}

}
