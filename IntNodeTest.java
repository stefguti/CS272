package lab4;

public class IntNodeTest {

	public static void main(String[] args) {
	
		IntNode link1 = new IntNode();
		
		System.out.println("Defualt:\n" +link1.toString());
		
		
		link1.setData(8);
		link1.addNodeAfterThis(11);
		link1.addNodeAfterThis(6);
		link1.addNodeAfterThis(23);
		System.out.println("\nLinked List:\n" + link1.toString());
		
		
		System.out.println("\nLinked List Length: " + IntNode.listLength(link1));   
		link1.removeNodeAfterThis();
		System.out.println("\n(Removed second Link)\nLinked List:\n" + link1.toString());
		
		System.out.println("\nLinked List Length:" + IntNode.listLength(link1));
		
		
		System.out.println("\nSearch 6:" + IntNode.search(link1, 6));
		System.out.println("Search 23:" + IntNode.search(link1, 23));
		

	}

}
