package com.kunal.poc.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImpl implements BinaryTree {

	BinaryTreeNode rootNode;
	
	
	public BinaryTreeImpl(int rootData) {
		rootNode = new BinaryTreeNode(rootData);
	}
	
	/* (non-Javadoc)
	 * @see com.kunal.ds.tree.binary.BinaryTree#insert(com.kunal.ds.tree.binary.BinaryTreeNode)
	 * Inserts data in binary tree on levelOrder basis.
	 */
	@Override
	public void insert(int data) 
	{
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(rootNode);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode btn = queue.poll();
			if(btn.leftNode== null) {
				btn.leftNode = new BinaryTreeNode(data);
				break;
			}else {
				queue.add(btn.leftNode);
			}
			
			
			if(btn.rightNode == null) {
				btn.rightNode = new BinaryTreeNode(data);
				break;
			}else {
				queue.add(btn.rightNode);
			}
		}
	}


	@Override
	public void lrdTraversal(BinaryTreeNode node) {
		if(node.leftNode != null) {
			lrdTraversal(node.leftNode);
		}
		
		if(node.rightNode != null) {
			lrdTraversal(node.rightNode);
		}
		System.out.println(node.data);
	}

	@Override
	public void ldrTraversal(BinaryTreeNode node) {
		if(node.leftNode != null) {
			lrdTraversal(node.leftNode);
		}
		System.out.println(node.data);
		if(node.rightNode != null) {
			lrdTraversal(node.rightNode);
		}
	}

	@Override
	public void rldTraversal(BinaryTreeNode node) {
		if(node.rightNode != null) {
			lrdTraversal(node.rightNode);
		}
		if(node.leftNode != null) {
			lrdTraversal(node.leftNode);
		}
		System.out.println(node.data);
	}

	@Override
	public BinaryTreeNode getRootNode() {
		return rootNode;
	}


	@Override
	public boolean ifSimilarTo(BinaryTreeNode leftBtree, BinaryTreeNode rightBTree) {

		if(leftBtree == null && rightBTree != null  || leftBtree!=null && rightBTree== null) {
			return false;
		}
		if(leftBtree == null && rightBTree == null) {
			return true;
		}
		return ifSimilarTo(leftBtree.getLeftNode(),rightBTree.getLeftNode()) && ifSimilarTo(leftBtree.getRightNode(),rightBTree.getRightNode());
	}

	@Override
	public boolean ifReplicaTo(BinaryTreeNode leftBtree, BinaryTreeNode rightBTree) {
 
		if(leftBtree == null && rightBTree != null  || leftBtree!=null && rightBTree== null) {
			return false;
		}
		if(leftBtree == null && rightBTree == null) {
			return true;
		}
		
		
		if(leftBtree.getData() == rightBTree.getData()) {
			return ifReplicaTo(leftBtree.getLeftNode(),rightBTree.getLeftNode()) && ifReplicaTo(leftBtree.getRightNode(),rightBTree.getRightNode());
		}else {
			return false;
		}
	}

	@Override
	public boolean ifMorrorTo(BinaryTreeNode leftBtree, BinaryTreeNode rightBTree) 
	{
		if(leftBtree == null && rightBTree != null  || leftBtree!=null && rightBTree== null) {
			return false;
		}
		if(leftBtree == null && rightBTree == null) {
			return true;
		}
		
		if(leftBtree.getData() == rightBTree.getData()) {
			return ifMorrorTo(leftBtree.getLeftNode(),rightBTree.getRightNode()) && ifMorrorTo(leftBtree.getRightNode(),rightBTree.getLeftNode());
		}else {
			return false;
		}
		
	}

	@Override
	public void levelOrderTraversal(BinaryTreeNode node) {
		if(null == node) {
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(node);

		while(!queue.isEmpty()) 
		{
			BinaryTreeNode currentNode = queue.poll();
			if(null != currentNode) 
			{
			System.out.println("Data:"+currentNode.data);
			queue.offer(currentNode.leftNode);
			queue.offer(currentNode.rightNode);
			}
		}
	}

	@Override
	public int getHeight(BinaryTreeNode node) {
		if(node == null) {
			return -1;
		}
		
		int leftHeight = getHeight(node.leftNode);
		int rightHeight = getHeight(node.rightNode);
		return leftHeight > rightHeight ? leftHeight+1:rightHeight+1;
	}

	@Override
	public void topView(BinaryTreeNode node) 
	{
		if(null == node) 
		{
			return;
		}
		else 
		{
			topView(node.leftNode);
			System.out.print(node.data + " ");
			topView(node.rightNode);
			System.out.print(node.data + " ");
		}
	}

	@Override
	public int getHeightWithoutRecursion(BinaryTreeNode node) {
		//Base Case
		if(null == node) {
			return 0;
		}
		
		int height = 0;
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(node);
	
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			if(0==queueSize)
			{
				break;
			}else {
				//This will be for each level
				height++;
			}
		
			//Iterate through current level nodes and pop them and add next level elements.
			//The next level height will be achieved once the upper while loop will get executed.
			while(queueSize >0){
			BinaryTreeNode  poppedNode =queue.poll();
			
			if(poppedNode !=null && poppedNode.leftNode!=null) {
				queue.offer(poppedNode.leftNode);
			}
			if(poppedNode !=null && poppedNode.rightNode!=null) {
				queue.offer(poppedNode.rightNode);
			}
			queueSize--;
			}
			
		}
		return height;
	}

	@Override
	public int getMinHeightWithoutRecursion(BinaryTreeNode node) {
		if(node == null) {
			return 0;
		}
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<>();
		queue.offer(node);
		int minHeight = 0;
		
		while(!queue.isEmpty()) {
			BinaryTreeNode currNode = queue.poll();
			
			if(currNode.leftNode== null&& currNode.rightNode==null) {
				return minHeight;
			}else {
				minHeight++;
			}
			if(currNode.leftNode!= null) {
				queue.offer(currNode.leftNode);
			}
			if(currNode.rightNode!= null) {
				queue.offer(currNode.rightNode);
			}
		}
		return 0;
	}

	@Override
	public int diameter(BinaryTreeNode root) {
		if(null == root) {
			return 0;
		}
		
		int lheight = getHeight(root.leftNode);
		int rheight = getHeight(root.rightNode);
		
		int ldiameter = diameter(root.leftNode);
		int rdiameter = diameter(root.rightNode);
		
		 /* Return max of following three 
        1) Diameter of left subtree 
       2) Diameter of right subtree 
       3) Height of left subtree + height of right subtree + 1 */
      return Math.max(lheight + rheight + 1, 
                      Math.max(ldiameter, rdiameter)); 
	}

	@Override
	public void printPathFromNode(BinaryTreeNode root,int arr[],int length) {
		
		if(root == null) {
			return;
		}
		
		arr[length] = root.data;
		length++;
		
		if(root.leftNode == null && root.rightNode== null) {
			printNodesTillThisPath(arr,length);
		}
		else
		{
			printPathFromNode(root.leftNode, arr, length);
			printPathFromNode(root.rightNode, arr, length);
		}
	}

	private void printNodesTillThisPath(int[] arr, int length) {
		System.out.println("Print Start path");
		for(int i= 0;i<length;i++) {
		System.out.println(arr[i]);
		}
		System.out.println("Print End path");
	}
	
	@Override
	public void printPathFromNodeHavingSpecifiedSum(BinaryTreeNode root, int[] arr, int length, int sum) {

		
		if(root == null) {
			return;
		}
		
		arr[length] = root.data;
		length++;
		
		if(root.leftNode == null && root.rightNode== null && root.data == sum) {
			printNodesTillThisPath(arr,length);
		}
		else
		{
			printPathFromNodeHavingSpecifiedSum(root.leftNode, arr, length,sum-root.data);
			printPathFromNodeHavingSpecifiedSum(root.rightNode, arr, length,sum-root.data);
		}
	
		
	}
}
