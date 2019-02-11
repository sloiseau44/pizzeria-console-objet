package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.DAO.PizzaDaoFactory;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.*;

/**
 * 
 * @author Acer
 * Application de gestion du carte de pizzeria
 *
 */

public class PizzeriaAdminConsoleApp {
	public static void main (String[] args){

		//Déclaration du paramètre de fermeture de l'application
		boolean continuer = true;

		//Initialisation de la DAO
		
		IPizzaDao pizzaDao = PizzaDaoFactory.getDao(1);



		//Déclaration de l'objet scanner 
		Scanner scanner = new Scanner(System.in);

		//Démarage du menu
		do{
			//Menu utilisateur
			System.out.println("\n***** Pizzeria Administration ***** "
					+ "\n1. Lister les pizzas"
					+ "\n2. Ajouter une nouvelle pizza"
					+ "\n3. Mettre à jour une pizza"
					+ "\n4. Supprimer une pizza"
					+ "\n99. Sortir");

			//Lecture du choix de l'urilisateur grâce au scanner
			int saisie = scanner.nextInt();

			//Création du menu de service 
			MenuService menuService = MenuServiceFactory.getService(saisie);

			if(menuService != null){
				try{
					menuService.executerCasUtilisation(pizzaDao, scanner);
				}catch(StockageException stockageException){
					System.out.println(stockageException.getMessage());
				}catch(IllegalArgumentException illegalArgumentException){
					System.out.println("\nLa catégorie saisie n'existe pas.");
				}
			}else{
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}


}
