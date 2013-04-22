package Constants;
/**
 *  Constants class is a container for all constants.
 **/
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

	/**
	 *  print() prints object o to standard error. 
   *  If and only if DEBUG is set to true. This
   *  ensures that no extra debug statements will 
   *  mess with output to standard out.
   *
	 *  @param o object to be printed.
	 */
	public static final void print(Object o){
		if (DEBUG){
			System.err.println(o);
		}
	}
}
