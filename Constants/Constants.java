package Constants;
public final class Constants{

	public static final boolean DEBUG=true;

	/**
	 *
	 * Prints object o to standard error.
	 * @param o The object to be printed
	 *
	 */
	public static final void print(Object o){
		if (DEBUG){
			System.err.println(o);
		}
	}
}
