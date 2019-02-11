package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.service.MenuService;
import fr.pizzeria.service.MenuServiceFactory;

/**
 * 
 * @author Acer
 * Application de gestion du carte de pizzeria
 *
 */

public class PizzeriaAdminConsoleApp {
	public static void main (String[] args){

		//D�claration du param�tre de fermeture de l'application
		boolean continuer = true;

		//D�claration de l'objet scanner 
		Scanner scanner = new Scanner(System.in);

		//D�marage du menu
		do{
			//Menu utilisateur
			System.out.println("\n***** Pizzeria Administration ***** "
					+ "\n1. Lister les pizzas"
					+ "\n2. Ajouter une nouvelle pizza"
					+ "\n3. Mettre � jour une pizza"
					+ "\n4. Supprimer une pizza"
					+ "\n5. Choix de la DAO"
					+ "\n99. Sortir");

			//Lecture du choix de l'urilisateur gr�ce au scanner
			int saisie = scanner.nextInt();

			//Cr�ation du menu de service 
			MenuService menuService = MenuServiceFactory.getService(saisie);

			if(menuService != null){
				try{
					menuService.executerCasUtilisation( scanner);
				}catch(StockageException stockageException){
					System.out.println(stockageException.getMessage());
				}catch(IllegalArgumentException illegalArgumentException){
					System.out.println("\nLa cat�gorie saisie n'existe pas.");
				}
			}else{
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}


}
