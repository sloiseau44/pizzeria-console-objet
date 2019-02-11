package fr.pizzeria.service;

import java.util.List;
import java.util.Scanner;


import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.exception.ChoixDaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Service d'ajout d'une pizza � la carte
 * @author Acer
 *
 */

public class AjouterPizzaService extends MenuService {
	
	public void executerCasUtilisation(/*IPizzaDao pizzaDao,*/ Scanner scanner) throws StockageException {
		System.out.println("Ajout d�une nouvelle pizza");
		//Demande et lecture du code saisie par l'utilisateur
		System.out.println("Veuillez saisir le code :");
		String code = scanner.next();	

		if(iPizzaDao==null){
			throw new ChoixDaoException();
		}else{
			if(iPizzaDao.pizzaExiste(code)){
				throw new AjoutPizzaException();
			}else {
				//Demande et lecture du libelle saisie par l'utilisateur
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String libelle = scanner.next();
				//Demande et lecture du prix saisie par l'utilisateur
				System.out.println("Veuillez saisir le prix :");
				double prix = scanner.nextDouble();		
				
				//Demande et lecture de la cat�gorie saisie par l'utilisateur			
				CategoriePizza categorieChoisie = CategoriePizza.choixCategoriePizza(scanner);
				
				if(categorieChoisie==null){
					throw new IllegalArgumentException();
				}else{
					//Ajout de la pizza dans la liste gr�ce � la m�thode ajoutPizzaDansListe 
					List<Pizza> listePizza = iPizzaDao.listeDesPizzas();
					int idPizza = listePizza.size();
					iPizzaDao.ajoutPizzaDansListe(new Pizza(idPizza, code, libelle, prix, categorieChoisie));
				}
			
			}
		}
		
	}
}
