package fr.pizzeria.DAO;

import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Acer
 * DAO de l'application de gestion de la carte des pizzas
 *
 */

public class PizzaMemDao implements IPizzaDao{
	//Déclaration de la carte des pizzas
	Pizza[] listePizza = new Pizza[0];

	public PizzaMemDao(){
		initialisationListePizza();
	}
	
	public void initialisationListePizza() {
		//Création d'une carte de pizza de base
		ajoutPizzaDansListe(new Pizza(0, "PEP", "Pépéroni", 12.50));
		ajoutPizzaDansListe(new Pizza(1, "MAR", "Margherita", 14.00));
		ajoutPizzaDansListe(new Pizza(2, "REIN", "La Reine", 11.50));
		ajoutPizzaDansListe(new Pizza(3, "FRO", "La 4 fromages", 12.00));
		ajoutPizzaDansListe(new Pizza(4, "CAN", "La cannibale", 12.50));
		ajoutPizzaDansListe(new Pizza(5, "SAV", "La savoyarde", 13.00));
		ajoutPizzaDansListe(new Pizza(6, "ORI", "L'orientale", 13.50));
		ajoutPizzaDansListe(new Pizza(7, "IND", "L'indienne", 14.00));
	}


	public Pizza[] listeDesPizzas() {
		return this.listePizza;
	}


	public void ajoutPizzaDansListe(Pizza nouvellePizza) {
		Pizza[] nouvelleListePizza = new Pizza [listePizza.length+1];
		for (int i=0; i<listePizza.length; i++){
			nouvelleListePizza[i]=listePizza[i];
		}
		nouvelleListePizza[nouvelleListePizza.length-1]=nouvellePizza;
		this.listePizza = nouvelleListePizza;			
	}


	public void modifierPizzaDansListe(String codePizzaAModifier, Pizza nouvellePizza) {
		for(int i=0; i<listePizza.length; i++){
			if(listePizza[i].code.equals(codePizzaAModifier)){
				listePizza[i]= new Pizza (listePizza[i].id, nouvellePizza.code, nouvellePizza.libelle, nouvellePizza.prix);
			}
		}	

	}


	public void supprimerPizzaDansListe(String codePizzaASupprimer) {
		Pizza[] nouvelleListePizza = new Pizza [listePizza.length-1];
		int iTemp = 0;
		for (int i=0; i<listePizza.length; i++){
			if(!listePizza[i].code.equals(codePizzaASupprimer)){
				nouvelleListePizza[iTemp]=listePizza[i];
				iTemp++;
			}			
		} 
		this.listePizza = nouvelleListePizza;	

	}


	public Pizza trouverPizzaParCode(String codePizzaATrouver) {		
		Pizza pizzaATrouver = null;
		if(pizzaExiste(codePizzaATrouver)){
			for (int i=0; i<listePizza.length; i++){
				if(!listePizza[i].code.equals(codePizzaATrouver)){
					pizzaATrouver = listePizza[i];
				}			
			}
		}else{
			System.out.println("Aucune pizza avec le code "+codePizzaATrouver+" existe.");
		}
		return pizzaATrouver;
	}


	public boolean pizzaExiste(String codePizzaATrouver) {
		boolean pizzaExiste = false;
		for (int i=0; i<listePizza.length; i++){
			if(listePizza[i].code.equals(codePizzaATrouver)){
				pizzaExiste = true;
			}			
		} 		
		return pizzaExiste;
	}

}
