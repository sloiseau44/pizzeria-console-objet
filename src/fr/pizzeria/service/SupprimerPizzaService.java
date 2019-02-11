package fr.pizzeria.service;

import java.util.Scanner;

import fr.pizzeria.exception.ChoixDaoException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.SuppressionPizzaException;

/**
 * Service de suppression d'une pizza de la carte
 * @author Acer
 *
 */

public class SupprimerPizzaService extends MenuService{
	public void executerCasUtilisation(/*/IPizzaDao pizzaDao,*/ Scanner scanner) throws StockageException {		
		if(iPizzaDao==null){
			throw new ChoixDaoException();
		}else{
			System.out.println("Suppression d’une pizza");
	
			//Demande et lecture du code de la pizza à supprimer saisie par l'utilisateur
			System.out.println("Veuillez choisir le code de la pizza à supprimer");
			String code = scanner.next();
			
			if(iPizzaDao.pizzaExiste(code)){
				iPizzaDao.supprimerPizzaDansListe(code);
			}else{
				throw new SuppressionPizzaException();
			}
		}
	}
}
