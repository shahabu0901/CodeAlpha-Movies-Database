package CodeAlpha.Movies.Database.Exception;

public class MoviesNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2642105626711592057L;

	public MoviesNotFoundException(String message) {
		super(message);
	}
}
