package fr.pizzeria.console;

import java.util.Scanner;

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
		PizzaMemDao pizzaMemDao = new PizzaMemDao();
		pizzaMemDao.initialisationListePizza(); 
		
				
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
			
			//Exécution de la foncitonnalité choisie 
			
			//Liste des pizzas
			if(saisie==1){
				ListerPizzasService listerPizzasService = new ListerPizzasService();
				listerPizzasService.executerCasUtilisation(pizzaMemDao, scanner);
				
			//Ajout d'une nouvelle pizza
			}else if(saisie==2){
				AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
				ajouterPizzaService.executerCasUtilisation(pizzaMemDao, scanner);
				
			//Modification d'une pizza
			}else if(saisie==3){
				ModifierPizzaService modifierPizzaService = new ModifierPizzaService();
				modifierPizzaService.executerCasUtilisation(pizzaMemDao, scanner);
				
			//Suppression de la pizza de la carte
			}else if(saisie==4){
				SupprimerPizzaService supprimerPizzaService = new SupprimerPizzaService();
				supprimerPizzaService.executerCasUtilisation(pizzaMemDao, scanner);

			//Fermeture du programme
			}else if(saisie==99){
				System.out.println("Aurevoir :(");
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}


}
