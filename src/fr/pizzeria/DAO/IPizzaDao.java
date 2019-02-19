package fr.pizzeria.DAO;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.exception.ModificationPizzaException;
import fr.pizzeria.exception.SuppressionPizzaException;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Acer
 * Interface DAO
 *
 */

public interface IPizzaDao  {
	
	void initialisationListePizza() throws AjoutPizzaException, SQLException;
	
	/**
	 * @return liste existante des pizzas
	 */
	
	List<Pizza> listeDesPizzas() throws SQLException;
	
	/** 
	 * Ajoute une pizza dans la liste
	 * @param pizza (requis)
	 * @throws AjoutPizzaException dans le cas o� une pizza avec un code identique existe
	 */
	
	void ajoutPizzaDansListe(Pizza pizza) throws AjoutPizzaException, SQLException;
	
	/**
	 * Modifie une pizza de la liste
	 * @param codePizza (requis)
	 * @param pizza (requis)
	 * @throws ModificationPizzaException dans le cas o� aucune pizza avec ce code n'existe
	 */
	
	void modifierPizzaDansListe(String codePizza, Pizza pizza) throws ModificationPizzaException, SQLException;
	
	/**
	 * Supprime une pizza de la liste
	 * @param codePizza (requis)
	 * @throws ModificationPizzaException dans le cas o� aucune pizza avec ce code n'existe
	 */
	
	void supprimerPizzaDansListe(String codePizza) throws SuppressionPizzaException, SQLException;
	
	/**
	 * Trouve les informations d'une pizza dans la liste en fonction de son code
	 * @param codePizza (requis)
	 * @return la pizza demand� gr�ce � son code
	 */
	
	Pizza trouverPizzaParCode(String codePizza) throws SQLException;
	
	/**
	 * D�termine si une pizza existe dans la liste gr�ce � son code
	 * @param codePizza (requis)
	 * @return true ou false
	 */
	
	boolean pizzaExiste(String codePizza) throws SQLException;
	
	/**
	 * Permet de fermer le DAO
	 * @throws SQLException
	 */
	
	void fermerDAO() throws SQLException;
}
