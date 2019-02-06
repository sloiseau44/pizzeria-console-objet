package fr.pizzeria.console;

import java.util.Scanner;

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
		
		//Déclaration de la carte des pizzas
		Pizza[] listePizza = new Pizza[0];
		
		//Déclaration de l'objet scanner 
		Scanner scanner = new Scanner(System.in);

		//Création d'une carte de pizza de base
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(0, "PEP", "Pépéroni", 12.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(1, "MAR", "Margherita", 14.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(2, "REIN", "La Reine", 11.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(4, "CAN", "La cannibale", 12.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(5, "SAV", "La savoyarde", 13.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(6, "ORI", "L'orientale", 13.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(7, "IND", "L'indienne", 14.00));

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
				listePizza = ajoutPizzaDansListe(listePizza, new Pizza(code, libelle, prix, listePizza));

			//Modification d'une pizza
			}else if(saisie==3){
				System.out.println("Mise à jour d’une pizza");
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
						listePizza[i]= new Pizza (listePizza[i].id, nouveauCode, nouveauLibelle, nouveauPrix);
					}
				}


			//Suppression de la pizza de la carte
			}else if(saisie==4){
				System.out.println("Suppression d’une pizza");

				//Demande et lecture du code de la pizza à supprimer saisie par l'utilisateur
				System.out.println("Veuillez choisir le code de la pizza à supprimer");
				String code = scanner.next();
				
				//Suppressione de la pizza
				for(int i=0; i<listePizza.length; i++){
					if(listePizza[i].code.equals(code)){
						listePizza = supprimerPizzaDansListe(listePizza, code);
					}

				}

			//Fermeture du programme
			}else if(saisie==99){
				System.out.println("Aurevoir :(");
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}

	/**
	 * 
	 * @param listePizza (requis)
	 * @param nouvellePizza (requis)
	 * @return la liste des pizza modifiée
	 * 
	 */
	
	static Pizza[] ajoutPizzaDansListe (Pizza[] listePizza, Pizza nouvellePizza){
		Pizza[] nouvelleListePizza = new Pizza [listePizza.length+1];
		for (int i=0; i<listePizza.length; i++){
			nouvelleListePizza[i]=listePizza[i];
		}
		nouvelleListePizza[nouvelleListePizza.length-1]=nouvellePizza;
		return nouvelleListePizza;
	}

	/**
	 * 
	 * @param listePizza (requis)
	 * @param codePizzaASupprimer (requis)
	 * @return la liste des pizza modifiée
	 * 
	 */
	
	static Pizza[] supprimerPizzaDansListe (Pizza[] listePizza, String codePizzaASupprimer){
		Pizza[] nouvelleListePizza = new Pizza [listePizza.length-1];
		int iTemp = 0;
		for (int i=0; i<listePizza.length; i++){
			if(!listePizza[i].code.equals(codePizzaASupprimer)){
				nouvelleListePizza[iTemp]=listePizza[i];
				iTemp++;
			}			
		} 
		return nouvelleListePizza;
	}


}
