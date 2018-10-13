package com.kunal.poc.binarytree;

public class BinaryTreeNode {
	
	BinaryTreeNode leftNode;
	int data;
	BinaryTreeNode rightNode;
	
	public BinaryTreeNode() {
		leftNode = null;
		data = 0;
		rightNode = null;
	}
	
	
	public BinaryTreeNode(BinaryTreeNode leftNode,int data,BinaryTreeNode rightNode) {
		this.leftNode = leftNode;
		this.data = data;
		this.rightNode = rightNode;
	}


	public BinaryTreeNode(int rootData) {
		this.leftNode = null;
		this.data = rootData;
		this.rightNode = null;
	}


	public BinaryTreeNode getLeftNode() {
		return leftNode;
	}


	public void setLeftNode(BinaryTreeNode leftNode) {
		this.leftNode = leftNode;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public BinaryTreeNode getRightNode() {
		return rightNode;
	}


	public void setRightNode(BinaryTreeNode rightNode) {
		this.rightNode = rightNode;
	}
	
	

}
