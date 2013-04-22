package Constants;
public final class Constants{

  /**
   *  Member Variables.
   *
   *  DEBUG boolean that indicates whether to print debug statements.
   *  MAX_LOAD float that indicates the maximum load factor for hashtables.
   *  MIN_LOAD float that indicates the minimum load factor for hashtables.
   **/
  public static final boolean DEBUG=true;
  public static final float MAX_LOAD = 2.0f;
  public static final float MIN_LOAD = 0.5f;
  public static final int HASH_INIT_SIZE = 1000;

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
