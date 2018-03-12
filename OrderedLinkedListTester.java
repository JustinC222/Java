package orderedLink;


public class OrderedLinkedListTester {

	public static void main(String args[]){
		
	
	OrderedLinkedList link = new OrderedLinkedList();
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println(link.toString());
	link.insert(4);
	link.insert(9);
	link.insert(22);
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println(link.toString());
	System.out.println("get index 0: " + link.get(0));
	System.out.println("get index 1: " + link.get(1));
	System.out.println("get index 2: " + link.get(2));
	System.out.println();
	System.out.println("Deleted: 9");
	link.delete(9);
	System.out.println(link.toString());
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println();
	System.out.println("Inserted: 14");
	link.insert(14);
	System.out.println(link.toString());
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println("get index 0: " + link.get(0));
	System.out.println("get index 1: " + link.get(1));
	System.out.println("get index 2: " + link.get(2));
	System.out.println();
	System.out.println("Deleted 4 and 14");
	link.delete(4);
	link.delete(14);
	System.out.println(link.toString());
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println("get index 0: " + link.get(0));
	System.out.println();
	System.out.println("Inserting: 22, 7, 12, and 15");
	link.insert(22);
	link.insert(7);
	link.insert(12);
	link.insert(15);
	System.out.println(link.toString());
	System.out.println("Num Entries: " + link.numEntries());
	System.out.println();
	System.out.println("Deleting all of them one by one");
	System.out.println(link.toString());
	link.delete(22);
	System.out.println(link.toString());
	link.delete(15);
	System.out.println(link.toString());
	link.delete(12);
	System.out.println(link.toString());
	System.out.println();
	System.out.println("Testing the IllegalArgumentException catch block in the delete method:");
	System.out.println();
	link.delete(111);
	link.delete(222);
	link.delete(777);
	System.out.println();
	System.out.println("Now testing the NullPointerException catch in your get method:");
	System.out.println();
	link.get(2);
	link.get(3);
	link.get(4);
	System.out.println();
	System.out.println("Good! Your code works :)");



	
	
	
	}
}
