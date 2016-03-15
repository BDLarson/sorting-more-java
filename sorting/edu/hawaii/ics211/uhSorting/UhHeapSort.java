package edu.hawaii.ics211.uhSorting;

/**Implements the Heap sort algorithm.
 * 
 * @author Blake Larson
 *
 */
public class UhHeapSort {

  /**Sort the array using HeapSort Algorithm.
   * pre: array contains Comparable items.
   * post: array is sorted.	
   * @param array The array to be sorted
   */
  public static <T extends Comparable<T>> void sort(final T[] array) {
	  buildHeap(array);
	  shrinkHeap(array);
  }
  
  /**buildHeap transforms the array into a heap.
   * pre: The array contains at least one item.
   * post: All items in the array are in heap order.
   * @param table The array to be transformed into a heap.
   */
  private static <T extends Comparable<T>> void buildHeap(T[] array) {
    int n = 1;
    //Invariant: array[0... n-1] is a heap.
    while (n < array.length) {
      n++; //Add a new item to the heap and reheap.
      int child = n - 1;
      int parent = (child - 1) / 2; //Find parent.
      while (parent >= 0 && array[parent].compareTo(array[child]) < 0) {
        swap(array, parent, child);
        child = parent;
        parent = (child - 1) / 2;
      }
    }
  }

  /**shrinkHeap transforms a heap into a sorted array.
   * pre: All items in the array are in heap order.
   * post: The array is sorted.
   * @param array The array to be sorted.
   */
  private static <T extends Comparable <T>> void shrinkHeap(T[] array) {
    int n = array.length;
    //Invariant: array[0...n-1] forms a heap.
    //array[n... array.length - 1] is sorted.
    while (n > 0) {
      n--;
      swap(array, 0, n);
      //array[1... n-1] form a heap.
      //array[n... array.length - 1] is sorted.
      int parent = 0;
      while (true) {
        int leftChild = 2 * parent + 1;
        if (leftChild >= n) {
          break; //No more children.	
        }
        int rightChild = leftChild + 1;
        //Find the larger of the two children.
        int maxChild = leftChild;
        if (rightChild < n && array[leftChild].compareTo(array[rightChild]) < 0) {
          maxChild = rightChild;  	
        }
        //If the parent is smaller than the larger child,
        if (array[parent].compareTo(array[maxChild]) < 0) {
          //Swap the parent and child.
          swap(array, parent, maxChild);
          //Continue at the child level.
          parent = maxChild;
        } else { //Heap property is restored.
        	break; //Exit the loop.
        }
      }
    }
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
