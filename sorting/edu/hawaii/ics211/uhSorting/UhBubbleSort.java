package edu.hawaii.ics211.uhSorting;

/**Implements the Bubble sort algorithm.
 * 
 * @author Blake Larson
 *
 */
public class UhBubbleSort {
	
  /**Sort the array using bubble sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted. 
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
	int pass = 1;
	boolean exchanges = false;
	do {
	  //Invariant: Elements after [array.length - pass + 1] are in place.
	  exchanges = false; //No exchanges yet.
	  //Compare each pair of adjacent elements.
	  for (int i = 0; i < array.length - pass; i++) {
	    if (array[i].compareTo(array[i + 1]) > 0) {
	      //Exchange pair.
	      T temp = array[i];
	      array[i] = array[i + 1];
	      array[i + 1] = temp;
	      exchanges = true; //Set flag.
	    }
	  }
	  pass++;
	} while (exchanges);
	//assert: Array is sorted.
  }
}
