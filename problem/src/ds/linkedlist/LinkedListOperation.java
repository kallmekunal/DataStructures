package ds.linkedlist;

public class LinkedListOperation 
{
	static Node head;
	
	public LinkedListOperation() {
		head = new Node();
	}
	
	public void addNext(int data) 
	{
		Node tmp = head;
		while(tmp.nextNode!=null) 
		{
			tmp = tmp.nextNode;
		}
		tmp.nextNode = new Node(data);
		tmp.nextNode.nextNode = null;
	}
	
	public static void traverse() 
	{
		Node tmp = head;
		while(tmp!=null) 
		{
			System.out.println("Data: "+tmp.data);
			tmp = tmp.nextNode;
		}
	}
	
	public static boolean ifLoopExists() 
	{
		Node slowPointer = head;
		Node fastPointer = head;
		while(fastPointer!=null ) 
		{
			slowPointer = slowPointer.nextNode;
			fastPointer = fastPointer.nextNode.nextNode;
			if(slowPointer==fastPointer) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		Node node = new Node();
		head = node;
		node.nextNode = new Node(2);
		node.nextNode.nextNode = new Node(3);
		node.nextNode.nextNode.nextNode = new Node(4);
		node.nextNode.nextNode.nextNode.nextNode = new Node(5);
		node.nextNode.nextNode.nextNode.nextNode.nextNode = node.nextNode.nextNode;
		//System.out.println("Link Exists "+ ifLoopExists());
		removeCycle();
	}

	private static void removeCycle() 
	{
		Node slowPointer = head;
		Node fastPointer = head;
		Node tempAddress = null;
		while(fastPointer!=null ) 
		{
			slowPointer = slowPointer.nextNode;
			fastPointer = fastPointer.nextNode.nextNode;
			if(slowPointer==fastPointer) 
			{
				//Save node address
				tempAddress = fastPointer;
				break;
			}
		}
		
		Node traversalNode = head;
		//If loop exists 
		while(traversalNode!=null)
		{
			if(tempAddress == traversalNode)
			{
				
				System.out.println("Starting loop node "+ tempAddress.data);
				Node initialPoint = traversalNode;
				removeLoop(initialPoint);
				traverse();
				break;
			}
			else 
			{
				traversalNode = traversalNode.nextNode;
				tempAddress = tempAddress.nextNode;
			}
		}
	}

	private static void removeLoop(Node tempAddress) 
	{
		Node currentItem = tempAddress;
		while(currentItem.nextNode!= tempAddress)
		{
			currentItem = currentItem.nextNode;
		}
		currentItem.nextNode = null;
	}
}
