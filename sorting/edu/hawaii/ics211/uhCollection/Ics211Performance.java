package edu.hawaii.ics211.uhCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

import edu.hawaii.ics211.uhPerformance.Timer;

/** @author Blake Larson 
 * 
 * 
 * JUnit Test class to perform a series of tests, to determine the performance 
 * of each find() method in an ArrayList, SingleLinked List, and Binary Tree.
 * 
 * 6 Tests in which read either a Sorted or Balanced text file.
 * 
 * Console shows the runtime performance of finding a random string within each
 * of the 3 types of List/tree.
 * 
 *
 */
public class Ics211Performance {
	
/******************************************************************************
* 
*  							TEST ARRAY LIST SORTED
* 
*****************************************************************************/	

	@Test
	public void testSearchOnArrayListSorted() throws IOException {
		testSearchOnArrayListSorted("corpus-sorted.txt");
	}
	
	/**Method to determine the performance of the Array List on a Sorted text file. 
	 * @param fileName Text file to be read and created into an array list.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnArrayListSorted(final String fileName) throws IOException {
		UhArrayList myList = new UhArrayList();
	    UhArrayList dataSet = new UhArrayList(1000);
	    Random r = new Random();
	 
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
	      myList.addLast(line);
	      dataSet.addLast(line);
	    }
	 
	    Timer timer = new Timer("Test UhArrayList - " + fileName);
	 
	    timer.start();
	    for (int i = 0; i < 1000000; i++) {
	      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
	    }
	    timer.stop();
	 
	    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");
	}
	
/******************************************************************************
 * 
 *  						TEST ARRAY LIST BALANCED
 * 
 *****************************************************************************/
	@Test
	public void testSearchOnArrayListBalanced() throws IOException {
		testSearchOnArrayListBalanced("corpus-balanced.txt");
	}
	
	/**Method to determine the performance of the Array List on a Balanced text file. 
	 * @param fileName Text file to be read and created into an array list.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnArrayListBalanced(final String fileName) throws IOException {
		UhArrayList myList = new UhArrayList();
	    UhArrayList dataSet = new UhArrayList(1000);
	    Random r = new Random();
	 
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
	      myList.addLast(line);
	      dataSet.addLast(line);
	    }
	 
	    Timer timer = new Timer("Test UhArrayList - " + fileName);
	 
	    timer.start();
	    for (int i = 0; i < 1000000; i++) {
	      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
	    }
	    timer.stop();
	 
	    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");	
	}
	
/******************************************************************************
* 
*  						TEST SINGLE-LINKED LIST SORTED
* 
*****************************************************************************/		
	@Test
	public void testSearchOnSinglyLinkedListSorted() throws IOException {
		testSearchOnSinglyLinkedListSorted("corpus-sorted.txt");
		
	}
	
	/**Method to determine the performance of the Single Linked List on a Sorted text file. 
	 * @param fileName Text file to be read and created into a Single Linked list.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnSinglyLinkedListSorted(final String fileName) throws IOException {
		    UhSingleLinkedList<String> myList = new UhSingleLinkedList<String>();
		    UhArrayList dataSet = new UhArrayList(1000);
		    Random r = new Random();
		 
		    BufferedReader br = new BufferedReader(new FileReader(fileName));
		    String line;
		    while ((line = br.readLine()) != null) {
		      myList.add(line);
		      dataSet.addLast(line);
		    }
		 
		    Timer timer = new Timer("Test UhSingleLinkedList - " + fileName);
		 
		    timer.start();
		    for (int i = 0; i < 1000000; i++) {
		      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
		    }
		    timer.stop();
		 
		    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");
	 }
	
/******************************************************************************
* 
*  						TEST SINGLE-LINKED LIST BALANCED
* 
*****************************************************************************/	
	@Test
	public void testSearchOnSinglyLinkedListBalanced() throws IOException {
		testSearchOnSinglyLinkedListBalanced("corpus-balanced.txt");
		
	}
	
	/**Method to determine the performance of the Single Linked List on a Balanced text file. 
	 * @param fileName Text file to be read and created into a Single Linked list.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnSinglyLinkedListBalanced(final String fileName) throws IOException {
		UhSingleLinkedList<String> myList = new UhSingleLinkedList<String>();
	    UhArrayList dataSet = new UhArrayList(1000);
	    Random r = new Random();
	 
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
	      myList.add(line);
	      dataSet.addLast(line);
	    }
	 
	    Timer timer = new Timer("Test UhSingleLinkedList - " + fileName);
	 
	    timer.start();
	    for (int i = 0; i < 1000000; i++) {
	      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
	    }
	    timer.stop();
	 
	    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");
	}
	
/******************************************************************************
* 
*  						TEST BINARY TREE SORTED
* 
*****************************************************************************/	
	@Test
	public void testSearchOnBinaryTreeSorted() throws IOException{
		testSearchOnBinaryTreeSorted("corpus-sorted.txt");
	}
	
	/**Method to determine the performance of the Binary Tree on a Sorted text file. 
	 * @param fileName Text file to be read and created into an Binary Tree.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnBinaryTreeSorted(final String fileName) throws IOException {
		UhBinaryTree<String> myList = new UhBinaryTree<String>();
	    UhArrayList dataSet = new UhArrayList(1000);
	    Random r = new Random();
	 
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
	      myList.add(line);
	      dataSet.addLast(line);
	    }
	 
	    Timer timer = new Timer("Test UhBinaryTree - " + fileName);
	 
	    timer.start();
	    for (int i = 0; i < 1000000; i++) {
	      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
	    }
	    timer.stop();
	 
	    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");
	}
	
/******************************************************************************
* 
*  						TEST BINARY TREE BALANCED
* 
*****************************************************************************/	
	@Test
	public void testSearchOnBinaryTreeBalanced() throws IOException {
		testSearchOnBinaryTreeBalanced("corpus-balanced.txt");
	}
	
	/**Method to determine the performance of the Binary Tree on a Balanced text file. 
	 * @param fileName Text file to be read and created into an Binary Tree.
	 * @throws IOException If the fileName is not found, throw an exception.
	 */
	public void testSearchOnBinaryTreeBalanced(final String fileName) throws IOException {
		UhBinaryTree<String> myList = new UhBinaryTree<String>();
	    UhArrayList dataSet = new UhArrayList(1000);
	    Random r = new Random();
	 
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    String line;
	    while ((line = br.readLine()) != null) {
	      myList.add(line);
	      dataSet.addLast(line);
	    }
	 
	    Timer timer = new Timer("Test UhBinaryTree - " + fileName);
	 
	    timer.start();
	    for (int i = 0; i < 1000000; i++) {
	      myList.find((String) dataSet.get(r.nextInt(dataSet.size())));
	    }
	    timer.stop();
	 
	    System.out.println(timer.getDescription() + " took " + timer.getDurationNs()/1000/1000 + "ms");
	}
}
