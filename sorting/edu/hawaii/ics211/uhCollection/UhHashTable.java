package edu.hawaii.ics211.uhCollection;

import java.util.Random;

public class UhHashTable<K, V> {
  private Entry<K, V>[] table;
  private int numItems;
  private int numDeletes;
  private double LOAD_FACTOR;
  private final Entry<K, V> DELETED = new Entry<K, V>(null, null); 
  private Random random;
  
  /**Contains key/value pairs for a hash table.
   * @param <K> Key
   * @param <V> Value
   */
  protected static class Entry<K, V> {
	/** The key */  
	protected K key;
	/** The value */  
	protected V value;
	/** The index */  
	protected int index;
	
	/**Creates a new blank Entry with null as key/value specifics.
	 */
	public Entry() {
	  this.key = null;
	  this.value = null;
	  this.index = -1;
	}
	
	/**Creates a new key/value pair.
	 * @param key The key.
	 * @param value The value.
	 */
	public Entry(K key, V value) {
	  this.key = key;
	  this.value = value;
	  this.index = -1;
	}
	
	/**Retrieves the key.
	 * @return The key.
	 */
	public K getKey() {
	  return key;
	}
	
	/**Retrieves the value.
	 * @return The value.
	 */
	public V getValue() {
	  return value;	
	}
	
	/**Sets the value.
	 * @param val The new value.
	 * @return The old value.
	 */
	public V setValue(V val) {
	  V oldVal = value;
	  value = val;
	  return oldVal;
	}
  }
  
  /**Constructs an empty Hash Table with the specified capacity.
   * @param initialCapacity Initial size of the HashTable
   */
  public UhHashTable(final int initialCap) {
	if (initialCap <= 0) {
	  throw new IllegalArgumentException();
	}
	numItems = 0; //Initial number of items in HashTable is 0;
	LOAD_FACTOR = 1.0;
	table = new Entry[initialCap];
	random = new Random();
	random.setSeed(100);
  }
  
  /**Constructs an empty Hash Table with specific capacity and Load Factor.
   * @param initialCap Initial size of the HashTable
   * @param loadFact The maximum Load Factor of the HashTable
   */
  public UhHashTable(final int initialCap, final double loadFact) {
    if (initialCap <= 0) {
	  throw new IllegalArgumentException();
	}
	numItems = 0; //Initial number of items in HashTable is 0;
	LOAD_FACTOR = loadFact;
	table = new Entry[initialCap];
	random = new Random();
	random.setSeed(100);
  }
  
  /**Return the value associated to key or null if the key doesn't exist
   * @param key 
   * @return
   */
  public V get(K key) {
    //Find the first table element that is empty
	//or the table element that contains the key.
	int index = find(key);
	
	//If the search is successful, return the value.
	if ((table[index] != null) && (table[index].key.equals(key))) {
	  return table[index].value;
	} else {
	  for (int i = 0; i < table.length; i++) { //key not found.
		  index++;
		  index = index % table.length;
	    if((table[index] != null) && (table[index].key.equals(key))) {
	  	  return table[index].value;
	    }
	  }
	}
	return null;
  }
  
  /** Adds key/value pairs to the Hash Table.
   * If the key does not exist in the table when this method is called, null is returned.
   * If the key  does  exist, the old value is replaced in with the new value AND the old value is returned.
   * TODO If the hash table is full, this method must throw an  ArrayIndexOutOfBoundsException  exception.
   * @param key Number to be hashed and placed in the table.
   * @param value The information stored w/ set key.
   * @return null.
   */
  public V put(K key, V value) {
    //Find the first table element that is empty
	//or the table element that contains the key.
	int index = find(key);  
	
	//If an empty element was found, insert new entry.
	if (table[index] == null) {
	  table[index] = new Entry<K, V>(key, value);
	  numItems++;
	 
	  //Check rehash if needed.
	  double loadThreshold = (double) (numItems + numDeletes) / table.length;
	  if (loadThreshold >= LOAD_FACTOR) {
		System.out.println("Preparing to rehash table!");  
	    rehash();  
	  }
	  return null;
	}
	
	//Replaces value at specified index if the keys are the same.
	if (table[index].key == key) {
	  V oldVal = table[index].value;
	  table[index].value = value;
	  return oldVal;
	}

	//Scenario 2
    if (getHashCode(table[index].key) == getHashCode(key)) {
	  int newIndex = randomIndex(); //Create a random index that isn't filled.

	  table[newIndex] = new Entry<K, V>(key,value);
	  numItems++;
	  table[index].index = newIndex; //Change head key to have the index of next key
	  return null;
	}
	throw new ArrayIndexOutOfBoundsException("The Hash Table is full!");
  }

/** Removes the entry in the hash tables identified by key.
   * If the key exists in the hash table, the associated value is returned.
   * If the key does not exist, null is returned.
   * @param key The specified key to remove from the Hash Table.
   * @return Return either key or null.
   */
  public V remove(K key) {
	if (key == null) {
	  return null;	
	}
	//Find the key.
    int index = getKeyIndex(key);
    if (index == -1) {
      return null;	
    }
    
    //Remove something at the end of the chain.
    if (table[index].index == -1) {
      delete(index);
    }
    return null;
  }
  
  /**Removes a key/value couple from the Hash Table.
   * @param index the specific index to remove key/value pairs.
   */
  private void delete(final int index) {
  	table[index] = null;
  	numDeletes++;
  	numItems--;
  }
  
  /** Returns a boolean whether the Hash Table is empty or not.
   * @return True if size = capacity, false otherwise.
   */
  public boolean isFull() {
	if (numItems < 0) {
	  throw new RuntimeException();	
	}
	return (this.getSize() == this.getCapacity());
  }
  
  /** Returns a boolean whether the Hash Table is empty or not.
   * @return True if no elements are in the hash table, false otherwise.
   */
  public boolean isEmpty() {
    if (numItems < 0) { //size can't be less then 0.
	  throw new RuntimeException();
	}
	return (this.getSize() == 0);
  }
  
  /** Returns the index of a specific key in the Hash Table.
   * @param key Specific key to get the index of.
   * @return Actual index of the key in the internal array used to store the Hash Table.
   */
  public int getKeyIndex(K key) {
	if (key == null) {
      return -1;
    }
	int hash = getHashCode(key);
	if(table[hash] == null) {
	  return -1;	
	}
	while (table[hash].index != -1) {
		hash = table[hash].index;  
	}
	return hash;
  }
  
  /** Returns the current number of key/values stored in the Hash Table.
   * @return Number of key/values in table.
   */
  public int getSize() {
	if (numItems < 0) { //If there is some sort of error with the numItems.
		throw new RuntimeException();
	}

	//Count the number of Items in the HashTable.
	//null means the index is empty so loop won't count it.
	//Only counts what isn't null.
	int count = 0;
	for (int i = 0; i < table.length; i++) {
	  if(table[i] != null) {
	    count++;
	  }
	}
	
	if (count != numItems) { //If count actually doesn't equal numItems.
	  throw new RuntimeException();
	}
    return (this.numItems);
  }
  
  /** Returns the total number of entries in the Hash Table.
   * @return Number of space allocated for the table.
   */
  public int getCapacity() {
	int capacity = table.length;
    return (capacity);
  }
  
  public int getHashCode (K key) {
    int index = key.hashCode() % table.length;
		
    //If the index is negative by chance make it positive.
	if (index < 0) {
	  index += table.length;
	}	
	return index;
  }
  
  /**Find an index for a particular key.  If the key exists, then this method
   * should find the key and return it.  If the key does not exist, then this
   * method should return the best key to insert the entry into.
   * @param key The key to locate.
   * @return An index to the key or the key to hang onto.
   */
  public int find(K key) {
	  int index = getHashCode(key);
	
	//Scenario 1
	if (table[index] == null) {
	  System.out.println("Got a Scenario 1 index: " + index );	
	  return index;	
	}
	
	//Replacement
	if (table[index].key == key) {
	  System.out.println("Got a Replacement index: " + index);	
	  return index;
	}
    
	//Scenario 2
	if (getHashCode(table[index].key) == getHashCode(key)) {
      while (table[index].key != key && table[index].index != -1) {
    	index = table[index].index; //S2 Traverse  
      }
  	  System.out.println("Got a Scenario 2 index: " + index);
      return index;
	}
	
	//Scenario 3
	if (getHashCode(table[index].key) != getHashCode(key)) {
      while (table[index] != null && getHashCode(table[index].key) != getHashCode(key)) {
        index++;
        index = index % table.length;
      }
      System.out.println("Got a Scenario 3 index: " + index);
      return index;
	}
	return index;  
  }
  
  /** Allows the user to visually see the output of the Hash Table on the Console.
   */
  public void print() {
    System.out.println("Capacity = " + "[" + getCapacity() + "]");
    System.out.println("Size = " + "[" + getSize() + "]");
    for (int i = 0; i < table.length; i++) {
      if (table[i] != null) {
      	System.out.println(i + ": key = [" + table[i].key + "] value = [" 
      						 + table[i].value + "] index = [" + table[i].index + "]");  
      }
      else {
    	System.out.println(i + ": null");	  
      }
    }
  }
  
  /** Create a random index based on the length of the Hash Table.
   * @return A random Index.
   */
  public int randomIndex() {
	  int rando = random.nextInt(table.length);

	  while (table[rando] != null) {
	    rando++;
	    rando = rando % table.length;
	  }
	  assert table[rando] == null;
	  return rando;
  }
  
  /**Expands the table size when loadThreshold exceeds LOAD_FACTOR.
   * The size of the table is doubled and is an odd integer.
   * Each non-deleted entry from the original table is reinserted into the expanded table.
   * The value of numKeys is reset to the number of items actually inserted.
   * numDeletes is reset to 0.
   */
  public void rehash() {
	//Save a reference to oldTable.  
	Entry<K, V>[] oldTable = table;
	//Double capacity of this table.
	table = new Entry[2* oldTable.length];
	
	//Reinsert all items in oldTable into expanded table.
	numItems = 0;
	numDeletes = 0;
	for (int i = 0; i < oldTable.length; i++) {
	  if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
	    //Insert entry in expanded table.
		put(oldTable[i].key, oldTable[i].value);  
	  }
	}
	
  }
}
