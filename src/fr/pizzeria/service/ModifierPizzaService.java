package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.exception.ChoixDaoException;
import fr.pizzeria.exception.ModificationPizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Service de modification d'une pizza dans la carte
 * @author Acer
 *
 */

public class ModifierPizzaService extends MenuService{
	public void executerCasUtilisation(/*IPizzaDao pizzaDao,*/ Scanner scanner) throws StockageException {
		System.out.println("Mise à jour d’une pizza");
		List<Pizza> listePizza = iPizzaDao.listeDesPizzas();
		for(Pizza pizza : listePizza){
			System.out.println(pizza.toString());					
		}

		//Demande et lecture du code de la pizza à modifier saisie par l'utilisateur
		System.out.println("Veuillez choisir le code de la pizza à modifier.");
		String code = scanner.next();

		if(iPizzaDao==null){
			throw new ChoixDaoException();
		}else{
			if(iPizzaDao.pizzaExiste(code)){
				//Demande et lecture du nouveau code saisie par l'utilisateur
				System.out.println("Veuillez saisir le nouveau code :");
				String nouveauCode = scanner.next();
				//Demande et lecture du nouveau libellé saisie par l'utilisateur
				System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
				String nouveauLibelle = scanner.next();
				//Demande et lecture du nouveau code prix par l'utilisateur
				System.out.println("Veuillez saisir le nouveau prix :");
				double nouveauPrix = scanner.nextDouble();
				//Demande et lecture de la catégorie saisie par l'utilisateur			
				CategoriePizza categorieChoisie = CategoriePizza.choixCategoriePizza(scanner);
	
				if(categorieChoisie==null){
					throw new IllegalArgumentException();
				}else{
					//Modification de la pizza dans la carte
					for(Pizza pizza : listePizza){
						if(pizza.code.equals(code)){
							iPizzaDao.modifierPizzaDansListe(code, new Pizza(pizza.id, nouveauCode,nouveauLibelle,nouveauPrix,categorieChoisie));
	
						}
					}
				}
			}else{
				throw new ModificationPizzaException();
			}
		}
	}
}
