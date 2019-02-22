package fr.pizzeria.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import fr.pizzeria.DAO.PizzaDaoFactory;
import fr.pizzeria.exception.StockageException;


public class ChoixDaoService extends MenuService{

	public void executerCasUtilisation(Scanner scanner) throws StockageException, IOException, SQLException {
		System.out.println("\n* Choix de la DAO * "
				+ "\n1. Mémoire"
				+ "\n2. JDBC"
				+ "\n3. JPA");
		int saisie = scanner.nextInt();
		
		try {
			iPizzaDao = PizzaDaoFactory.getDao(saisie);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
		System.out.println("\nInitialiser la base de données? "
				+ "\n1. Oui"
				+ "\n2. Non");
		
		saisie = scanner.nextInt();
		if(saisie==1){
			iPizzaDao.initialisationListePizza();
		}
	}

}
