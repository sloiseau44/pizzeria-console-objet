package fr.pizzeria.model;

import java.util.Scanner;

/**
 * Enum des catégories de pizza existantes
 * @author Acer
 *
 */

public enum CategoriePizza {
	VIANDE("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	
	private String nom;
	
	private CategoriePizza(String nom){
		this.nom = nom;
	}
	
	
	public String getNom(){
		return nom;
	}
	
	/**
	 * 
	 * @param scanner
	 * @return la catégorie choisie par l'utilisateur
	 */
	
	public static CategoriePizza choixCategoriePizza (Scanner scanner){
		CategoriePizza categorieChoisie=null;
		int numCategorie = 1;
		System.out.println("Veuillez saisir la catégorie parmis les suivantes :");
		
		for(CategoriePizza categorie : values()){
			System.out.println(numCategorie+". "+categorie.getNom());
			numCategorie++;
		}
		
		int numCategorieChoisie = scanner.nextInt();
		
		numCategorie = 1;
		for(CategoriePizza categorie : values()){
			if(numCategorie==numCategorieChoisie){
				categorieChoisie = categorie;
				break;
			}
			numCategorie++;
		}
		
		return categorieChoisie;
	}
}
