package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.model.Pizza;

/**
 * Service d'ajout d'une pizza � la carte
 * @author Acer
 *
 */

public class AjouterPizzaService extends MenuService {
	
	public void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) {
		System.out.println("Ajout d�une nouvelle pizza");
		//Demande et lecture du code saisie par l'utilisateur
		System.out.println("Veuillez saisir le code :");
		String code = scanner.next();		

		if(!pizzaDao.pizzaExiste(code)){			
			//Demande et lecture du libelle saisie par l'utilisateur
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String libelle = scanner.next();
			//Demande et lecture du prix saisie par l'utilisateur
			System.out.println("Veuillez saisir le prix :");
			double prix = scanner.nextDouble();		
			
			//Ajout de la pizza dans la liste gr�ce � la m�thode ajoutPizzaDansListe 
			List<Pizza> listePizza = pizzaDao.listeDesPizzas();
			int idPizza = listePizza.size();
			pizzaDao.ajoutPizzaDansListe(new Pizza(idPizza, code, libelle, prix));
		}else{
			System.out.println("Une pizza avec le code "+code+" existe d�j�.");
		}
		
	}
}
