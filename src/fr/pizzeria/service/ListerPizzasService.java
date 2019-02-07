package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasService extends MenuService {


	public void executerCasUtilisation(PizzaMemDao pizzaMemDao, Scanner scanner) {
		System.out.println("Liste des pizzas");
		//Affichage de la liste
		Pizza[] listePizza = pizzaMemDao.listeDesPizzas();
		for(int i=0; i<listePizza.length; i++){
			System.out.println(listePizza[i].toString());					
		}
		
	}

}
