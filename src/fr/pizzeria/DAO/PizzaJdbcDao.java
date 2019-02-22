package fr.pizzeria.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.exception.ModificationPizzaException;
import fr.pizzeria.exception.SuppressionPizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * 
 * @author Acer
 * Gesstion des données par une base de données relationnelles
 *
 */
public class PizzaJdbcDao implements IPizzaDao{	
	static Connection connection;
	

	public PizzaJdbcDao() throws ClassNotFoundException, SQLException, IOException{
		final Properties prop = new Properties();
		InputStream input = null;

		input = new FileInputStream("jdbc.properties");
		prop.load(input);

		String url = prop.getProperty("db.url");
		String username = prop.getProperty("db.username");
		String password = prop.getProperty("db.password");

		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url,username,password);
	}

	public void initialisationListePizza() throws AjoutPizzaException, SQLException{
		ajoutPizzaDansListe(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		ajoutPizzaDansListe(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		ajoutPizzaDansListe(new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> listeDesPizzas() throws SQLException {
		List<Pizza> listePizza = new ArrayList<Pizza>();
		Statement statement = connection.createStatement();
		ResultSet rsListePizza = statement.executeQuery("select * from pizzeriadao.pizza");
		
		while(rsListePizza.next()){
			listePizza.add(new Pizza(rsListePizza.getInt(1), rsListePizza.getString(2), rsListePizza.getString(3), rsListePizza.getDouble(4), CategoriePizza.recupereCategorie(rsListePizza.getString(5))));
		}
		
		return listePizza;
	}

	@Override
	public void ajoutPizzaDansListe(Pizza pizza) throws AjoutPizzaException, SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("INSERT INTO pizzeriadao.pizza (idPizza, code, libelle, prix, categorie) VALUES ("+pizza.getId()+",\""+pizza.getCode()+"\",\""+pizza.getLibelle()+"\","+pizza.getPrix()+",\""+pizza.getCategorie().getNom().toUpperCase()+"\")");
	}

	@Override
	public void modifierPizzaDansListe(String codePizza, Pizza pizza) throws ModificationPizzaException, SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate("update pizzeriadao.pizza set idPizza="+pizza.getId()+", code=\""+pizza.getCode()+"\", libelle=\""+pizza.libelle+"\", prix="+pizza.getPrix()+", categorie=\""+pizza.getCategorie().getNom().toUpperCase()+"\" where code=\""+codePizza+"\"");

	}

	@Override
	public void supprimerPizzaDansListe(String codePizza) throws SuppressionPizzaException, SQLException {
		Statement statement = connection.createStatement();		
		statement.executeUpdate("delete from pizzeriadao.pizza  where code=\""+codePizza+"\"");
	}

	@Override
	public Pizza trouverPizzaParCode(String codePizza) throws SQLException {
		Pizza pizza =null;
		Statement statement = connection.createStatement();
		ResultSet rsListePizza = statement.executeQuery("select * from pizzeriadao.pizza");
		
		while(rsListePizza.next()){
			pizza = new Pizza(rsListePizza.getInt(1), rsListePizza.getString(2), rsListePizza.getString(3), rsListePizza.getDouble(4), CategoriePizza.recupereCategorie(rsListePizza.getString(5)));
		}
		
		return pizza;
	}

	@Override
	public boolean pizzaExiste(String codePizza) throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet rsListePizza = statement.executeQuery("select * from pizzeriadao.pizza where code=\""+codePizza+"\"");
		return rsListePizza.next();
	}
	
	public void fermerDAO() throws SQLException{
		connection.close();
	}

}
