package edu.hawaii.ics211.uhSorting;

/**Implements the Quick sort algorithm.
 * 
 * @author Blake Larson
 * 
 */
public class UhQuickSort {

  /**Sort the array using the Quick sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted.	
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
    //Sort the whole array.
	quickSort(array, 0, array.length -1);  
  }
  
  /**Sort a part of the array using the Quick sort algorithm.
   * post: The part of the array from first through last is sorted.
   * @param array The array to be sorted.
   * @param first The index of the low bound.
   * @param last The index of the high bound
   */
  private static <T extends Comparable<T>> void quickSort(T[] array, int first, int last) {
    if (first < last) { //There is data to be sorted.
      //partition the array.
      int pivIndex = partition(array, first, last);
      //Sort the left half.
      quickSort(array, first, pivIndex - 1);
      //Sort the right half.
      quickSort(array, pivIndex + 1, last);
    }
  }
  /**Partition the array so that values from first to pivIndex are less than or
   * equal to the pivot value, and values from pivIndex to last are greater
   * than the pivot value.
   * @param array The array to be partitioned
   * @param first The index of the low bound
   * @param last The index of the high bound
   * @return The location of the pivot value
   */
  private static <T extends Comparable<T>> int partition(T[] array, int first, int last) {
    //Select the first item as the pivot value.
	T pivot = array[first];
	int up = first;
	int down = last;
	do {
	  /*Invariant:
	  * All items in array[first... up-1] <= pivot
	  * All items in array[down-1... last] > pivot
	  */
	  while((up < last) && (pivot.compareTo(array[up]) >= 0)) {
	    up++;	
	  }
	  //assert: up equals last or array[up] > pivot.
	  while (pivot.compareTo(array[down]) < 0) {
	    down--;	  
	  }
	  //assert: down equals first or array[down] <= pivot
	  if (up < down) { //if up is to the left of down.
	    //Exchange array[up] and array[down].
		swap(array, up, down);   
	  }
	} while (up < down); //Repeat while up is left of down.
	//Exhange array[first] and array[down] thus putting the 
	//pivot value where it belongs.
	swap(array, first, down);
	//Return the index of the pivot value.
	return down;
  }
  
  /**Swap the items in array[i] and array[j].
   * @param array The array that contains the items.
   * @param i The index of one item.
   * @param j The index of the other item.
   */
  private static <T extends Comparable<T>> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}
