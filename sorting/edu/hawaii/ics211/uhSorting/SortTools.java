package edu.hawaii.ics211.uhSorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Useful tools for exercising various sorting algorithms.
 *
 * @author Blake Larson
 */
public class SortTools {

  /** The size of the corpus we are working with. */
  public static final int CORPUS_SIZE = 267752;


  /**
   * Read the contents of fileName, putting each line into an entry in a
   * String array.
   *
   * @param fileName The name of the file to process.
   * @return An array containing the lines of the file.
   *
   * @throws IOException If anything goes wrong.
   */
  public static String[] makeArray(final String fileName) throws IOException {
    ArrayList<String> myList = new ArrayList<String>(CORPUS_SIZE);

    BufferedReader br = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = br.readLine()) != null) {
      myList.add(line);
    }

    br.close();

    String[] returnArray = new String[myList.size()];
    return myList.toArray(returnArray);
  }


  /**
   * Return a new array, the contents of which are a random shuffling
   * (permutation) of the input array.
   *
   * @param array An input array.
   * @return A randomized permutation of the input array.
   */
  public static String[] shuffleArray(final String[] array) {
    ArrayList<String> oldList = new ArrayList<String>(array.length);
    String[] newList = new String[array.length];
    Random random = new Random();

    for (String o : array) {
      oldList.add(o);
    }

    for (int i = 0; i < array.length; i++) {
      int r = random.nextInt(oldList.size());

      newList[i] = oldList.get(r);
      oldList.remove(r);
    }

    return newList;
  }


  /**
   * Save the contents of the array to a file.
   *
   * @param fileName The name of the file to save the array to.
   * @param array An array of strings to output to the file.
   *
   * @throws IOException If something goes wrong.
   */
  public static void saveArray(final String fileName, final String[] array)
      throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

    for (String s : array) {
      bw.write(s + "\n");
    }

    bw.flush();
    bw.close();
  }


  /**
   * Print an array to the console.
   *
   * @param array The array to print to the console.
   */
  public static void printArray(final Object[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.println("  " + i + ":  " + array[i].toString());
    }
  }



  /**
   * Generate an Integer array containing random integers.
   *
   * @param size The size of the array to create.
   * @return An array of random Integers.
   */
  public static Integer[] generateRandomIntegerArray(final int size) {
    Integer[] r = new Integer[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
      r[i] = random.nextInt();
    }

    return r;
  }


  /**
   * Determine if an array is sorted.
   *
   * @param array The array to check.
   * @param <E> The class of data in the array.
   * @return True if the array is sorted.  False if it is not sorted.
   */
  public static <E extends Comparable<E>> boolean isSorted(final E[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i].compareTo(array[i + 1]) > 0) {
        return false;
      }
    }

    return true;
  }

}
