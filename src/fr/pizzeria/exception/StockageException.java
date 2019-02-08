package fr.pizzeria.exception;

/**
 * Classe mère des excpetion de le gestion de carte des pizzas
 * @author Acer
 *
 */

public class StockageException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StockageException() {
		
	}
	
	public StockageException(String message){
		super(message);
	}
	
	
}
