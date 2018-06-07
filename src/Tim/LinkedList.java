//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
//string linked list
public class LinkedList {
	public LinkedList(){}//blank constructor
    private static class Node {
    	int score;
        String item;   // One of the items in the list
        Node next;     // Pointer to the node containing the next item.
                      //   In the last node of the list, next is null.
    }
    private Node head;
    public boolean find(String searchItem) {
        Node runner;    // A pointer for traversing the list.
        runner = head;  // Start by looking at the head of the list.
        while ( runner != null ) {
            if ( runner.item.equals(searchItem) )
                return true;
            runner = runner.next;  // Move on to the next node.
        }
        return false;
    } // end find()
    public int cnNodes(){
        Node runner;    // A pointer for traversing the list.
        runner = head;  // Start by looking at the head of the list.
        int c=0;
        while ( runner != null ) {
        	c++;
            runner = runner.next;  // Move on to the next node.
        }
        return c;
    }
    public boolean delete(String deleteItem) {
        if ( head == null ) {
        	return false;
        }
        else if ( head.item.equals(deleteItem) ) {
            head = head.next;
            return true;
        }
        else {
            Node runner;     // A node for traversing the list.
            Node previous;   // Always points to the node preceding runner.
            runner = head.next;   // Start by looking at the SECOND list node.
            previous = head;
            while ( runner != null && runner.item.compareTo(deleteItem) < 0 ) {
                previous = runner;
                runner = runner.next;
            }
            if ( runner != null && runner.item.equals(deleteItem) ) {
                previous.next = runner.next;
                return true;
            }
            else {
                    // The item does not exist in the list.
                return false;
            }
        }
    } // end delete()
    public void insert(String insertItem,int insertSc) {
        Node newNode;          // A Node to contain the new item.
        newNode = new Node();
        newNode.item = insertItem;  // (N.B.  newNode.next is null.)
        newNode.score = insertSc;
        if ( head == null ) {
                // The new item is the first (and only) one in the list.
                // Set head to point to it.
            head = newNode;
        }
        else if ( head.score <=insertSc) {
                // The new item is less than the first item in the list,
                // so it has to be inserted at the head of the list.
            newNode.next = head;
            head = newNode;
        }
        else {
                // The new item belongs somewhere after the first item
                // in the list.  Search for its proper position and insert it.
            Node runner;     // A node for traversing the list.
            Node previous;   // Always points to the node preceding runner.
            runner = head.next;   // Start by looking at the SECOND position.
            previous = head;
            while ( runner != null && runner.score>insertSc) {
                previous = runner;
                runner = runner.next;
            }
            newNode.next = runner;     // Insert newNode after previous.
            previous.next = newNode;
        }
    }  // end insert()
    public String[] getElements() {
        int count;          // For counting elements in the list.
        Node runner;        // For traversing the list.
        String[] elements;  // An array to hold the list elements.
        // First, go through the list and count the number
        // of elements that it contains.
        count = 0;
        runner = head;
        while (runner != null) {
            count++;
            runner = runner.next;
        }
        elements = new String[count*2];
        runner = head;
        count = 0;
        while (runner != null) {
            elements[count] = runner.item;
            elements[count+1] = String.valueOf(runner.score);
            count=count+2;
            runner = runner.next;
        }
        for(int i=0;i<elements.length;i++){
        	System.out.println(elements[i]);
        }
        // Return the array that has been filled with the list elements.
        return elements;
    } // end getElements()
}//end class