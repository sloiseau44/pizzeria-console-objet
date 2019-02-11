package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * 
	 * @return la liste des catégories 
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
}
