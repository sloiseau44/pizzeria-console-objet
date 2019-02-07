package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.PizzaMemDao;

public class SupprimerPizzaService extends MenuService{
	public void executerCasUtilisation(PizzaMemDao pizzaMemDao, Scanner scanner) {		

		System.out.println("Suppression d’une pizza");

		//Demande et lecture du code de la pizza à supprimer saisie par l'utilisateur
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String code = scanner.next();
		if(pizzaMemDao.pizzaExiste(code)){
			pizzaMemDao.supprimerPizzaDansListe(code);
		}else{
			System.out.println("Aucune pizza avec le code "+code+" existe.");
		}
	}
}
