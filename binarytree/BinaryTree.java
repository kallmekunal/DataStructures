package com.kunal.poc.binarytree;

public interface BinaryTree {
	
	void insert(int data);
	
	void rldTraversal(BinaryTreeNode node);
	
	void lrdTraversal(BinaryTreeNode node);
	
	void ldrTraversal(BinaryTreeNode node);
	
	BinaryTreeNode getRootNode();

}
