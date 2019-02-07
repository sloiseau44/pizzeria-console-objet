package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * Service de modification d'une pizza dans la carte
 * @author Acer
 *
 */

public class ModifierPizzaService extends MenuService{
	public void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Mise à jour d’une pizza");
		Pizza[] listePizza = pizzaDao.listeDesPizzas();
		for(int i=0; i<listePizza.length; i++){
			System.out.println(listePizza[i].toString());					
		}
		
		//Demande et lecture du code de la pizza à modifier saisie par l'utilisateur
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String code = scanner.next();
		
		if(pizzaDao.pizzaExiste(code)){
			//Demande et lecture du nouveau code saisie par l'utilisateur
			System.out.println("Veuillez saisir le nouveau code :");
			String nouveauCode = scanner.next();
			//Demande et lecture du nouveau libellé saisie par l'utilisateur
			System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
			String nouveauLibelle = scanner.next();
			//Demande et lecture du nouveau code prix par l'utilisateur
			System.out.println("Veuillez saisir le nouveau prix :");
			double nouveauPrix = scanner.nextDouble();
			
			//Modification de la pizza dans la carte
			for(int i=0; i<listePizza.length; i++){
				if(listePizza[i].code.equals(code)){
					pizzaDao.modifierPizzaDansListe(code, new Pizza(nouveauCode,nouveauLibelle,nouveauPrix,listePizza));
				}
			}
		}else{
			System.out.println("Aucune pizza avec le code "+code+" existe.");
		}
	}
}
