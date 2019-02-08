package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.exception.SuppressionPizzaException;

/**
 * Service de suppression d'une pizza de la carte
 * @author Acer
 *
 */

public class SupprimerPizzaService extends MenuService{
	public void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) throws SuppressionPizzaException {		

		System.out.println("Suppression d’une pizza");

		//Demande et lecture du code de la pizza à supprimer saisie par l'utilisateur
		System.out.println("Veuillez choisir le code de la pizza à supprimer");
		String code = scanner.next();
		if(pizzaDao.pizzaExiste(code)){
			pizzaDao.supprimerPizzaDansListe(code);
		}else{
			throw new SuppressionPizzaException();
		}
	}
}
