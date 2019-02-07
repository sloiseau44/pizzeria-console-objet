package fr.pizzeria.DAO;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Acer
 * Interface DAO
 *
 */

public interface IPizzaDao {
	
	/**
	 * @return liste existante des pizzas
	 */
	
	Pizza[] listeDesPizzas();
	
	/** 
	 * Ajoute une pizza dans la liste
	 * @param pizza (requis)
	 */
	
	void ajoutPizzaDansListe(Pizza pizza);
	
	/**
	 * Modifie une pizza de la liste
	 * @param codePizza (requis)
	 * @param pizza (requis)
	 */
	
	void modifierPizzaDansListe(String codePizza, Pizza pizza);
	
	/**
	 * Supprime une pizza de la liste
	 * @param codePizza (requis)
	 */
	
	void supprimerPizzaDansListe(String codePizza);
	
	/**
	 * Trouve les informations d'une pizza dans la liste en fonction de son code
	 * @param codePizza (requis)
	 * @return la pizza demandé grâce à son code
	 */
	
	Pizza trouverPizzaParCode(String codePizza);
	
	/**
	 * Détermine si une pizza existe dans la liste grâce à son code
	 * @param codePizza (requis)
	 * @return true ou false
	 */
	
	boolean pizzaExiste(String codePizza);
}
