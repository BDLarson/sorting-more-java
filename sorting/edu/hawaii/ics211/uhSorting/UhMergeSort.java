package edu.hawaii.ics211.uhSorting;

/**Implements the recursive merge sort algorithm. In this version, copies 
 * of the sub-tables are made, sorted, and then merged
 * @author Blake Larson
 */
public class UhMergeSort {
  /**Sort the array using the merge sort algorithm.
   * pre: table contains Comparable objects.
   * post: table is sorted.
   * @param array The array to be sorted.
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
    //A table with one element is sorted already.
	if (array.length > 1) {
	  //Split table into halves.
	  int halfSize = array.length/2;
	  T[] leftArray = (T[]) new Comparable[halfSize];
	  T[] rightArray = (T[]) new Comparable[array.length - halfSize];
	  System.arraycopy(array, 0, leftArray, 0, halfSize);
	  System.arraycopy(array, halfSize, rightArray, 0, array.length - halfSize);
	  //Sort the halves.
	  sort(leftArray);
	  sort(rightArray);
	  
	  //Merge the halves.
	  merge(array, leftArray, rightArray);
	}
  }
  
  /**Merge two sequences.
   * pre: leftSequence and rightSequence are sorted.
   * post: outputSequence is the merged result and is sorted.
   * @param outputSequence The destination.
   * @param leftSequence The left input.
   * @param rightSequence The right input.
   */
  private static <T extends Comparable<T>> void merge (T[] outputSequence, T[] leftSequence, T[] rightSequence) {
    int i = 0; //Index into the left input sequence.
    int j = 0; //Index into the right input sequence.
    int k = 0; //Index into the left output sequence.
    //While there is data in both input sequences.
    while (i < leftSequence.length && j < rightSequence.length) {
      //Find the smaller and insert it into the output sequence.
      if (leftSequence[i].compareTo(rightSequence[j]) < 0) {
        outputSequence[k++] = leftSequence[i++];	  
      } else {
    	outputSequence[k++] = rightSequence[j++];  
      }
    }
    //assert: one of the sequences has more items to copy.
    //Copy remaining input from left sequence into the output.
    while (i < leftSequence.length) {
      outputSequence[k++] = leftSequence[i++];
    }
    //Copy remaining input from right sequence into output.
    while (j < rightSequence.length) {
      outputSequence[k++] = rightSequence[j++];	
    }
  }
}
