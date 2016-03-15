package edu.hawaii.ics211.uhSorting;

/**Implements the Insertion sort algorithm.
 * 
 * @author Blake Larson
 *
 */
public class UhInsertionSort {

  /**Sort the table using insertion sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted.	
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
    for (int nextPos = 1; nextPos < array.length; nextPos++) {
      //Invariant: array[0... nextPos-1] is sorted.
      //Insert element at position nextPos
      //in the sorted subarray.
      insert(array, nextPos);	
    } //End for.  	  
  } //End sort.
  
  /**Insert the element at nextPos where it belongs in the array.
   * pre: array[0... nextPos-1] is sorted.
   * post: array[0... nextPos] is sorted.
   * @param array The array being sorted.
   * @param nextPos The position of the element to insert.
   */
  private  static <T extends Comparable <T>> void insert(T[] array, int nextPos) {
    T nextVal = array[nextPos]; //Element to insert.
    while (nextPos > 0 && nextVal.compareTo(array[nextPos-1]) < 0) {
      array[nextPos] = array[nextPos - 1]; //Shift down.
      nextPos--; //Check next smaller element.
    }
    //Insert nextVal at nextPos.
    array[nextPos] = nextVal;
  }
}
