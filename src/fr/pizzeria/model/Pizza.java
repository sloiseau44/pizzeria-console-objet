package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String libelle;
	double prix;
	
	public Pizza(String code, String libelle, double prix) {
		this.id ++;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Pizza(int id, String code, String libelle, double prix) {
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	@Override
	public String toString() {
		return new String(this.code+" -> "+this.libelle+" ("+this.prix+" €)");
	}
	
	/*
	public int getId(){
		return this.id;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getLibelle(){
		return this.libelle;
	}
	
	public double getPrix(){
		return this.prix;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setCode(String code){
		this.code = code;
	}
	
	public void setLibelle(String libelle){
		this.libelle = libelle;
	}
	
	public void setPrix(double prix){
		this.prix = prix;
	}*/
	
}
