package edu.hawaii.ics211.uhCollection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import org.junit.Test;
import edu.hawaii.ics211.uhPerformance.Timer;


public class UhStackTest {

  public static final int MIN_STACK_SIZE = 1;
  /** A random number generator for populating the data structures. */
  private static Random r = null;

  @Test
  public void testConstructor() {
    UhStack<String> s = new UhStack<String>(10);

    assertNotNull(s);
  }


  @Test
  public void testLength() {
    UhStack<String> s = new UhStack<String>(10);

    assertEquals(10, s.length());
  }


  @Test
  public void testMinimumConstructor() {
    UhStack<String> s = new UhStack<String>(MIN_STACK_SIZE);

    assertEquals(MIN_STACK_SIZE, s.length());
  }


  @Test (expected = IllegalArgumentException.class)
  public void testConstructorTooSmall() {
    UhStack<String> s = new UhStack<String>(MIN_STACK_SIZE - 1);
  }


  @Test
  public void testEmpty() {
    UhStack<String> s = new UhStack<String>(100);

    assertTrue(s.isEmpty());
  }


  @Test
  public void testFull() {
    UhStack<String> s = new UhStack<String>(5);

    assertFalse(s.isFull());
    assertTrue(s.isEmpty());

    s.push("one");
    assertFalse(s.isFull());
    assertFalse(s.isEmpty());

    s.push("two");
    assertFalse(s.isFull());
    assertFalse(s.isEmpty());

    s.push("three");
    assertFalse(s.isFull());
    assertFalse(s.isEmpty());

    s.push("four");
    assertFalse(s.isFull());
    assertFalse(s.isEmpty());

    s.push("five");
    assertTrue(s.isFull());  // It's full now
    assertFalse(s.isEmpty());
  }


  @Test
  public void testSize() {
    UhStack<String> s = new UhStack<String>(5);
    assertEquals(0, s.size());

    s.push("one");
    assertEquals(1, s.size());

    s.push("two");
    assertEquals(2, s.size());

    s.push("three");
    assertEquals(3, s.size());
  }


  @Test
  public void testTop() {
    UhStack<String> s = new UhStack<String>(100);
    assertNull(s.top());

    s.push("hello");
    assertEquals("hello", s.top());

    s.push("goodbye");
    assertEquals("goodbye", s.top());

    assertEquals(2, s.size());
  }


  @Test
  public void testPop() {
    UhStack<String> s = new UhStack<String>(100);

    s.push("hello");
    s.push("morning");
    s.push("goodbye");

    assertEquals("goodbye", s.pop());
    assertEquals("morning", s.pop());
    assertEquals("hello", s.pop());
  }


  @Test
  public void testPopOnEmpty() {
    UhStack<String> s = new UhStack<String>(100);
    assertNull(s.pop());
    assertNull(s.top());

    s.push("Alpha");
    s.pop();
    assertNull(s.pop());
    assertNull(s.top());

    s.push("Alpha");
    s.push("Bravo");
    s.pop();
    s.pop();
    assertNull(s.pop());
    assertNull(s.top());
  }
  

  /**
   * Determine what method the performance test should run.
   */
  private static enum TestMode { PUSH, POP };

  /**
   * Conduct one heat of testing push() or pop() methods on a UhStack.
   *
   * @param size         The number of elements in the Stack at the start
   *                     of the test run.
   * @param measurements The number of times to run the method under test on the
   *                     data structure.
   * @param mode         Which method the test should run (PUSH or POP).
   */
  private static void measureStackPerformance(final int size
                                            , final int measurements
                                            , final TestMode mode) {

    Timer timer = new Timer("Stack - " + mode + ": "
                          + " Test " + measurements + " operations"
                          + " on a " + size + " item stack");

    // Make the data structure
    UhStack<Long> theDataStructure = new UhStack<Long>(size + measurements + 1);

    // Pre-Populate the data structure with size items.
    for (int i = 0; i < size; i++) {
      theDataStructure.push(r.nextLong());  // Any add method will do
    }

    // Time how long it takes to perform n actions
    switch (mode) {
      case PUSH:
        timer.start();
        for (int i = 0; i < measurements; i++) {
          theDataStructure.push(r.nextLong());  // The method under test
        }
        timer.stop();
        break;
      case POP:
        timer.start();
        for (int i = 0; i < measurements; i++) {
          theDataStructure.pop();  // The method under test
        }
        timer.stop();
        break;
      default:
        throw new RuntimeException("Should never get here");
    }

    System.out.println(timer.getDescription() + " = " + timer.getDurationNs());

    theDataStructure = null;
  }


  /** Test push() performance.  Should be constant time. */
  @Test
  public void testStackPushPerformance() {
    r = new Random();
    r.setSeed(12345678);  // Adds some consistency to repeated runs.

    System.out.println("Data Structure:  Stack   --   Method:  Push");
    measureStackPerformance(1000, 1000, TestMode.PUSH);
    measureStackPerformance(2000, 1000, TestMode.PUSH);
    measureStackPerformance(3000, 1000, TestMode.PUSH);
    measureStackPerformance(4000, 1000, TestMode.PUSH);
    measureStackPerformance(5000, 1000, TestMode.PUSH);
    measureStackPerformance(6000, 1000, TestMode.PUSH);
    measureStackPerformance(7000, 1000, TestMode.PUSH);
    measureStackPerformance(8000, 1000, TestMode.PUSH);
    measureStackPerformance(9000, 1000, TestMode.PUSH);
    measureStackPerformance(10000, 1000, TestMode.PUSH);
    measureStackPerformance(20000, 1000, TestMode.PUSH);
    measureStackPerformance(30000, 1000, TestMode.PUSH);
    measureStackPerformance(40000, 1000, TestMode.PUSH);
    measureStackPerformance(50000, 1000, TestMode.PUSH);
    measureStackPerformance(60000, 1000, TestMode.PUSH);
    measureStackPerformance(70000, 1000, TestMode.PUSH);
    measureStackPerformance(80000, 1000, TestMode.PUSH);
    measureStackPerformance(90000, 1000, TestMode.PUSH);
    measureStackPerformance(100000, 1000, TestMode.PUSH);
    measureStackPerformance(200000, 1000, TestMode.PUSH);
    measureStackPerformance(300000, 1000, TestMode.PUSH);
    measureStackPerformance(400000, 1000, TestMode.PUSH);
    measureStackPerformance(500000, 1000, TestMode.PUSH);
    measureStackPerformance(600000, 1000, TestMode.PUSH);
    measureStackPerformance(700000, 1000, TestMode.PUSH);
    measureStackPerformance(800000, 1000, TestMode.PUSH);
    measureStackPerformance(900000, 1000, TestMode.PUSH);
    measureStackPerformance(1000000, 1000, TestMode.PUSH);
  }


  /** Test pop() performance.  Should be constant time. */
  @Test
  public void testStackPopPerformance() {
    r = new Random();
    r.setSeed(12345678);  // Adds some consistency to repeated runs.

    System.out.println("Data Structure:  Stack   --   Method:  Pop");
    measureStackPerformance(1000, 1000, TestMode.POP);
    measureStackPerformance(2000, 1000, TestMode.POP);
    measureStackPerformance(3000, 1000, TestMode.POP);
    measureStackPerformance(4000, 1000, TestMode.POP);
    measureStackPerformance(5000, 1000, TestMode.POP);
    measureStackPerformance(6000, 1000, TestMode.POP);
    measureStackPerformance(7000, 1000, TestMode.POP);
    measureStackPerformance(8000, 1000, TestMode.POP);
    measureStackPerformance(9000, 1000, TestMode.POP);
    measureStackPerformance(10000, 1000, TestMode.POP);
    measureStackPerformance(20000, 1000, TestMode.POP);
    measureStackPerformance(30000, 1000, TestMode.POP);
    measureStackPerformance(40000, 1000, TestMode.POP);
    measureStackPerformance(50000, 1000, TestMode.POP);
    measureStackPerformance(60000, 1000, TestMode.POP);
    measureStackPerformance(70000, 1000, TestMode.POP);
    measureStackPerformance(80000, 1000, TestMode.POP);
    measureStackPerformance(90000, 1000, TestMode.POP);
    measureStackPerformance(100000, 1000, TestMode.POP);
    measureStackPerformance(200000, 1000, TestMode.POP);
    measureStackPerformance(300000, 1000, TestMode.POP);
    measureStackPerformance(400000, 1000, TestMode.POP);
    measureStackPerformance(500000, 1000, TestMode.POP);
    measureStackPerformance(600000, 1000, TestMode.POP);
    measureStackPerformance(700000, 1000, TestMode.POP);
    measureStackPerformance(800000, 1000, TestMode.POP);
    measureStackPerformance(900000, 1000, TestMode.POP);
    measureStackPerformance(1000000, 1000, TestMode.POP);
  }

}