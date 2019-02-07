package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.PizzaMemDao;

public abstract class MenuService {
	public abstract void executerCasUtilisation(PizzaMemDao pizzaMemDao, Scanner scanner);
}
