package edu.hawaii.ics211.uhSorting;

/**Implements an updated version of Bubble sort algorithm called Ping Pong sort.
 * 
 * @author Blake Larson
 *
 */
public class UhPingPongSort {
	
  /**Sort the array using Ping Pong sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted. 
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
    int pass = 0;
	boolean exchanges = false;
	do {
	  //Invariant: Elements after [array.length - pass + 1] are in place.
	  exchanges = false; //No exchanges yet.
	  //Compare each pair of adjacent elements.
	  for (int i = pass; i < (array.length - 1) - pass; i++) {
	    if (array[i].compareTo(array[i + 1]) > 0) {
		  //Exchange pair.
		  T temp = array[i];
		  array[i] = array[i + 1];
		  array[i + 1] = temp;
		  exchanges = true; //Set flag.
	    }
		  //System.out.println("\n");
		  //SortTools.printArray(array);
	  }  
	  for (int j = (array.length - 1) - pass; j > pass; j--) {
	    if (array[j].compareTo(array[j - 1]) < 0) {
	      //Exchange the pair.
	      T temp = array[j];
	      array[j] = array[j - 1];
	      array[j - 1] = temp;
	      exchanges = true;
	    }
		  //System.out.println("\n");
		  //SortTools.printArray(array);
	  }
	  pass++;
	} while (exchanges);
	//assert: Array is sorted.
  }
}
