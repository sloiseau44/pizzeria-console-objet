package fr.pizzeria.exception;

/**
 * Exception en cas d'erreur sur la supression de pizza
 * @author Acer
 *
 */

public class SuppressionPizzaException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  SuppressionPizzaException() {
		super("Aucune pizza avec ce code existe déjà.");
	}

}
