package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.DAO.PizzaMemDao;
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
		IPizzaDao pizzaDao = new PizzaMemDao();
		
		
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
			
			MenuService menuService = MenuServiceFactory.getService(saisie);
			
			if(menuService != null){
				menuService.executerCasUtilisation(pizzaDao, scanner);
			}else{
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}


}
