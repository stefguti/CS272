/*
 * @author Stefanie Gutierrez
*/

// 9/20/2019
// CS 272
// Lab 4: Singly Linked List - basic operations
// Puprose: work with and create nodes

package lab4;

public class IntNode {
	
	
	//instance variables
	private int data; 
	private IntNode link;
	
	//no-argument constructor
	public IntNode() {
		
		setData(0);
		setLink(null);
		
	}
	
	/**
	 * @precondition _data points to head of object and of type integer
	 * @postcondition create new node with integer value that points to _node
	 * @param data _data used for newly created node
	 * @param data _node that created node points to
	 */
	//Constructor with two parameters
	public IntNode(int _data, IntNode _node) {
		
		setData(_data);
		setLink(_node);
		
	}
	
	//Accessor methods
	public int getData() {
		
		return data;
	}
	
	public IntNode getLink() {
		
		return link;
		
	}

	//Mutator methods
	public void setData(int _data) {
		
		this.data = _data;
	}
	
	public void setLink(IntNode _node) {
		
		this.link = _node;
	}
	
	
	//toString Method prints object nodes
	public String toString() {
		
		IntNode cursor = this.getLink();
		String nodeString = String.format("%s", this.getData());
		
		//
		while(cursor != null) {
			
			nodeString = nodeString + "-> " + cursor.getData();
			
			cursor = cursor.getLink();
		}
		
		return nodeString;
		
	}
	
	//Method to add new node after node head
	/**
	 * 
	 * @param newData is the data that will be associated with newly created node
	*/
	public void addNodeAfterThis(int newData) {

		link = new IntNode(newData, link);
	}
	
	
	//Method to remove node after node head
	public void removeNodeAfterThis() {
		
		this.setLink(getLink().getLink());
		
		
	}
	
	
	// Method returns length of linked list
	/**
	* @param head starting point of linked list
	* @return integer value that represents how many nodes in Linked list
	*/
	public static int listLength(IntNode head) {
		
		IntNode cursor = head;
		int counter = 0;
		
		while(cursor != null) {
			
			cursor = cursor.getLink();
			counter++;
			
		}
		
		return counter;
		
	}
	
	// Method returns true if parameter data matches any data in all nodes starting from head
	/**
	* @param target head is the starting point of the search
	* @param target data is what the method will search for
	* @return returns true if data was found in linked list. false if not
	*/
	public static boolean search(IntNode head, int data) {
		
		IntNode cursor = head;
		while(cursor != null) {
			
			if(cursor.getData() == data) {
				return true;
			}
			
			cursor = cursor.getLink();
			
		}
		
		return false;
		
	}


	

} // end class IntNode
