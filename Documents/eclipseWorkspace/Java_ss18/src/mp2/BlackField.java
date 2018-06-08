package mp2;

/**
 * Implements a black field.
 * 
 * @author Marcus
 */
public class BlackField extends Field{ // TODO: change inheritance hierarchy
	
	/**
	 * Creates a new black field for
	 * the specified position.
	 * 
	 * @param x The x coordinate of the position.
	 * @param y The y coordinate of the position.
	 */
	// TODO: constructor
	public BlackField(int x, int y) {
		super(x, y);
	}

	
	/**
	 * Returns "b".
	 * 
	 * @return The string "b".
	 */
	// TODO: override getColor
		public String getColor() {
			return "b";
		}
}
