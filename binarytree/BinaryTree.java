package com.kunal.poc.binarytree;

public interface BinaryTree {
	
	void insert(int data);
	
	void rldTraversal(BinaryTreeNode node);
	
	void lrdTraversal(BinaryTreeNode node);
	
	void ldrTraversal(BinaryTreeNode node);
	
	BinaryTreeNode getRootNode();
	
	boolean ifMorrorTo(BinaryTree tree);
	
	
	boolean ifSimilarTo(BinaryTree tree);

	boolean ifReplicaTo(BinaryTreeNode binaryTreeNode, BinaryTreeNode binaryTreeNode2);

}
