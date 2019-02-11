package fr.pizzeria.model;

/**
 * 
 * @author Acer
 * Objet pizza
 *
 */

public class Pizza {
	
	/**
	 * @param id (requis) identifiant de la pizza
	 * @param code (requis) code de la pizza
	 * @param libelle (requis) libellé de la pizza
	 * @param prix (requis) prix d'achat de la pizza
	 * 
	 */
	public static int nbPizza;
	public int id;
	public String code;
	public String libelle;
	public double prix;
	public CategoriePizza categorie;
	
	/**
	 * Constructeur 
	 * 
	 * @param code (requis)
	 * @param libelle (requis)
	 * @param prix (requis)
	 */
	
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
		return new String(this.id+" "+this.code+" -> "+this.libelle+" "+categorie+" ("+this.prix+" €)");
	}

	
}
