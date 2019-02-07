package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;

/**
 * Class abstraite des services
 * @author Acer
 *  *
 */

public abstract class MenuService {
	/**
	 * 
	 * @param pizzaDao (requis)
	 * @param scanner (requis)
	 */
	public abstract void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner);
}
