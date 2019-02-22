package fr.pizzeria.test;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;

import fr.pizzeria.exception.*;
import fr.pizzeria.service.AjouterPizzaService;
import fr.pizzeria.service.ChoixDaoService;
import fr.pizzeria.service.MenuService;

public class AjouterPizzaTest {
	MenuService menuService;

	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();
	
	@Before
	public void setUp() throws SQLException, StockageException, IOException{
		systemInMock.provideLines("1", "1");
		menuService = new ChoixDaoService();
		menuService.executerCasUtilisation(new Scanner(System.in));
	}
	
	@Test (expected = AjoutPizzaException.class)
	public void testAjouterPizzaServicePizzaExiste() throws StockageException, IOException, SQLException{				
		systemInMock.provideLines("PEP");
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		ajouterPizzaService.executerCasUtilisation(new Scanner(System.in));				
	}

	@Test 
	public void testAjouterPizzaService() throws StockageException, IOException, SQLException{
		systemInMock.provideLines("TEST", "pizzatest", "13,0", "1" );
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		ajouterPizzaService.executerCasUtilisation(new Scanner(System.in));	
	
		
	}

	/*@Test (expected = ChoixDaoException.class)
	public void testAjouterPizzaServiceDaoNull() throws StockageException, IOException, SQLException{	
		systemInMock.provideLines("1", "4", "PEP");
		menuService = new ChoixDaoService();
		menuService.executerCasUtilisation(new Scanner(System.in));
		systemInMock.provideLines("PEP");
		AjouterPizzaService ajouterPizzaService = new AjouterPizzaService();
		ajouterPizzaService.executerCasUtilisation(new Scanner(System.in));				
	}*/
}
