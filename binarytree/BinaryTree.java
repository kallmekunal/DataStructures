package com.kunal.poc.binarytree;

public interface BinaryTree {
	
	void insert(int data);
	
	void rldTraversal(BinaryTreeNode node);
	
	void lrdTraversal(BinaryTreeNode node);
	
	void ldrTraversal(BinaryTreeNode node);
	
	void levelOrderTraversal(BinaryTreeNode node);
	
	void topView(BinaryTreeNode node);
	
	BinaryTreeNode getRootNode();
	
	boolean ifMorrorTo(BinaryTreeNode binaryTreeNode, BinaryTreeNode binaryTreeNode2);
	
	boolean ifSimilarTo(BinaryTreeNode binaryTreeNode, BinaryTreeNode binaryTreeNode2);

	boolean ifReplicaTo(BinaryTreeNode binaryTreeNode, BinaryTreeNode binaryTreeNode2);

	int getHeight(BinaryTreeNode node);
	
	int getHeightWithoutRecursion(BinaryTreeNode node);

	int getMinHeightWithoutRecursion(BinaryTreeNode node);

}
