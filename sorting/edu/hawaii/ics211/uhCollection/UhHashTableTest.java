package edu.hawaii.ics211.uhCollection;
import static org.junit.Assert.*;
import org.junit.Test;

public class UhHashTableTest {

  @Test
  public void testConstructor() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    
    assertTrue(table.isEmpty());
    assertFalse(table.isFull());
    assertEquals(0, table.getSize()); //See if there are zero key/values in the table.
    assertEquals(10,table.getCapacity()); //See if there is 0 entries in the table.
    //table.print();
  }
  
  @Test
  public void testGet() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    assertTrue(table.isEmpty());
    assertFalse(table.isFull());
    assertNull(table.get(0)); //Should be nothing at index 1 but null.
    
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(1, "Bravo"));
    
    assertFalse(table.isEmpty());
    assertEquals(2, table.getSize()); 
    assertEquals(10,table.getCapacity());
    
    assertNull(table.put(2, "Charlie"));
    assertNull(table.put(3, "Delta"));

    assertEquals(4, table.getSize()); 
    assertEquals(10,table.getCapacity());
    
    assertNull(table.put(4, "Echo"));
    assertNull(table.put(5, "Foxtrot"));
    
    assertEquals(6, table.getSize()); 
    assertEquals(10,table.getCapacity());
    
    assertNull(table.put(6, "Golf"));
    assertNull(table.put(7, "Hotel"));

    assertEquals(8, table.getSize()); 
    assertEquals(10,table.getCapacity());
    
    assertNull(table.put(8, "India"));
    assertNull(table.put(9, "Juliette"));
    
    assertEquals("Alpha", table.get(0));
    assertEquals("Bravo", table.get(1));
    assertEquals("Charlie", table.get(2));
    assertEquals("Delta", table.get(3));
    assertEquals("Echo", table.get(4));
    assertEquals("Foxtrot", table.get(5));
    assertEquals("Golf", table.get(6));
    assertEquals("Hotel", table.get(7));
    assertEquals("India", table.get(8));
    assertEquals("Juliette", table.get(9));
    
    //table.print();
  }
  
  @Test
  public void testGetKeyIndex() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(11, "Bravo"));
    assertNull(table.put(112, "Charlie"));
    
    assertEquals(0, table.getKeyIndex(0));
    assertEquals(1, table.getKeyIndex(11));
    assertEquals(2, table.getKeyIndex(112));
    
    //table.print();
  }
  
  /****************************************************************************
   * 
   * No values exist only null, and also no collisions occur.
   * 
   ***************************************************************************/
  @Test
  public void testPutScenario1() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(1, "Bravo"));
    
    assertEquals(2, table.getSize()); //See if there are zero key/values in the table.
    assertEquals(10,table.getCapacity()); //See if there is 0 entries in the table.
    
    assertNull(table.put(2, "Charlie"));
    assertNull(table.put(3, "Delta"));

    assertEquals(4, table.getSize()); 
    assertEquals(10,table.getCapacity());
    
    assertNull(table.put(4, "Echo"));
    assertNull(table.put(5, "Foxtrot"));
    
    assertEquals(6, table.getSize()); 
    assertEquals(10,table.getCapacity());

    assertNull(table.put(6, "Golf"));
    assertNull(table.put(7, "Hotel"));
    
    assertEquals(8, table.getSize()); 
    assertEquals(10,table.getCapacity());

    assertNull(table.put(8, "India"));
    assertNull(table.put(9, "Juliette"));
    
    assertEquals(10, table.getSize()); 
    assertEquals(20,table.getCapacity());
    assertFalse(table.isEmpty());
    
    assertNull(table.put(10, "Kilo"));
    System.out.println("**********Printing Put(Scenario 1)**********");
    table.print();
    System.out.println("\n");
  }
  
  /****************************************************************************
   * 
   * Keys match exactly, but new value replaces old existing value..
   * 
   ***************************************************************************/
  @Test
  public void testPutReplacement() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(1, "Bravo"));
    assertNull(table.put(2, "Charlie"));
    assertNull(table.put(3, "Delta"));
    assertNull(table.put(4, "Echo"));
    assertNull(table.put(5, "Foxtrot"));
    assertNull(table.put(6, "Golf"));
    assertNull(table.put(7, "Hotel")); 
    assertNull(table.put(8, "India")); 
    assertNull(table.put(9, "Juliette")); 
    
    assertEquals(10, table.getSize());
    assertEquals(20,table.getCapacity());
    
    //Check Replacement
    assertNotNull(table.put(0, "A")); 
    assertNotNull(table.put(1, "B")); 
    assertNotNull(table.put(2, "C")); 
    assertNotNull(table.put(3, "D")); 
    assertNotNull(table.put(4, "E")); 
    assertNotNull(table.put(5, "F")); 
    assertNotNull(table.put(6, "G")); 
    assertNotNull(table.put(7, "H")); 
    assertNotNull(table.put(8, "I")); 
    assertNotNull(table.put(9, "J")); 

    assertFalse(table.isEmpty());
    assertEquals(10, table.getSize());
    assertEquals(20,table.getCapacity());
    System.out.println("**********Printing Replacement Aspect**********");
    table.print();
    System.out.println("\n");
  }
  
  /****************************************************************************
   * 
   * Hash Codes match but there already exists a value at the specified key.
   * 
   ***************************************************************************/
  @Test
  public void testPutScenario2() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(1, "Bravo"));
    assertNull(table.put(2, "Charlie"));

    assertNull(table.put(10, "Delta"));

    assertNull(table.put(21, "Echo")); 
    assertNull(table.put(32, "Foxtrot")); 
    assertNull(table.put(40, "Golf")); 
    assertNull(table.put(51, "Hotel")); 
    assertNull(table.put(62, "India")); 
    assertNull(table.put(72, "Juliette")); 


    assertFalse(table.isEmpty());
    assertEquals("Foxtrot", table.get(32));
    assertEquals("Golf", table.get(40));
    assertEquals("Hotel", table.get(51));
    assertEquals("India", table.get(62));
    assertEquals("Juliette", table.get(72));

    assertEquals(10, table.getSize()); //See if there are zero key/values in the table.
    assertEquals(10,table.getCapacity()); //See if there is 0 entries in the table.
    System.out.println("**********Printing Put(Scenario 2)**********");
    table.print();
    System.out.println("\n");
  }
  
  /****************************************************************************
   * 
   * Hash Codes don't match, so Linear Probe.
   * 
   ***************************************************************************/
  @Test
  public void testPutScenario3() {
    UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
    assertNull(table.put(0, "Alpha"));
    assertNull(table.put(1, "Bravo"));
    assertNull(table.put(2, "Charlie"));
    
    assertNull(table.put(10, "Delta")); //Should go to index [5] w/hashCode (0)
    assertNull(table.put(5, "Echo")); //Should collision but go to index[6] w/hashCode(5);

    assertNull(table.put(15, "Foxtrot")); //Should collision twice but go to index[7] w/hashCode(5);
    assertNull(table.put(4, "Golf"));
    assertNull(table.put(14, "Hotel"));
    assertNull(table.put(7, "India"));
    assertNull(table.put(8, "Juliette"));
    
    assertEquals("Foxtrot", table.get(15));
    assertEquals("Golf", table.get(4));
    assertEquals("Hotel", table.get(14));
    assertEquals("India", table.get(7));
    assertEquals("Juliette", table.get(8));

    System.out.println("**********Printing Put(Scenario 3)**********");
    table.print();
    System.out.println("\n");
  }
  
  @Test
  public void testRemove() {
	UhHashTable<Integer, String> table = new UhHashTable<Integer, String>(10);
	assertNull(table.put(0, "Alpha"));
	assertNull(table.put(1, "Bravo"));
	assertNull(table.put(2, "Charlie"));
	assertNull(table.put(12, "Delta"));
	assertNull(table.put(11, "Echo"));
	assertNull(table.put(10, "Foxtrot"));

	table.print();

	table.remove(12); //Remove Delta

	table.print();
	
  }
}
