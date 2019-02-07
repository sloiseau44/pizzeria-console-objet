package fr.pizzeria.service;

/**
 * Factory de l'application de gestion de la carte des pizzas
 * @author Acer
 *
 */

public class MenuServiceFactory {
	public static MenuService getService(int choixUtilisateur){
		MenuService menuService = null;
		//Liste des pizzas
		if(choixUtilisateur==1){
			menuService = new ListerPizzasService();

			//Ajout d'une nouvelle pizza
		}else if(choixUtilisateur==2){
			menuService = new AjouterPizzaService();

			//Modification d'une pizza
		}else if(choixUtilisateur==3){
			menuService = new ModifierPizzaService();

			//Suppression de la pizza de la carte
		}else if(choixUtilisateur==4){
			menuService = new SupprimerPizzaService();

			//Fermeture du programme
		}else if(choixUtilisateur==99){
			System.out.println("Aurevoir :(");
		}
		return menuService;
	}
}
