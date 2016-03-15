package edu.hawaii.ics211.uhSorting;

/**Implements the Selection sort algorithm.
 * 
 * @author Blake Larson
 *
 */
public class UhSelectionSort {
	
  public static<T extends Comparable<T>> void sort(final T[] array) {
    int n = array.length;
    for (int fill = 0; fill < n-1; fill++) {
	  //Invariant: table[0... fill-1] is sorted.	
	  int posMin = fill;
	  for (int next = fill +1; next < n; next++) {
	    //Invariant: table[posMin] is the smallest item in
		//table[fill... next-1].
		if (array[next].compareTo(array[posMin]) < 0) {
		  posMin = next;
		}
	  }
	  //assert: table[posMin] is the smallest item in
	  //table[fill... n-1].
	  //Exchange table[fill] and table[posMin].

	  T temp = array[fill];
	  array[fill] = array[posMin];
	  array[posMin] = temp;
	  //assert: table[fill] is the smallest item in
	  //table[fill... n-1].
    }
	//assert: table[0... n-1] is sorted. 
  }
}
