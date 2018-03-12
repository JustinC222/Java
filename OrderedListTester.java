/*
 * 
 * 
 * Description: This program is meant to serve as a test case for the OrderedList class and is meant to
 * 				pre-identify and errors that may arise once instantiating an OrderedList object.
 */



package orderedArray;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedListTest {

	
	// This test case will initialize several orderedList objects and test to make sure the object was created
	// and that is is of correct size when it comes to the total length of the array and how many spots are filled
	// once initiated.
	@Test
	public void testConstructor() {
		
		OrderedList myList = new OrderedList(10);
		assertEquals(10, myList.size());
		assertEquals(0,myList.numEntries());
		
		OrderedList mySecondList = new OrderedList(5);
		assertEquals(5, mySecondList.size());
		assertEquals(0, mySecondList.numEntries());
		
		// Check for restriction "if the parameter is less than 2, create an array of size 2"
		OrderedList myThirdList = new OrderedList(0);
		assertEquals(2, myThirdList.size());
		assertEquals(0, myThirdList.numEntries());
		
		// Check for restriction "if the parameter is less than 2, create an array of size 2"
		OrderedList myFourthList = new OrderedList(1);
		assertEquals(2, myFourthList.size());
		assertEquals(0, myFourthList.numEntries());
		
		// Check for restriction "if the parameter is less than 2, create an array of size 2"
		OrderedList myFifthList = new OrderedList(-1);
		assertEquals(2, myFifthList.size());
		assertEquals(0,myFifthList.numEntries());

		OrderedList mySixthList = new OrderedList(2);
		assertEquals(2, mySixthList.size());
		assertEquals(0, mySixthList.numEntries());
	}
	
	// testSize initializes several OrderedList objects and ensures that the objects created are of correct size.
	// Restrictions on the constructor of OrderedList includes: "if the parameter is less than 2, create an array 
	// of size 2". This test case tests for that restriction as well as instantiating arrays much larger and
	// ensuring the method accurately creates OrderedList arrays of correct size. 

	
	@Test
	public void testSize() {
		
		// Check for restriction "if the parameter is less than 2, create an array of size 2"
		OrderedList myList = new OrderedList(0);
		assertEquals(2, myList.size());
		
		// Check for restriction "if the parameter is less than 2, create an array of size 2"
		OrderedList mySecondList = new OrderedList(1);
		assertEquals(2, mySecondList.size());
		
		OrderedList myThirdList = new OrderedList(2);
		assertEquals(2, myThirdList.size());
		
		// Begins test of arrays larger than 2:
		OrderedList myFourthList = new OrderedList(10);
		assertEquals(10, myFourthList.size());
		
		OrderedList myFifthList = new OrderedList(20);
		assertEquals(20, myFifthList.size());
		
		OrderedList mySixthList = new OrderedList(30);
		assertEquals(30, mySixthList.size());
		
		OrderedList mySeventhList = new OrderedList(40);
		assertEquals(40, mySeventhList.size());
		
		OrderedList myEighthList = new OrderedList(50);
		assertEquals(50, myEighthList.size());
	}
		
	// testNumEntries will instantiate several OrderedList object, add entries to them, and also delete
	// entries from them all the while testing to make sure the number of entries stored inside the 
	// OrderedList array is correct during every intermidiate step. 
	@Test
		public void testNumEntries() {
			
			OrderedList myList = new OrderedList(4);
			// Checking to make sure there is nothing inside the array once instantiated.
			assertEquals(0,myList.numEntries());
			 myList.insert(1);
			 assertEquals(1,myList.numEntries());
			 myList.insert(3);
			 myList.insert(2);
			 myList.insert(5);
			 assertEquals(4, myList.numEntries());
			 myList.delete(3);
			 assertEquals(3, myList.numEntries());
			 myList.insert(7);
			 assertEquals(4, myList.numEntries());
			 myList.insert(7);
			 // Checking two things: 1. duplicate number and 2. full array
			 assertEquals(4, myList.numEntries());
			 assertEquals(4,myList.size());
			 myList.delete(1);
			 myList.delete(2);
			 myList.delete(5);
			 assertEquals(1, myList.numEntries());
			 myList.delete(7);
			 // Checking to make sure we are once again back to nothing stored in the array after inserting/deleting.
			 assertEquals(0, myList.numEntries());
			 assertEquals(4, myList.size());
			
			 
			 OrderedList mySecondList = new OrderedList(8);	
			// Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0,mySecondList.numEntries());
			 mySecondList.insert(9);
			 mySecondList.insert(4);
			 assertEquals(2,mySecondList.numEntries());
			 mySecondList.insert(6);
			 mySecondList.insert(2);
			 mySecondList.insert(7);
			 assertEquals(5, mySecondList.numEntries());
			 mySecondList.delete(9);
			 assertEquals(4, mySecondList.numEntries());
			 mySecondList.delete(6);
			 assertEquals(3, mySecondList.numEntries());
			 mySecondList.insert(22);
			 assertEquals(4, mySecondList.numEntries());
			 mySecondList.insert(22);
			 // Checking for duplicate number restriction. 22 was entered twice. Makinng sure numEntries did not change.
			 assertEquals(4, mySecondList.numEntries());
			 assertEquals(8, mySecondList.size());
			
			 
			 OrderedList myThirdList = new OrderedList(15);
			// Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0,myThirdList.numEntries());
			 myThirdList.insert(4);
			 myThirdList.insert(1);
			 myThirdList.insert(3);
			 assertEquals(3,myThirdList.numEntries());
			 myThirdList.insert(6);
			 myThirdList.insert(17);
			 myThirdList.insert(12);
			 myThirdList.insert(22);
			 assertEquals(7, myThirdList.numEntries());
			 myThirdList.delete(6);
			 myThirdList.delete(4);
			 assertEquals(5, myThirdList.numEntries());
			 myThirdList.insert(22);
			 //  Checking duplicate number restriction once more.
			 assertEquals(5, myThirdList.numEntries());
			 myThirdList.insert(19);
			 assertEquals(6, myThirdList.numEntries());
			 myThirdList.insert(77);
			 assertEquals(7, myThirdList.numEntries());
			 assertEquals(15,myThirdList.size());
		}
	
	
	// The insert method will insert numbers into the array in ascending order. The method must find where to 
	// put the number and then shift every number after it, and then place that number there that way
	// the numbers remain in ascending order. testInsert instantiates several OrderedList objects, inserts
	// numbers, deletes numbers, and tests to make sure the correct number of entries remain in the array.
		@Test
		public void testInsert() {
			
			 OrderedList myList = new OrderedList(8);
			 // Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0,myList.numEntries());
			 assertEquals(8, myList.size());
			 myList.insert(7);
			 assertEquals(1,myList.numEntries());
			 myList.insert(22);
			 myList.insert(12);
			 assertEquals(3, myList.numEntries());
			 myList.insert(17);
			 myList.insert(23);
			 assertEquals(5, myList.numEntries());
			 myList.insert(23);
			 // Checking for duplicate restriction.
			 assertEquals(5, myList.numEntries());
			 myList.insert(1);
			 myList.insert(-1);
			 // Checking to make sure array accepts negative numbers. 
			 assertEquals(7, myList.numEntries());
			 myList.insert(77);
			 assertEquals(8, myList.numEntries());
			 assertEquals(8, myList.size());
			 myList.insert(-72);
			 // Checking to make sure array will not accept anymore values once full. 
			 assertEquals(8, myList.numEntries());
			 // Checking to make sure insert method has sorted all the values in the array correctly and has correct spacing.
			 assertEquals("-1 1 7 12 17 22 23 77", myList.toString());
				
			 
			 OrderedList mySecondList = new OrderedList(4);
			 // Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0,mySecondList.numEntries());
			 assertEquals(4, mySecondList.size());
			 mySecondList.insert(5);
			 assertEquals(1,mySecondList.numEntries());
			 mySecondList.insert(4);
			 mySecondList.insert(19);
			 assertEquals(3, mySecondList.numEntries());
			 mySecondList.insert(29);
			 mySecondList.insert(43);
			 // Checking to make sure array will not accept anymore values once full.
			 assertEquals(4, mySecondList.numEntries());
			 // Checking to make sure insert method has sorted all the values in the array correctly and has correct spacing.
			 assertEquals("4 5 19 29", mySecondList.toString());
			 mySecondList.delete(29);
			 mySecondList.delete(19);
			 assertEquals(2, mySecondList.numEntries());
			 mySecondList.insert(55);
			 assertEquals(3, mySecondList.numEntries());
			 assertEquals(4, mySecondList.size());
			 mySecondList.delete(5);
			 mySecondList.delete(4);
			 mySecondList.insert(-2);
			 mySecondList.insert(-5);
			 assertEquals(3,mySecondList.numEntries());
			 mySecondList.insert(222);
			 assertEquals(4, mySecondList.numEntries());
			 mySecondList.insert(99);
			 // Checking to make sure array will not fill if full.
			 assertEquals(4, mySecondList.numEntries());
			 assertEquals(4, mySecondList.size());
			// Checking to make sure insert method has sorted all the values in the array correctly and has the correct spacing.
			 assertEquals("-5 -2 55 222", mySecondList.toString());
			 	
			  
		     OrderedList myThirdList = new OrderedList(10);
			 assertEquals(10, myThirdList.size());
			 // Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0, myThirdList.numEntries());
			 myThirdList.insert(-12);
			 myThirdList.insert(0);
			 myThirdList.insert(22);
			 assertEquals(3, myThirdList.numEntries());
			 myThirdList.insert(2);
			 myThirdList.insert(-17);
			 myThirdList.insert(14);
			 assertEquals(6, myThirdList.numEntries());
			 myThirdList.insert(59);
			 myThirdList.insert(79);
			 myThirdList.insert(42);
			 assertEquals(9, myThirdList.numEntries());
			 myThirdList.insert(-29);
			 assertEquals(10, myThirdList.numEntries());
			 myThirdList.insert(100);
			 // Checking to make sure method will not insert if array is full.
			 assertEquals(10, myThirdList.numEntries());
			 myThirdList.insert(63);
			 // Checking to make sure method will not insert if array is full.
			 assertEquals(10, myThirdList.numEntries());
			 myThirdList.delete(2);
			 assertEquals(9, myThirdList.numEntries());
			 myThirdList.insert(22);
			 // Checking to make sure method will not enter duplicates.
			 assertEquals(9, myThirdList.numEntries());
			 myThirdList.insert(100);
			 assertEquals(10, myThirdList.numEntries());
			 assertEquals(10, myThirdList.size());
				// Checking to make sure insert method has sorted all the values in the array correctly and has the correct spacing.
			 assertEquals("-29 -17 -12 0 14 22 42 59 79 100", myThirdList.toString());
				
			 // Checking to see if the array will be sorted in ascending order when 
			 // entered in descending order and checking to make sure numEntries
			 // returns the correct number. 
			 OrderedList myFourthList = new OrderedList(3);
			 myFourthList.insert(3);
			 myFourthList.insert(2);
			 myFourthList.insert(1);
			 assertEquals(3, myFourthList.numEntries());
			 assertEquals("1 2 3", myFourthList.toString());
			 assertEquals(3, myFourthList.size());

			// Checking to see if the array will remain in ascending order and 
			 // checking to make sure numEntries returns the correct number. 
			 OrderedList myFifthList = new OrderedList(3);
			 myFifthList.insert(1);
			 myFifthList.insert(2);
			 myFifthList.insert(3);
			 assertEquals(3, myFifthList.numEntries());
			 assertEquals("1 2 3", myFifthList.toString());
			 assertEquals(3, myFifthList.size());
			 
		}
		
	
		// testDelete will test to make sure the delete method is removing numbers in the array correctly.
		// The test will instantiate several arrays, add a bunch of numbers to them, and then delete them, 
		// checking to make sure the number of elements is correct after deleting and that they were 
		// sorted correctly. 
		@Test
		public void testDelete(){
			
			 OrderedList myList = new OrderedList(5);
			 // Checking to make sure there is nothing inside the array once instantiated.
			 assertEquals(0,myList.numEntries());
			 assertEquals(5, myList.size());
			 myList.delete(0);
			 // Checking to make sure the number of elements still remains 0 after deleting 0 from nothing.
			 assertEquals(0,myList.numEntries());
			 assertEquals(5, myList.size());
			 myList.insert(99);
			 assertEquals(1,myList.numEntries());
			 myList.delete(99);
			 // Checking to make sure after inserting and deleting the same number that count goes back to 0.
			 assertEquals(0,myList.numEntries());
			 myList.insert(4);
			 myList.insert(2);
			 myList.insert(3);
			 myList.insert(1);
			 myList.insert(0);
			// Checking to make sure insert method has sorted all the values in the array correctly and has the correct spacing.
			 assertEquals("0 1 2 3 4", myList.toString());
			 assertEquals(5, myList.numEntries());
			 assertEquals(5,myList.size());
			 // Begin multiple insert and delete methods and make sure the number of entries remains correct.
			 myList.delete(3);
			 assertEquals(4, myList.numEntries());
			 myList.delete(2);
			 assertEquals(3, myList.numEntries());
			 myList.delete(1);
			 assertEquals(2, myList.numEntries());
			 myList.insert(1);
			 assertEquals(3, myList.numEntries());
			 myList.delete(4);
			 assertEquals(2, myList.numEntries());
			 myList.delete(1);
			 assertEquals(1,myList.numEntries());
			 myList.insert(1);
			 assertEquals(2, myList.numEntries());
			 myList.insert(5);
			 assertEquals(3, myList.numEntries());
			 myList.delete(0);
			 assertEquals(2, myList.numEntries());
			 myList.delete(5);
			 assertEquals(1, myList.numEntries());
			 myList.insert(0);
			 assertEquals(2, myList.numEntries());
			 myList.delete(0);
			 assertEquals(1, myList.numEntries());
			 myList.delete(1);
			 assertEquals(0, myList.numEntries());
			// Checking to make sure insert method has sorted all the values in the array correctly and has the correct spacing.
			 assertEquals("", myList.toString());
			 myList.insert(777);
			 myList.delete(424);
			 // After deleting a number not in the array, checking that count remains 1.
			 assertEquals(1, myList.numEntries());
			 myList.delete(777);
			 assertEquals(0, myList.numEntries());
			 myList.delete(0);
			 // Checking to make sure count remains 0 after deleting within an empty array.
			 assertEquals(0, myList.numEntries());
		}		
		
		// testToString instantiates an OrderedList object, adds to it, deletes from it, and then checks
		// to make sure the output from toString remains correct through each method call. This means the 
		// numbers will be sorted correctly and there are spaces between each number, but not before the 
		// first number in the array or after the last.
		
		
		@Test
		public void testToString(){
			
			
			 OrderedList myList = new OrderedList(3);
			 assertEquals("", myList.toString());
			 myList.insert(1);
			 // Checking spacing for one value in string.
			 assertEquals("1", myList.toString());
			 myList.insert(3);
			 myList.insert(2);
			 // Checking for order and spacing in string with multiple numbers:
			 assertEquals("1 2 3", myList.toString());
			 myList.delete(3);
			 assertEquals("1 2", myList.toString());
			 myList.insert(42);
			 assertEquals("1 2 42", myList.toString());
			 myList.delete(1);
			 assertEquals("2 42", myList.toString());
			 myList.delete(2);
			 assertEquals("42", myList.toString());
			 myList.insert(99);
			 assertEquals("42 99", myList.toString());
			 myList.delete(42);
			 assertEquals("99", myList.toString());
			 myList.delete(99);
			 assertEquals("", myList.toString());
			 myList.insert(1);
			 assertEquals("1", myList.toString());
			 myList.insert(3);
			 assertEquals("1 3", myList.toString());
			 myList.insert(2);
			 assertEquals("1 2 3", myList.toString());
			 assertEquals(3, myList.size());
			 assertEquals(3, myList.numEntries());
						
		}
		
}


