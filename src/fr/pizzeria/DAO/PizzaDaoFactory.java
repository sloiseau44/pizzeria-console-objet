package fr.pizzeria.DAO;


/**
 * Factory des DAO l'application de gestion de la carte des pizzas
 * @author Acer
 *
 */

public class PizzaDaoFactory {
	public static IPizzaDao getDao (int choixDao){
		IPizzaDao iPizzaDao = null;
		
		if(choixDao==1){
			iPizzaDao = new PizzaMemDao();
		}
		
		return iPizzaDao;
		
	}
}
