package dict;

/**
 *	Abstract class defining an interface and partial implementation
 *  for an (unordered) dictionary ADT.
 */
public abstract class Dictionary {

	/**
	 *	Member variables:
	 *	size the size of this Dictionary.
	 **/
	protected int size;

	/**
	 *	size() gives the number of entries in this dictionary.
	 *	Note: This does not return the total size taken up by this
	 *	dictionary, just the number of entries.
	 *
	 *	@return the number of entries in this Dictionary.
	 **/
	public int size() {
		return this.size;
	}

	/**
	 *	isEmpty() indicates whether this dictionary is empty or not.
	 *	A return value of means this dictionary contains zero items.
	 *
	 *	@return whether this dictionary is empty or not.
	 **/
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 *	insert() inserts a key-value pair into this dictionary.
	 *	For every key there is an associated value in this dictionary.
	 *
	 *	@param key the key object to be inserted into this dictionary.
	 *	@param value the value object associated with the corresponding key.
	 **/
	public abstract void insert(Object key, Object value);

	/**
	 *	find() returns the value associated with the given key. 
	 *	If the given key is not in the dictionary, null is returned.
	 *
	 *	@param key the key to lookup in this dictionary.
	 *	@return the corresponding value object.
	 **/
	public abstract Object find(Object key);
}
