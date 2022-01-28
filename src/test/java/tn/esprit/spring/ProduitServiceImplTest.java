package tn.esprit.spring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		List<Produit> produits = agent.retrieveAllProduit();
		Assertions.assertEquals(0, produits.size());
	}

	@Test
	@Order(2)
	public void testAddproduct() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = (Date) date.parse("2021-10-10");
		Produit p = new Produit("Lait", "description", d);
		Produit pAdded = agent.addProduit(p);
		Assertions.assertEquals(p.getName(), pAdded.getName());
	}

	@Test
	@Order(3)
	public void testRetrieveAllProductSecond() {
		List<Produit> produits = agent.retrieveAllProduit();
		Assertions.assertEquals(1, produits.size());
	}

	@Test
	@Order(4)
	public void testUpdateProduct() throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date d = (Date) date.parse("2022-10-10");
		Produit p = new Produit(1L, "Lait", "description", d);
		Produit pAdded = agent.updateProduit(p);
		Assertions.assertEquals(p.getName(), pAdded.getName());

	}

	@Test
	@Order(5)
	public void testRetrieveProduct() {
		Produit p = agent.retrieveProduit((long) 1);
		Assertions.assertEquals(1L, p.getIdProduit());
	}

	@Test
	@Order(6)
	public void testDeleteProduct() {
		agent.deleteProduit((long) 1);
		List<Produit> listProduct = agent.retrieveAllProduit();
		Assertions.assertEquals(0, listProduct.size());
	}

}
