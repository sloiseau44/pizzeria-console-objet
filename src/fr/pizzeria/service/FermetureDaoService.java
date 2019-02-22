package fr.pizzeria.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import fr.pizzeria.exception.StockageException;

public class FermetureDaoService extends MenuService{

	
	public void executerCasUtilisation(Scanner scanner) throws StockageException, IOException, SQLException {
		iPizzaDao.fermerDAO();		
	}

}
