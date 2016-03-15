package edu.hawaii.ics211.uhSorting;

/* Implements the modified selection sort algorithm that is a squeeze sort.
 * Instead of just smallest sorting, it sorts largest as well at the same time.
 * 
 * @author Blake Larson 
 * 
 */
public class UhSqueezeSort {
	
  /* Sort the array using squeeze sort algorithm.
   * pre: array contains Comparable objects.
   * post: array is sorted.
   * @param array The array to be sorted.	
   */
  public static <E extends Comparable<E>>void sort(final E[] array) {
    int n = array.length;
	for (int topOff = 0; topOff < n/2; topOff++) {
	  //Invariant: array[0... topOff-1] is sorted.
	  //System.out.println("Iteration: " + (topOff+1)  + "\n");
	  int minIndex = topOff;
	  int maxIndex = topOff;
	  for (int next = topOff + 1; next < n-topOff; next++) {
	  //Invariant: table[minIndex] is the smallest item in
	  //array[topOff... i-1].
	    if (array[next].compareTo(array[minIndex]) < 0) {
		  minIndex = next;	
		} 
		if (array[next].compareTo(array[maxIndex]) > 0 ) {
	      maxIndex = next;	
	    }
	  }	
	  //assert: array[minIndex] is the smallest item in
	  //array[topOff... n-1].
	  //Exchange array[topOff] and array[minIndex].
	  E tempMin = array[topOff];
	  array[topOff] = array[minIndex];
	  array[minIndex] = tempMin;
	  //assert: array[topOff] is the smallest item in
	  //array[topOff... n-1].
	  
	  //In the case of an odd array where the two indexes become one,
	  //make the two index equal.
	  if (maxIndex == topOff) {
	    maxIndex = minIndex;	  
	  }
	  
	  //assert: array[maxIndex] is the largest item in
	  //array[topOff... n-1].
	  //Exchange array[n-1] and array[maxIndex].
	  E tempMax = array[n-(topOff + 1)];
	  array[n-(topOff + 1)] = array[maxIndex];
	  array[maxIndex] = tempMax;
	  //assert: array[n-1] is the largest item in
	  //array[topOff... n-1].
	  //SortTools.printArray(array);
	  //System.out.println("\n");
	}
	//assert: array[0... n-1] is sorted.
  }
  
  public static<E extends Comparable<E>> void selectionSort(final E[] array) {
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
      E temp = array[fill];
	  array[fill] = array[posMin];
      array[posMin] = temp;
	  //assert: table[fill] is the smallest item in
	  //table[fill... n-1].
    }
    //assert: table[0... n-1] is sorted. 
  }
  
  public static<E extends Comparable<E>> void selectionMaxSort(final E[] array) {
    int n = array.length;
	for (int load = n-1; load > 0; load--) {
	  int maximumVal = load;
	  for (int preceed = load - 1; preceed >= 0; preceed--) {
	    if (array[preceed].compareTo(array[maximumVal]) > 0) {
		  maximumVal = preceed;    	
		}
	  }
	  E temp = array[load];
	  array[load] = array[maximumVal];
	  array[maximumVal] = temp;
    }
  }
}
