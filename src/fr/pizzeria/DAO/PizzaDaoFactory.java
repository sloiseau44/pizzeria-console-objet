package fr.pizzeria.DAO;

import java.io.IOException;
import java.sql.SQLException;

import fr.pizzeria.exception.AjoutPizzaException;

/**
 * Factory des DAO l'application de gestion de la carte des pizzas
 * @author Acer
 *
 */

public class PizzaDaoFactory {
	public static IPizzaDao getDao (int choixDao) throws ClassNotFoundException, SQLException, IOException, AjoutPizzaException{
		IPizzaDao iPizzaDao = null;
		
		if(choixDao==1){
			iPizzaDao = new PizzaMemDao();
		}else if(choixDao==2){
			iPizzaDao = new PizzaJdbcDao();
		}else if(choixDao==3){
			iPizzaDao = new PizzaJpaDao();
		}
		
		return iPizzaDao;
		
	}
}
