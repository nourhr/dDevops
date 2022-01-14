package tn.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "T_Entreprise")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Name;
	private String StatutFiscal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStatutFiscal() {
		return StatutFiscal;
	}
	public void setStatutFiscal(String statutFiscal) {
		StatutFiscal = statutFiscal;
	}
	public Entreprise(Long id, String name, String statutFiscal) {
		super();
		this.id = id;
		Name = name;
		StatutFiscal = statutFiscal;
	}
	public Entreprise() {
		super();
	}
	public Entreprise(String name, String statutFiscal) {
		super();
		Name = name;
		StatutFiscal = statutFiscal;
	}
	
	
}
