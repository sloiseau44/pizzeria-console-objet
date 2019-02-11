package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Service d'ajout d'une pizza à la carte
 * @author Acer
 *
 */

public class AjouterPizzaService extends MenuService {
	
	public void executerCasUtilisation(IPizzaDao pizzaDao, Scanner scanner) throws AjoutPizzaException {
		System.out.println("Ajout d’une nouvelle pizza");
		//Demande et lecture du code saisie par l'utilisateur
		System.out.println("Veuillez saisir le code :");
		String code = scanner.next();	

		if(pizzaDao.pizzaExiste(code)){
			throw new AjoutPizzaException();
		}else {
			//Demande et lecture du libelle saisie par l'utilisateur
			System.out.println("Veuillez saisir le nom (sans espace) :");
			String libelle = scanner.next();
			//Demande et lecture du prix saisie par l'utilisateur
			System.out.println("Veuillez saisir le prix :");
			double prix = scanner.nextDouble();		
			
			//Demande et lecture de la catégorie saisie par l'utilisateur			
			CategoriePizza categorieChoisie = CategoriePizza.choixCategoriePizza(scanner);
			
			if(categorieChoisie==null){
				throw new IllegalArgumentException();
			}else{
				//Ajout de la pizza dans la liste grâce à la méthode ajoutPizzaDansListe 
				List<Pizza> listePizza = pizzaDao.listeDesPizzas();
				int idPizza = listePizza.size();
				pizzaDao.ajoutPizzaDansListe(new Pizza(idPizza, code, libelle, prix, categorieChoisie));
			}
		
		}
		
	}
}
