package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * Service d'affichage de la carte de pizza
 * @author Acer
 *
 */

public class ListerPizzasService extends MenuService {


	public void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Liste des pizzas");
		//Affichage de la liste
		Pizza[] listePizza = pizzaDao.listeDesPizzas();
		for(int i=0; i<listePizza.length; i++){
			System.out.println(listePizza[i].toString());					
		}
		
	}

}
