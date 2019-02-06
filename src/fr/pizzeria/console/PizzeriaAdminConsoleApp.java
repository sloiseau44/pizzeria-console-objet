package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {
	public static void main (String[] args){
		boolean continuer = true;
		Pizza[] listePizza = new Pizza[0];
		Scanner scanner = new Scanner(System.in);

		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(0, "PEP", "Pépéroni", 12.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(1, "MAR", "Margherita", 14.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(2, "REIN", "La Reine", 11.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(3, "FRO", "La 4 fromages", 12.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(4, "CAN", "La cannibale", 12.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(5, "SAV", "La savoyarde", 13.00));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(6, "ORI", "L'orientale", 13.50));
		listePizza = ajoutPizzaDansListe(listePizza, new Pizza(7, "IND", "L'indienne", 14.00));

		do{
			System.out.println("\n***** Pizzeria Administration ***** "
					+ "\n1. Lister les pizzas"
					+ "\n2. Ajouter une nouvelle pizza"
					+ "\n3. Mettre à jour une pizza"
					+ "\n4. Supprimer une pizza"
					+ "\n99. Sortir");


			int saisie = scanner.nextInt();

			if(saisie==1){
				System.out.println("Liste des pizzas");
				for(int i=0; i<listePizza.length; i++){
					System.out.println(listePizza[i].toString());					
				}
			}else if(saisie==2){
				System.out.println("Ajout d’une nouvelle pizza");
				System.out.println("Veuillez saisir le code :");
				String code = scanner.next();
				System.out.println("Veuillez saisir le nom (sans espace) :");
				String libelle = scanner.next();
				System.out.println("Veuillez saisir le prix :");
				double prix = scanner.nextDouble();
				listePizza = ajoutPizzaDansListe(listePizza, new Pizza(code, libelle, prix, listePizza));

			}else if(saisie==3){
				System.out.println("Mise à jour d’une pizza");
				for(int i=0; i<listePizza.length; i++){
					System.out.println(listePizza[i].toString());					
				}
				System.out.println("Veuillez choisir le code de la pizza à modifier.");
				String code = scanner.next();
				System.out.println("Veuillez saisir le nouveau code :");
				String nouveauCode = scanner.next();
				System.out.println("Veuillez saisir le nouveau nom (sans espace) :");
				String nouveauLibelle = scanner.next();
				System.out.println("Veuillez saisir le nouveau prix :");
				double nouveauPrix = scanner.nextDouble();


				for(int i=0; i<listePizza.length; i++){
					if(listePizza[i].code.equals(code)){
						listePizza[i]= new Pizza (listePizza[i].id, nouveauCode, nouveauLibelle, nouveauPrix);
					}
				}


			}else if(saisie==4){
				System.out.println("Suppression d’une pizza");
				System.out.println("Veuillez choisir le code de la pizza à supprimer");
				String code = scanner.next();
				for(int i=0; i<listePizza.length; i++){
					if(listePizza[i].code.equals(code)){
						listePizza = supprimerPizzaDansListe(listePizza, code);
					}

				}

			}else if(saisie==99){
				System.out.println("Aurevoir :(");
				continuer = false;
			}
		}while(continuer);
		scanner.close();
	}

	public static Pizza[] ajoutPizzaDansListe (Pizza[] listePizza, Pizza nouvellePizza){
		Pizza[] nouvelleListePizza = new Pizza [listePizza.length+1];
		for (int i=0; i<listePizza.length; i++){
			nouvelleListePizza[i]=listePizza[i];
		}
		nouvelleListePizza[nouvelleListePizza.length-1]=nouvellePizza;
		return nouvelleListePizza;
	}

	public static Pizza[] supprimerPizzaDansListe (Pizza[] listePizza, String codePizzaASupprimer){
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
