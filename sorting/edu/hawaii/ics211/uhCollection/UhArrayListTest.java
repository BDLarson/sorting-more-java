package edu.hawaii.ics211.uhCollection;

import static org.junit.Assert.*;
import org.junit.Test;

public class UhArrayListTest {

	@Test
	public void testFind() {
		UhArrayList list = new UhArrayList(10);
		 list.addFirst("Alpha");
		 list.addLast("Bravo");
		 list.addLast("Charlie");
		 list.addLast("Delta");
		 list.addLast("Echo");
		 
		 assertEquals(list.get(0).toString(), list.find("Alpha")); //Find something at the beginning of the list.
		 assertEquals(list.get(1).toString(), list.find("Bravo")); //Find something in the middle of the list.
		 assertEquals(list.get(4), list.find("Echo")); //Find something at the end of the list.
		 assertEquals(null, list.find("Foxtrot")); //Find nothing.
		 assertNull(list.find(null)); //Find null.
		 assertNull(list.find("")); //Find empty space.
		 assertNull(list.find(" ")); //Find space.
		 assertNull(list.find("Echoes")); //Find something similar but not exact.
	}

}
