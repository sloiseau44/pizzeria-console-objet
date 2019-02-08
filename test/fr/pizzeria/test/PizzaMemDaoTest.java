package fr.pizzeria.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.DAO.IPizzaDao;
import fr.pizzeria.DAO.PizzaMemDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzaMemDaoTest {
	IPizzaDao pizzaDao;
	
	@Before
	public void setUp(){
		pizzaDao = new PizzaMemDao();
	}
	
	
	@Test
	public void testAjouterPizza() throws StockageException {
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a été ajouté", pizzaDao.pizzaExiste("TEST"));		
	}
	
		
	@Test
	public void testModifierPizza() throws StockageException {
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a été ajouté", pizzaDao.pizzaExiste("TEST"));
		pizzaDao.modifierPizzaDansListe("TEST", new Pizza("TEST","testModification",15));
		assertTrue("La pizza a été modifié", pizzaDao.trouverPizzaParCode("TEST").libelle.equals("testModification"));
	}
	
	@Test 
	public void testSuppressionPizza() throws StockageException{
		pizzaDao.ajoutPizzaDansListe(new Pizza("TEST","test",15));
		assertTrue("La pizza a été ajouté", pizzaDao.pizzaExiste("TEST"));
		pizzaDao.supprimerPizzaDansListe("TEST");
		assertTrue("La pizza a été supprimé", !pizzaDao.pizzaExiste("TEST"));
		
	}
	
	
	

}
