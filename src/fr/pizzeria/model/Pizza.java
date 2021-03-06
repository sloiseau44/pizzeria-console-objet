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
	 * @param libelle (requis) libell� de la pizza
	 * @param prix (requis) prix d'achat de la pizza
	 * 
	 */
	
	public int id;
	public String code;
	String libelle;
	double prix;
	
	/**
	 * Constructeur 
	 * 
	 * @param code (requis)
	 * @param libelle (requis)
	 * @param prix (requis)
	 * @param listePizza (requis) carte de la pizza existante
	 */
	
	public Pizza(String code, String libelle, double prix, Pizza[] listePizza) {		
		this.id = listePizza[listePizza.length-1].id+1;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
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
	
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	/**
	 * @return l'affichage du code, du libell� et du prix de la pizza 
	 * 
	 */
	
	@Override
	public String toString() {
		return new String(this.code+" -> "+this.libelle+" ("+this.prix+" �)");
	}

}
