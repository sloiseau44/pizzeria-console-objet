package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Enum des cat�gories de pizza existantes
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
	
	/**
	 * 
	 * @return la liste des cat�gories 
	 */
	
	public static List<String> listerCategorie(){
		List<String> listeCategories = new ArrayList<String>();
		for(CategoriePizza categorie : values()){
			listeCategories.add(categorie.nom);
		}
		return listeCategories;
	}
	
	public String getNom(){
		return nom;
	}
	
	/**
	 * 
	 * @param scanner
	 * @return la cat�gorie choisie par l'utilisateur
	 */
	
	public static CategoriePizza choixCategoriePizza (Scanner scanner){
		CategoriePizza categorieChoisie=null;
		int numCategorie = 1;
		System.out.println("Veuillez saisir la cat�gorie parmis les suivantes :");
		List<String> listeCategories = CategoriePizza.listerCategorie();
		
		for(String categorie : listeCategories){
			System.out.println(numCategorie+". "+categorie);
			numCategorie++;
		}
				
		int numCategorieChoisie = scanner.nextInt();
		
		numCategorie = 1;
		for(CategoriePizza categorie : values()){
			if(numCategorie==numCategorieChoisie){
				categorieChoisie = categorie;
			}
			numCategorie++;
		}
		
		return categorieChoisie;
	}
}
