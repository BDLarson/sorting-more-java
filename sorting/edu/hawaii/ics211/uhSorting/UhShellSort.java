package edu.hawaii.ics211.uhSorting;

/**Implements the Shell sort algorithm.
 * 
 * @author Blake Larson
 *
 */
public class UhShellSort {
  
  /**Sort the array using Shell sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted.	
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
    //Gap between adjacent elements.
	int gap = array.length / 2;
	while (gap > 0) {
	  for(int nextPos = gap; nextPos < array.length; nextPos++) {
	    //Insert elements at nextPos in its subarray.
		insert(array, nextPos, gap);
	  } //End for.
	  
	  //Reset gap for next pass.
	  if (gap == 2) {
	    gap = 1;	  
	  } else {
		gap = (int)(gap / 2.2);
	  }
	} //End while.
  } //End sort.
  
  /**Inserts element at nextPos where it belongs in array.
   * pre: Elements through nextPos - gap in subarray are sorted.
   * post: Elements through nextPos in subarray are sorted.
   * @param array The array being sorted.
   * @param nextPos The position of the element to insert.
   * @param gap The gap between elements in the subarray.
   */
  private static <T extends Comparable <T>> void insert (T[] array, int nextPos, int gap) {
    T nextVal = array[nextPos]; //Element to insert.
    //Shift all values > nextVal in subarray down by gap.
    while((nextPos > gap - 1) && (nextVal.compareTo(array[nextPos - gap]) < 0)) {
      array[nextPos] = array[nextPos - gap]; //Shift down.
      nextPos -= gap; //Check next position in subarray.
    }
    array[nextPos] = nextVal; //Insert nextVal.
  }
}
