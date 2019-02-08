package fr.pizzeria.exception;

/**
 * Exception en cas d'erreur sur l'ajout de pizza
 * @author Acer
 *
 */

public class AjoutPizzaException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AjoutPizzaException() {
		super("Une pizza avec ce code existe déjà.");
	}
}
