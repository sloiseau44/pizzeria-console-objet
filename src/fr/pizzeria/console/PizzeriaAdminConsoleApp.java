package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

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
				System.out.println("Liste des pizzas");
				//Affichage de la liste
				Pizza[] listePizza = pizzaMemDao.listeDesPizzas();
				for(int i=0; i<listePizza.length; i++){
					System.out.println(listePizza[i].toString());					
				}
				
			//Ajout d'une nouvelle pizza
			}else if(saisie==2){
				System.out.println("Ajout d’une nouvelle pizza");
				//Demande et lecture du code saisie par l'utilisateur
				System.out.println("Veuillez saisir le code :");
				String code = scanner.next();
				//Demande et lecture du libelle saisie par l'utilisateur
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String libelle = scanner.next();
				//Demande et lecture du prix saisie par l'utilisateur
				System.out.println("Veuillez saisir le prix :");
				double prix = scanner.nextDouble();		
				
				//Ajout de la pizza dans la liste grâce à la méthode ajoutPizzaDansListe 
				pizzaMemDao.ajoutPizzaDansListe(new Pizza(code, libelle, prix, pizzaMemDao.listeDesPizzas()));

			//Modification d'une pizza
			}else if(saisie==3){
				System.out.println("Mise à jour d’une pizza");
				Pizza[] listePizza = pizzaMemDao.listeDesPizzas();
				for(int i=0; i<listePizza.length; i++){
					System.out.println(listePizza[i].toString());					
				}
				
				//Demande et lecture du code de la pizza à modifier saisie par l'utilisateur
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String code = scanner.next();
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
						pizzaMemDao.modifierPizzaDansListe(code, new Pizza(nouveauCode,nouveauLibelle,nouveauPrix,listePizza));
					}
				}


			//Suppression de la pizza de la carte
			}else if(saisie==4){
				System.out.println("Suppression d’une pizza");

				//Demande et lecture du code de la pizza à supprimer saisie par l'utilisateur
				System.out.println("Veuillez choisir le code de la pizza à supprimer");
				String code = scanner.next();
				
				pizzaMemDao.supprimerPizzaDansListe(code);

			//Fermeture du programme
			}else if(saisie==99){
				System.out.println("Aurevoir :(");
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}


}
