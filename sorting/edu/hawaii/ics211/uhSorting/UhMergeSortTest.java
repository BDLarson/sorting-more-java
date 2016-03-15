package edu.hawaii.ics211.uhSorting;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/*
 * @author Blake Larson
 */
public class UhMergeSortTest {

  @Test
  public void testSort() throws IOException {
	  String[] ayeRae = SortTools.makeArray("corpus-random.txt");
	  int size = ayeRae.length;
	  System.out.println("The Total array size is: " + size);
	  
	  assertFalse(SortTools.isSorted(ayeRae)); //Should be unsorted
	 // SortTools.printArray(ayeRae);

	  UhMergeSort.sort(ayeRae); //Sort
	  System.out.println("\n");
	
	  System.out.println("The array is now sorted!" + "\n");
	  assertTrue(SortTools.isSorted(ayeRae)); //Should be sorted
	  //SortTools.printArray(ayeRae);

	  assertEquals("AA", ayeRae[0]);  //First is sorted in index 0.
	  assertEquals("AAH", ayeRae[1]); //Second is sorted in index 1.
	  assertEquals("ZZZ", ayeRae[267749]); //Second to last is sorted in front of last.
	  assertEquals("ZZZS", ayeRae[267750]); // Last is sorted at the last spot.
	  assertEquals(size, ayeRae.length); //Test that the original array length is the same after sorting.
  }
  
  @Test
  public void testTenUnordered() throws IOException {
    String[] ayeRae = SortTools.makeArray("TenTest.txt");
	assertFalse(SortTools.isSorted(ayeRae));
	System.out.println("The Total array size is: " + ayeRae.length + "\n");
	SortTools.printArray(ayeRae);
	
	UhMergeSort.sort(ayeRae); //Sort
	System.out.println("\n");
	
	System.out.println("The array is now sorted!" + "\n");
	assertTrue(SortTools.isSorted(ayeRae));
	SortTools.printArray(ayeRae);
	System.out.println("\n");

  }
  
  @Test
  public void testElevenUnordered() throws IOException {
    String[] ayeRae = SortTools.makeArray("ElevenTest.txt");
	assertFalse(SortTools.isSorted(ayeRae));
	System.out.println("The Total array size is: " + ayeRae.length + "\n");
	SortTools.printArray(ayeRae);
	
	UhMergeSort.sort(ayeRae); //Sort
	System.out.println("\n");
	
	System.out.println("The array is now sorted!" + "\n");
	assertTrue(SortTools.isSorted(ayeRae));
	SortTools.printArray(ayeRae);
	System.out.println("\n");

  }
  
  @Test
  public void testOneUnordered() throws IOException {
	 String[] ayeRae = SortTools.makeArray("OneTest.txt");
	 System.out.println("The Total array size is: " + ayeRae.length + "\n");
	 SortTools.printArray(ayeRae);
		
	 UhMergeSort.sort(ayeRae); //Sort
	 System.out.println("\n");
		
	 System.out.println("The array is now sorted!" + "\n");
	 assertTrue(SortTools.isSorted(ayeRae));
	 SortTools.printArray(ayeRae);
	 System.out.println("\n");
  }
  
  @Test
  public void testRandomIntSort() {
    for (int i = 0; i < 99; i++) {	  
	  Integer[] ayeRae = SortTools.generateRandomIntegerArray(10);
	  assertFalse(SortTools.isSorted(ayeRae));
	  UhMergeSort.sort(ayeRae);
	  assertTrue(SortTools.isSorted(ayeRae));
    }
  }
  
  @Test
  public void test50000IntSort() {
    Integer[] ayeRae = SortTools.generateRandomIntegerArray(50000);
	assertFalse(SortTools.isSorted(ayeRae));
	UhMergeSort.sort(ayeRae);
	assertTrue(SortTools.isSorted(ayeRae));  
  }
}
