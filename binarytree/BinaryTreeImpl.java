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

}
