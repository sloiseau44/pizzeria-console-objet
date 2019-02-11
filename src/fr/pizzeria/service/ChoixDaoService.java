package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.PizzaDaoFactory;
import fr.pizzeria.exception.StockageException;

public class ChoixDaoService extends MenuService{

	public void executerCasUtilisation(Scanner scanner) throws StockageException {
		iPizzaDao = PizzaDaoFactory.getDao(1);
		
	}

}
