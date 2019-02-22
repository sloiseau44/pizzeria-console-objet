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
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaJpaDao implements IPizzaDao {
	
	static EntityManagerFactory entityManagerFactory;
	
	public PizzaJpaDao() {
		entityManagerFactory = Persistence.createEntityManagerFactory("pizzeriadao");
	}

	@Override
	public void initialisationListePizza() throws AjoutPizzaException, SQLException {
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		TypedQuery<Pizza> requête = entityManager.createQuery("select p from Pizza p", Pizza.class);
		List<Pizza> listePizza = new ArrayList<Pizza>();
		for(Pizza pizza : requête.getResultList()){
			listePizza.add(pizza);
		}
		entityTransaction.commit();
		entityManager.close();
		return listePizza;
	}

	@Override
	public void ajoutPizzaDansListe(Pizza pizza) throws AjoutPizzaException, SQLException {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(pizza);
		entityTransaction.commit();
		entityManager.close();
		
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
