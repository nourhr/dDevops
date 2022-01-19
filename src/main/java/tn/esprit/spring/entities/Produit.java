package tn.esprit.spring.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_PRODUIT")
public class Produit {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduit;   
	
	private String name; 
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date expDate;

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Produit(Long idProduit, String name, String description, Date expDate) {
		super();
		this.idProduit = idProduit;
		this.name = name;
		this.description = description;
		this.expDate = expDate;
	}

	public Produit(String name, String description, Date expDate) {
		super();
		this.name = name;
		this.description = description;
		this.expDate = expDate;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", Name=" + name + ", Description=" + description + ", expDate="
				+ expDate + "]";
	}

}
