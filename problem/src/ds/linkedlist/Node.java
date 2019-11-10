package ds.linkedlist;

public class Node 
{
	//Previous node will only be used in relevant problems.
	public Node previousNode;
	public int data;
	public Node nextNode;
	
	public Node() {
		previousNode = null;
		data = 0;
		nextNode = null;
	}
	
	public Node(int data) {
		this.data = data;
	}
}
