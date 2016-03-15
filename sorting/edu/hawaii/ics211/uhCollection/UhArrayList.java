package edu.hawaii.ics211.uhCollection;

import java.util.Arrays;

import edu.hawaii.ics211.uhCollection.UhBinaryTree.UhBinaryTreeNode;
import edu.hawaii.ics211.uhLogger.Jog;

/** @author Blake Larson
 * 
 * Class for an Array List that holds objects.
 *
 */
public class UhArrayList {
	private static final int INITIAL_CAPACITY = 4;
	private int capacity;
	private Object[] theArray = null;
	private int size;
	
	/**Constructs a UhArrayList with default capacity of 4.
	 */
	public UhArrayList(){
		this(INITIAL_CAPACITY);
	}
	
	/**Constructs a UhArrayList that takes in an initial capacity as a parameter.
	 * @param initialCapacity The new default capacity for the array.
	 */
	public UhArrayList(final int initialCapacity){
		this.capacity = initialCapacity;
		this.theArray = new Object[capacity];
		Jog.info( "Array list created with size" + " " + "[" + capacity + "]");
	}
	
	/**Sets the length of the array to the variable which gives you the overall capacity.
	 * @return The actual current capacity of the array.
	 */
	public int capacity(){
		capacity = theArray.length;
		return (this.capacity);
	}
	
	/**Determines the number of indexes that are full of objects within the array.
	 * @return The actual size taken up by objects in the whole array.
	 */
	public int size(){
		return (this.size);
	}
	
	/**Adds an item to the beginning of the List.
	 * @param item What the Object is.
	 */
	public void addFirst(Object item){
		this.add(0, item);
	}
	
	/**Adds an item to the end of the list.
	 * @param item What the object is.
	 */
	public void addLast(Object item){
		if(size == capacity) { //If size and capacity are equal, expand the array.
			Expand();
			Jog.debug("Increased capacity from [" + size + "] to [" + capacity + "].");
		}
		this.add(size(), item);

		}
	
	/**Adds an item to the specific index position.
	 * @param index Where the new item will go.
	 * @param item What the object is.
	 */
	public void add(int index, Object item){
		if (index < 0 || index > size){ //If index is out of bounds, throw an exception.
			Jog.error("Invalid index" + " " + "[" + index + "]." + " " +"Valid values are from [" + 0 + "] to [" + (size-1) +"]");
			return;
		}
		
		if (size == capacity){ //If size and capacity are equal, expand the array.
			Expand();
			Jog.debug("Increased capacity from [" + size + "] to [" + capacity + "].");
		}
		
		for (int i = size; i> index; i--){ //Shift preceding indexes down the array to make room
			theArray[i] = theArray[i-1];
		}
		
		theArray[index] = item;
		size++;
		Jog.info("Added object to the array");
		Jog.debug("Current array size" + " " + "[" + size+ "]." + " " + "Current array capacity" + "[" + capacity + "].");
		}
	
	/**Allows for retaining values of items at specific index in the array.
	 * @param index Zones in on a specific item at said index.
	 * @return Gives the value of the item at said index.
	 */
	public Object get(int index){ // gets the specific position of an item.
		if(index < 0 || index >= size){
			Jog.error("Invalid get index" + " " + "[" + index + "]." + " " + "Valid values are from [" + 0 + "] to [" + (size-1) +"]." );
			return null;
		}
		return theArray[index];
	}
	
	/**Removes an item from its specific location.
	 * @param index Zones in on what specific item needs to be removed.
	 * @return The item and its values that were removed.
	 */
	public void remove(int index){
		if (size == 0){
			Jog.error("The list is already empty");
			return;
		}
		
		if (index < 0 || index >= size){
			Jog.error("Invalid remove Index" + " " + "[" + index + "]." + " " +"Valid values are from [" + 0 + "] to [" + (size-1) +"]");
			return;
		}
		
		for (int i = index + 1; i < size; i++){
			theArray[i-1] = theArray[i];
		}
		
		size--;
		Jog.info("Removed object from the Array");
		Jog.debug("Current Array size" + " " + "[" + size+ "]." + " " + "Current Array Capacity" + "[" + capacity + "].");
		
		if(capacity - size>6){ // Shrink the array if capacity is 6 greater than size.
		Shrink();
		Jog.debug("Decreased capacity from" + " " + "["+ (capacity+7) + "]" + " " + "to" + " " + "[" + capacity + "]");
		}
		
	}
	
	/**Allows the capacity to add on its original size to its present size when needing more space.
	 */
	private void Expand(){
		capacity = capacity + INITIAL_CAPACITY; //Adds 4 open indexes to the array.
		theArray = Arrays.copyOf(theArray, capacity);
	}
	
	/**Allows the capacity to down size the array container to equal the size.
	 */
	private void Shrink(){
		capacity = size;
		theArray = Arrays.copyOf(theArray, capacity);
	}
	
	/**Enables the array to be written as a set of strings in order by index number.
	 * @return The tempArray is returned as a string.
	 */
	public Object [] toArray(){
		Object [] tempArray = new Object[size];
		for(int i = 0; i<size; i++){ //Create a temporary array to hold the contents of the actual array.
			tempArray[i] = theArray[i];
		}
		for(int j = 0; j<size; j++){ //Print the content of each index of the temporary array.
		System.out.println(tempArray[j]);
		}
		return tempArray;
	}
	
	/** Method to find an object within the Array List.
	 * @param item The object being sought.
	 * @return The Object, if found, otherwise null.
	 */
	public Object find(final Object item) {
		if (item == null) { //Make sure the item isn't null.
		  return null;
		}
		for(int i = 0; i<size; i++ ) { //Iterate through the array.
	      if (item.equals(theArray[i])) { //Check if the item equals the data of the array at that index.
	        return theArray[i];
		  }
		}	  
		return null; //If nothing was found, return null.
    }
}
