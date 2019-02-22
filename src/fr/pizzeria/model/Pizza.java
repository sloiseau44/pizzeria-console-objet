package fr.pizzeria.model;

import javax.persistence.*;

/**
 * 
 * @author Acer
 * Objet pizza
 *
 */

@Entity
@Table(name="pizza")
public class Pizza {
	
	/**
	 * @param id (requis) identifiant de la pizza
	 * @param code (requis) code de la pizza
	 * @param libelle (requis) libellé de la pizza
	 * @param prix (requis) prix d'achat de la pizza
	 * 
	 */
	
	public static int nbPizza;
	@Id
	@Column(name="idPizza")
	public int id;
	@Column(name="code", length=255)
	public String code;
	@Column(name="libelle", length=255)
	public String libelle;
	@Column(name="prix")
	public double prix;
	@Enumerated(EnumType.STRING)
	@Column(name="categorie")
	public CategoriePizza categorie;
	
	/**
	 * Constructeur 
	 * 
	 * @param code (requis)
	 * @param libelle (requis)
	 * @param prix (requis)
	 */
	
	public Pizza(){
		
	}
	
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		id = nbPizza++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}
	

	/**
	 * Constructeur  
	 * 
	 * @param id (requis)
	 * @param code (requis)
	 * @param libelle (requis)
	 * @param prix (requis)
	 * 
	 */
	
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categorie) {
		nbPizza = nbPizza+1;
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	/**
	 * @return l'affichage du code, du libellé et du prix de la pizza 
	 * 
	 */
	
	@Override
	public String toString() {
		return new String(this.id+" "+this.code+" -> "+this.libelle+" "+categorie.getNom()+" ("+this.prix+" €)");
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public CategoriePizza getCategorie() {
		return categorie;
	}


	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
	
	
	

	
}
