package fr.pizzeria.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.ChoixDaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

/**
 * Service d'affichage de la carte de pizza
 * @author Acer
 *
 */

public class ListerPizzasService extends MenuService {


	public void executerCasUtilisation(Scanner scanner) throws StockageException, IOException, SQLException{
		System.out.println("Liste des pizzas");
		//Affichage de la liste
		if(iPizzaDao==null){
			throw new ChoixDaoException();
		}else{
			List<Pizza> listePizza = iPizzaDao.listeDesPizzas();
			for(Pizza pizza : listePizza){
				System.out.println(pizza.toString());
			}	
		}
	}

}
