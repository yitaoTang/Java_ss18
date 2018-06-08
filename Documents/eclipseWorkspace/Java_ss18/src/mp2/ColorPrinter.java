package mp2;

/**
 * Implements a visitor that prints the field colors. 
 * 
 * @author Marcus
 */
public class ColorPrinter implements Visitor{ // TODO: add interface
	
	/**
	 * Prints the field color at the current position
	 * using System.out.print (not println).
	 */
	// TODO: override Visitor.nextField
	public void nextField(Field field) {
		System.out.print(field.getColor());
	}
	/**
	 * Prints a new line using System.out.println.
	 */
	// TODO: override Visitor.nextField
		public void nextRow() {
			System.out.println();
	}

}
