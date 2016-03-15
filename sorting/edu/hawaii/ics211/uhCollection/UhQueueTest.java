package edu.hawaii.ics211.uhCollection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import org.junit.Test;
import edu.hawaii.ics211.uhPerformance.Timer;

/**
 * Exercise the UhQueue class.
 *
 * @author ICS 211
 */
public class UhQueueTest {
    
    /** The smallest allowable stack size. */
    /** A random number generator for populating the data structures. */
    private static Random r = null;

  /**
   * Test a basic constructor.
   */
  @Test
  public void testConstruct() {
    UhQueue<String> q = new UhQueue<String>();

    assertNotNull(q);
  }


  /**
   * Exercise the size() method.
   */
  @Test
  public void testSize() {
    UhQueue<String> q = new UhQueue<String>();

    assertEquals(0, q.size());
    assertTrue(q.isEmpty());
  }


  /**
   * Exercise the enqueue() method.
   */
  @Test
  public void testEnqueueAndHead() {
    UhQueue<String> q = new UhQueue<String>();

    q.enqueue("hello");
    assertEquals(1, q.size());
    assertEquals("hello", q.head());

    q.enqueue("goodbye");
    assertEquals(2, q.size());
    assertEquals("hello", q.head());
  }


  /**
   * Exercise the dequeue() method.
   */
  @Test
  public void testDequeue() {
    UhQueue<String> q = new UhQueue<String>();

    q.enqueue("hello");
    q.enqueue("goodbye");
    q.enqueue("chicken");

    assertEquals("hello", q.dequeue());
    assertEquals(2, q.size());

    assertEquals("goodbye", q.dequeue());
    assertEquals(1, q.size());

    assertEquals("chicken", q.dequeue());
    assertEquals(0, q.size());
  }


  /**
   * Make sure remove(null) throws the right exception
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRemoveNull() {
    UhQueue<Integer> q = new UhQueue<Integer>();

    q.remove(null);
  }


  @Test
  public void testRemoveMiss() {
    UhQueue<String> q = new UhQueue<String>();

    q.enqueue("Alpha");
    assertNull(q.remove("SomethingElse"));
  }


  @Test
  public void testRemove() {
    UhQueue<Integer> q = new UhQueue<Integer>();

    for (int i = 0; i < 1000; i++) {
      q.enqueue(Integer.valueOf(i));
    }

    q.enqueue(Integer.valueOf(50));
    assertEquals(1001, q.size());

    q.remove(Integer.valueOf(50));
    assertEquals(999, q.size());

    q.remove(Integer.valueOf(1));
    assertEquals(998, q.size());
  
    q.dequeue();
    assertEquals(Integer.valueOf(1), q.dequeue());
  }
  
  /**
   * Determine what method the performance test should run.
   */
  private static enum TestMode { ENQUEUE, DEQUEUE };


  /**
   * Conduct one heat of testing enqueue() or dequeue() methods on an Queue.
   *
   * @param size         The number of elements in the Queue at the start
   *                     of the test run.
   * @param measurements The number of times to run the method under test on the
   *                     data structure.
   * @param mode         Which method the test should run (ENQUEUE or DEQUEUE).
   */
  private static void measureQueuePerformance(final int size
                                            , final int measurements
                                            , final TestMode mode) {

    Timer timer = new Timer("Queue - " + mode + ": "
                          + " Test " + measurements + " operations"
                          + " on a " + size + " item stack");

    // Make the data structure
    UhQueue<Long> theDataStructure = new UhQueue<Long>();

    // Pre-Populate the data structure with size items.
    for (int i = 0; i < size; i++) {
      theDataStructure.enqueue(r.nextLong());  // Any add method will do
    }

    // Time how long it takes to perform n actions
    switch (mode) {
      case ENQUEUE:
        timer.start();
        for (int i = 0; i < measurements; i++) {
          theDataStructure.enqueue(r.nextLong());  // The method under test
        }
        timer.stop();
        break;
      case DEQUEUE:
        timer.start();
        for (int i = 0; i < measurements; i++) {
          theDataStructure.dequeue();  // The method under test
        }
        timer.stop();
        break;
      default:
        throw new RuntimeException("Should never get here");
    }

    System.out.println(timer.getDescription() + " = " + timer.getDurationNs());

    theDataStructure = null;
  }

  
  /** Test enqueue() performance.  Should be constant time. */
  @Test
  public void testQueueEnqueuePerformance() {
    r = new Random();
    r.setSeed(12345678);  // Adds some consistency to repeated runs.

    System.out.println("Data Structure:  Queue   --   Method:  Enqueue");
    measureQueuePerformance(1000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(2000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(3000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(4000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(5000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(6000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(7000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(8000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(9000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(10000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(20000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(30000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(40000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(50000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(60000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(70000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(80000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(90000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(100000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(200000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(300000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(400000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(500000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(600000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(700000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(800000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(900000, 1000, TestMode.ENQUEUE);
    measureQueuePerformance(1000000, 1000, TestMode.ENQUEUE);
  }


  /** Test dequeue() performance.  Should be constant time. */
  @Test
  public void testQueueDequeuePerformance() {
    r = new Random();
    r.setSeed(12345678);  // Adds some consistency to repeated runs.

    System.out.println("Data Structure:  Queue   --   Method:  Dequeue");
    measureQueuePerformance(1000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(2000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(3000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(4000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(5000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(6000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(7000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(8000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(9000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(10000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(20000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(30000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(40000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(50000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(60000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(70000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(80000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(90000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(100000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(200000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(300000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(400000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(500000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(600000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(700000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(800000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(900000, 1000, TestMode.DEQUEUE);
    measureQueuePerformance(1000000, 1000, TestMode.DEQUEUE);
  }


}