package fr.pizzeria.exception;

/**
 * Exception en cas d'erreur sur la modification de pizza
 * @author Acer
 *
 */

public class ModificationPizzaException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModificationPizzaException() {
		super("Aucune pizza avec ce code existe déjà.");
	}

}
