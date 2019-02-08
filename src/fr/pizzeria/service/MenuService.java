package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.exception.StockageException;

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
	 * @throws StockageException
	 */
	public abstract void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) throws StockageException;
}
