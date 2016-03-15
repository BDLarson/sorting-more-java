package edu.hawaii.ics211.uhSorting;
import edu.hawaii.ics211.uhPerformance.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Blake Larson
 */
public class PerformanceTests {

  @Test
  public void allSorts() { 
	Timer time = new Timer(null);

	for (int count = 100; count <= 10000; count+=100) {
	  Integer[] ayeRae1 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae2 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae3 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae4 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae5 = SortTools.generateRandomIntegerArray(count);
	  Integer [][] clone = new Integer[5][count];
	  clone[0] = ayeRae1;
	  clone[1] = ayeRae2;
	  clone[2] = ayeRae3;
	  clone[3] = ayeRae4;
	  clone[4] = ayeRae5;
	  long c1, c2, c3, c4, c5, c6, c7, c8, c9;
	  Integer [] clone2 = null;
	  
	  for (int i = 0; i <= 4; i++) {
	    clone2 = clone[i].clone();
		time.start();
	    UhBubbleSort.sort(clone2);
		time.stop();
	  }
	  c1 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();  
	    time.start();
	    UhHeapSort.sort(clone2);
		time.stop();
	  }
	  c2 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
	    time.start();
	    UhInsertionSort.sort(clone2);
	    time.stop();
	  }
	  c3 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhMergeSort.sort(clone2);
	    time.stop();
	  }
	  c4 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhPingPongSort.sort(clone2);
		time.stop();
	  }
	  c5 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhQuickSort.sort(clone2);
	    time.stop();
	  }
	  c6 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhSelectionSort.sort(clone2);
	    time.stop();
	  }
	  c7 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
        clone2 = clone[i].clone();
		time.start();
	    UhShellSort.sort(clone2);
	    time.stop();
	  }
	  c8 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 4; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhSqueezeSort.sort(clone2);
	    time.stop();
	  }
	  c9 = time.getDurationNs();
	  time.reset();
	  
	  System.out.println(count + " = " + c1 + " = " + c2 + " = " + c3 + " = " + c4 + " = " 
			  				   + c5 + " = " + c6 + " = " + c7 + " = " + c8 + " = " + c9);
	}
  }
  
  @Test
  public void recursiveSorts() {
    Timer time = new Timer(null);
    
	for (int count = 10000; count <= 1000000; count+=10000) {
	  Integer[] ayeRae1 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae2 = SortTools.generateRandomIntegerArray(count);
	  Integer [][] clone = new Integer[2][count];
	  clone[0] = ayeRae1;
	  clone[1] = ayeRae2;
	  long c1, c2, c3, c4;
	  Integer [] clone2 = null;

		
	  for (int i = 0; i <= 1; i++) {
	    clone2 = clone[i].clone();
	    time.start();
		UhHeapSort.sort(clone2);
		time.stop();
	  }
	  c1 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
		time.start();
		UhQuickSort.sort(clone2);
		time.stop();
	  }
	  c2 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
	    time.start();
		UhShellSort.sort(clone2);
		time.stop();
	  }
	  c3 = time.getDurationNs();
	  time.reset();
	  

	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
	    time.start();
		UhMergeSort.sort(clone2);
		time.stop();
	  }
	  c4 = time.getDurationNs();
	  time.reset();
	  
	  System.out.println(count + " = " + c1 + " = " + c2 + " = " + c3 + " = " + c4);
	}
  }
  
  private static int numRuns = 5000;
  @Test
  public void allSortsOnSmallArrays() {
    Timer time = new Timer(null);
	for (int count = 50; count <= 250; count += 2) {
		
	  Integer[][] ayeRae = new Integer[numRuns][count];
	  
	  for (int array = 0; array < numRuns; array++) {
	    ayeRae[array] = SortTools.generateRandomIntegerArray(count);	  
	  }
	  long c1, c2, c3, c4, c5, c6, c7, c8, c9;
	  Integer [] clone2;
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		//assertFalse(SortTools.isSorted(clone2));
		time.start();
	    UhBubbleSort.sort(clone2);
	    time.stop();
	  }
	  c1 = time.getDurationNs();
	  time.reset();
	  //assertTrue(SortTools.isSorted(clone2));

	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhHeapSort.sort(clone2);
		time.stop();
	  }
	  c2 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhInsertionSort.sort(clone2);
	    time.stop();
	  }
	  c3 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhMergeSort.sort(clone2);
		time.stop();
	  }
	  c4 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <numRuns; i++) {
	    clone2 = ayeRae[i].clone();
		time.start();
	    UhPingPongSort.sort(clone2);
	    time.stop();
	  }
	  c5 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhQuickSort.sort(clone2);
		time.stop();
	  }
	  c6 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhSelectionSort.sort(clone2);
	    time.stop();
	  }
	  c7 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
	    clone2 = ayeRae[i].clone();
		time.start();
	    UhShellSort.sort(clone2);
	    time.stop();
	  }
	  c8 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i < numRuns; i++) {
		clone2 = ayeRae[i].clone();
		time.start();
	    UhSqueezeSort.sort(clone2);
	    time.stop();
	  }
	  c9 = time.getDurationNs();
	  time.reset();
	  
	  System.out.println(count + " = " + c1 + " = " + c2 + " = " + c3 + " = " + c4 + " = " 
			  				   + c5 + " = " + c6 + " = " + c7 + " = " + c8 + " = " + c9);
	}  
  }
  
  @Test
  public void improvedSorts() {
    Timer time = new Timer(null);
    
	for (int count = 10000; count <= 1000000; count+=10000) {
	  Integer[] ayeRae1 = SortTools.generateRandomIntegerArray(count);
	  Integer[] ayeRae2 = SortTools.generateRandomIntegerArray(count);
	  Integer [][] clone = new Integer[2][count];
	  clone[0] = ayeRae1;
	  clone[1] = ayeRae2;
	  long c1, c2, c3, c4;
	  Integer [] clone2 = null;
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhMergeSort.sort(clone2);
		time.stop();
	  }
	  c1 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhMergeImprovedSort.sort(clone2);
	    time.stop();
	  }
	  c2 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhQuickSort.sort(clone2);
	    time.stop();
	  }
	  c3 = time.getDurationNs();
	  time.reset();
	  
	  
	  
	  for (int i = 0; i <= 1; i++) {
		clone2 = clone[i].clone();
		time.start();
	    UhQuickImprovedSort.sort(clone2);
	    time.stop();
	  }
	  c4 = time.getDurationNs();
	  time.reset();
	  
	  System.out.println(count + " = " + c1 + " = " + c2 + " = " + c3 + " = " + c4);
	}  
  }
}
