package fr.pizzeria.exception;

public class ChoixDaoException extends StockageException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChoixDaoException() {
		super("\n Vous n'avez pas choisi de DAO.");
	}
}
