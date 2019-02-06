package fr.pizzeria.model;

public class Pizza {
	public int id;
	public String code;
	String libelle;
	double prix;

	public Pizza(String code, String libelle, double prix, Pizza[] listePizza) {		
		int idTemp = Integer.MIN_VALUE;
		for(int i=0; i<listePizza.length; i++){
			if(listePizza[i].id>idTemp){
				idTemp = listePizza[i].id;
			}
		}
		this.id = idTemp+1;
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
		return new String(this.id+" "+this.code+" -> "+this.libelle+" ("+this.prix+" €)");
	}


	/*
	public int getId(){
		return id;
	}

	public String getCode(){
		return code;
	}

	public String getLibelle(){
		return libelle;
	}

	public double getPrix(){
		return prix;
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
