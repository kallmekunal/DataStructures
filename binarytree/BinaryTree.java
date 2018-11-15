package com.kunal.poc.binarytree;

import java.util.HashMap;
import java.util.List;

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
	
	int diameter(BinaryTreeNode root);
	
	void printPathFromNode(BinaryTreeNode root,int arr[],int length);
	
	void printPathFromNodeHavingSpecifiedSum(BinaryTreeNode root,int arr[],int length,int sum);
	
	void traverseInVertivcalOrder(BinaryTreeNode root,int hd,HashMap<Integer,List<Integer>> hdNodeDataList);
	
	void zigzagTraversal(BinaryTreeNode root,boolean leftToRight);
	
	BinaryTreeNode createBinaryTreeFromInOrderAndPreOrderTraversal(int inOrder[],int preOrder[],int inStart,int inEnd);
}
