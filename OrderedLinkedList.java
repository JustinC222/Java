/*
 * 
 * 
 * Purpose of class: The purpose of this class is to create a linked list and manipulate them without using the LinkedList library.
 * This class allows you to create, insert, delete, check the number of entries, see what is currently in the linked list, and get a 
 * value at a certain position in your linked list. This does this through the methods named insert, delete, numEntries, toString, and get. 
 */

package orderedLink;

public class OrderedLinkedList {
 
		 
	 private class IntNode {      
		 public int num;   
		 public IntNode next;      
		 
		 IntNode (int value, IntNode ptr) {  
				 num = value;    
				 next = ptr;   
	 	 }
		 
		 
		 // ** This method is the recursive helper method for toString()**
		 // This method takes the number in the current node and passes the reference to the next node in its recursive call. 
		 // This then takes that current number and adds it to the string variable all the way until this.next = null.
		 // The end result is a string with all the numbers from the LinkedList that is neatly displayed to the console. 
		 private String returnNextNum(){
			 String returnString = "";
			returnString = Integer.toString(this.num);
			 
			 if(this.next != null)
				 returnString += " " + this.next.returnNextNum();
			 
			 
			return returnString;
		 }
		 
		 
		 
		 // ** This method is the recursive helper method for get()**
		 // This method takes in an integer variable "count" and the index of the number you wish to view. 
		 // If the variable count is equal to the index you want to view, the number of that node is displayed. 
		 // If not, the count variable will increment and the method is recursively called again all the way until count 
		 // equals the index you want. Once that condition is true, the method will return the number at the index you asked for. 
		 private int returnNumAtIndex(int counter, int indexer){
			 int numberToBeReturned = -1; // -1 indicates the number was not found
			 
			 try{
				 
				 if(counter == indexer)
					 numberToBeReturned = this.num;
			 
				 else{
					 counter++;
					 numberToBeReturned = this.next.returnNumAtIndex(counter, indexer); 
				 }
		
			 }
			
			 // This catch block will catch all exceptions thrown regarding trying to access an index that is not currently in the LinkedList.
			 catch(NullPointerException e){
				System.out.println(indexer + " Get NOT Successful");
			 }
			
			return numberToBeReturned;
		 
		 }// end get() helper method
		 
		 
	  }// end IntNode class    
	
	 
	 private IntNode list; // By default null 
	 private int count; 
	

	 public OrderedLinkedList(){
		/* I left the OrderedLinkedList constructor empty because it didn't make sense to me to initialize info to 0 and 
		 * next to null when next already defaults to null. If there is a new OrderedLinkedList created, I wanted to be 
		 * able to choose the number in the first node and not have it preset to 0 due to the constructor.
		 */
	 }
	 
	 
	 
	 // returns count which is incremented whenever a new number is inserted in the insert() method, and decrements whenever
	 // a number is removed from the list in the delete() method. This effectively tells us the current number of entries in our LinkedList.
	 public int numEntries(){
		 return count;
	 }
	 
	 
	 /*
	  * This method inserts a number into the LinkedList in ascending order. One thing that this method will not allow are duplicates,
	  * if you enter a duplicate it will print to the console that duplicates are not allowed and the number that was attempted to be inserted
	  * will not be inserted into the LinkedList. If there are no entries currently in the list or if the number to be 
	  * inserted is smaller than the first number in the list, the number will be inserted at the beginning. If not, the correct spot
	  * must be determined. This is done by first finding at what point the numbers in the LinkedList start to become larger than the number to 
	  * be inserted. Once you find the first number that is larger than the number to be inserted, you place the new node right before it with
	  * its reference pointing to the node with the larger number. This is done by creating two temporary variables, one that follows the other
	  * and one that checks if the next nodes number is larger. If the next nodes number is indeed larger, than the node that is following will 
	  * insert the new node right after it with its reference point being the second temporary variable that was checking the next nodes. This 
	  * effectively adds a new node in the correct position without losing any of the nodes that were previously in the list!
	  */
	 public void insert(int numInsert){
		try{
			
		 if (list == null || list.num > numInsert){
	
					list = new IntNode (numInsert, list);
					count++;
				}

		 else { // need to find correct spot
					IntNode temp = list;
					IntNode follow = null;
					while (temp != null && temp.num < numInsert) {
						follow = temp;
						temp = temp.next;
					}
					
						follow.next = new IntNode (numInsert, temp);
						count++;
					
				}
		}
		catch(NullPointerException e){
			System.out.println(numInsert + " is a duplicate. Duplicates are not allowed.");
		}
	}

	 
	 
	 /*
	  * The delete method has similar logic to the insert() method, if the number asked to be deleted is the first number in the LinkedList, 
	  * the list will reference the node after the one asked to be deleted, essentially bypassing that node and removing it from the LinkedList
	  * altogether. If it is not the first number in the LinkedList it will again create two temporary variables, one that follows and the other
	  * will check if the next nodes number is equal to the one asked to be deleted. If it is, the follow node will reference the node that is
	  * going to be deleted's reference node. This bypasses the current node asked to be deleted, effectively removing it from the LinkedList.
	  */
	 public void delete(int deathToThee){
		 
		 try{
			 boolean found = false;
			 
			 if (list != null) 
				 if(list.num == deathToThee){
					list = list.next;
			 		count--;
			 		found = true;
				 }
			 
					else { // find and destroy >:]
						IntNode temp = list;
						IntNode follow = null;
						
						while (temp != null && temp.num != deathToThee) {
							follow = temp;
							temp = temp.next;
						}
						
						if (temp != null && temp.num == deathToThee){ 
							follow.next = temp.next;
							count--;
							found = true;
						}
							
					}// end else
			 
			 if(!found)
				throw new IllegalArgumentException();
			 
		 }// end try block
		 
		 
		// This catch block will catch all exceptions thrown regarding trying to delete a number not currently in the LinkedList.
		 catch(IllegalArgumentException e){
			 System.out.println(deathToThee + ": Delete NOT Successful");
		 }
		 
	 } // end delete() method

	 
	 
	 // Calls the recursive private method returnNextNum() in the IntNode class that will return every nodes number currently in the LinkedList.
	 // If the LinkedList is empty, the string will return blank indicating there are no numbers available to print to the console.
	 // (More information about the recursive method described above the "returnNextNum" method in the IntNode class).
	 public String toString(){
		 String returnString = "";
		
		 try{
		 returnString = this.list.returnNextNum();
		}
		catch(NullPointerException e){
			returnString = "";
		}
		
		return returnString;
	 }
	 
	
	 
	 // Calls the recursive private method returnNumAtIndex() declared in the IntNode class that will get the number at the desired index
	 // currently stored in the LinkedList.(More information about the recursive method described above the "returnNumAtIndex" method in the
	 // IntNode class).
	 public int get(int indexToGrab){
		 int count = 0;
		 int numAtIndex = list.returnNumAtIndex(count, indexToGrab);
	  
		return numAtIndex;
	}
	 

	 
}// end class :)


