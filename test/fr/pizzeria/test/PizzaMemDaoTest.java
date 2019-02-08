package fr.pizzeria.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.DAO.PizzaMemDao;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	IPizzaDao pizzaDao;
	
	@Before
	public void setUp(){
		pizzaDao = new PizzaMemDao();
	}
	
	
	@Test
	public void testAjouterPizza() {
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a �t� ajout�", pizzaDao.pizzaExiste("TEST"));		
	}
	
		
	@Test
	public void testModifierPizza() {
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a �t� ajout�", pizzaDao.pizzaExiste("TEST"));
		pizzaDao.modifierPizzaDansListe("TEST", new Pizza("TEST","testModification",15));
		assertTrue("La pizza a �t� modifi�", pizzaDao.trouverPizzaParCode("TEST").libelle.equals("testModification"));
	}
	
	@Test 
	public void testSuppressionPizza(){
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a �t� ajout�", pizzaDao.pizzaExiste("TEST"));
		pizzaDao.supprimerPizzaDansListe("TEST");
		assertTrue("La pizza a �t� supprim�", !pizzaDao.pizzaExiste("TEST"));
		
	}
	
	
	

}
