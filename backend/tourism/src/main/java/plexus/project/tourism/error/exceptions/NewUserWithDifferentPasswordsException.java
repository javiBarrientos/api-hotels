package plexus.project.tourism.error.exceptions;

public class NewUserWithDifferentPasswordsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 720007200555658583L;

	public NewUserWithDifferentPasswordsException() {
		super("Las contraseñas no coinciden");
	}
}
