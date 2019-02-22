package fr.pizzeria.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.AjoutPizzaException;
import fr.pizzeria.exception.ModificationPizzaException;
import fr.pizzeria.exception.SuppressionPizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaJpaDao implements IPizzaDao {
	
	static EntityManagerFactory entityManagerFactory;
	
	public PizzaJpaDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("pizzeriadao");
	}

	@Override
	public void initialisationListePizza() throws AjoutPizzaException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override                                             
	public List<Pizza> listeDesPizzas() throws SQLException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		TypedQuery<Pizza> requête = entityManager.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> listePizza = new ArrayList<Pizza>();
		for(Pizza pizza : requête.getResultList()){
			
		}
		entityTransaction.commit();
		entityManager.close();
		return listePizza;
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Pizza> requête = entityManager.createQuery("select * from Pizza", Pizza.class);
		List<Pizza> listePizza = requête.getResultList();		
		return !listePizza.isEmpty();
	}
	

	@Override
	public void fermerDAO() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
