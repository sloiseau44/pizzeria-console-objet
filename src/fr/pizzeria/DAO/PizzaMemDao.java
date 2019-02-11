package fr.pizzeria.DAO;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Acer
 * DAO de l'application de gestion de la carte des pizzas
 *
 */

public class PizzaMemDao implements IPizzaDao{
	//Déclaration de la carte des pizzas
	List<Pizza> listePizza = new ArrayList<Pizza>();

	public PizzaMemDao(){
		initialisationListePizza();
	}

	public void initialisationListePizza() {
		//Création d'une carte de pizza de base
		ajoutPizzaDansListe(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}


	public List<Pizza> listeDesPizzas() {
		return this.listePizza;
	}


	public void ajoutPizzaDansListe(Pizza nouvellePizza) {
		this.listePizza.add(nouvellePizza);		
	}


	public void modifierPizzaDansListe(String codePizzaAModifier, Pizza nouvellePizza) {
		for(Pizza pizza : listePizza){
			if(pizza.code.equals(codePizzaAModifier)){
				listePizza.set(listePizza.indexOf(pizza),nouvellePizza);
			}
		}
	}


	public void supprimerPizzaDansListe(String codePizzaASupprimer) {
		Pizza pizzaASupprimer = null;
		for(Pizza pizza : listePizza){
			if(pizza.code.equals(codePizzaASupprimer)){
				pizzaASupprimer = pizza;
			}
		}
		listePizza.remove(pizzaASupprimer);
	}


	public Pizza trouverPizzaParCode(String codePizzaATrouver) {
		Pizza pizzaATrouver = null;
		for(Pizza pizza : listePizza){
			if(pizza.code.equals(codePizzaATrouver)){
				pizzaATrouver = pizza;
			}
		}		
		return pizzaATrouver;
	}


	public boolean pizzaExiste(String codePizzaATrouver) {		
		boolean pizzaExiste = false;
		for(Pizza pizza : listePizza){
			if(pizza.code.equals(codePizzaATrouver)){
				pizzaExiste = true;
			}
		}	
		return pizzaExiste;
	}

}
