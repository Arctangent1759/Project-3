package dict;

/**
 *	Entry ADT for Dictionaries.
 *	Stores both keys and their corresponding values.
 **/
class Entry {

	/**
	 *	Member Variables.
	 *
	 *	key the key object stored in this entry.
	 *	value the value object that corresponds with this key.
	 **/
	private Object key;
	private Object value;

	/**
	 *	Create an Entry with a given key and corresponding value.
	 *
	 *	@param key the key held in this entry.
	 *	@param value the corresponding value to the key.
	 **/
	Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	/**
	 *	getKey() gets the key held by this entry.
	 *
	 *	@return this entry's key.
	 **/
	Object getKey() {
		return this.key;
	}

	/**
	 *	getValue() gets the value held by this entry.
	 *
	 *	@return this entry's value.
	 **/
	Object getValue() {
		return this.value;
	}
}
