package fr.pizzeria.DAO;

import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.exception.ModificationPizzaException;
import fr.pizzeria.exception.SuppressionPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaJpaDao implements IPizzaDao {

	@Override
	public void initialisationListePizza() throws AjoutPizzaException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pizza> listeDesPizzas() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ajoutPizzaDansListe(Pizza pizza) throws AjoutPizzaException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierPizzaDansListe(String codePizza, Pizza pizza) throws ModificationPizzaException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerPizzaDansListe(String codePizza) throws SuppressionPizzaException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pizza trouverPizzaParCode(String codePizza) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pizzaExiste(String codePizza) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void fermerDAO() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
