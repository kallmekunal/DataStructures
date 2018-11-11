package com.kunal.poc.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		BinaryTree  btree = new BinaryTreeImpl(5);
		btree.insert(1);
		btree.insert(2);
		btree.insert(3);
		btree.insert(6);
		btree.insert(7);
		btree.insert(8);


		BinaryTree  btree2 = new BinaryTreeImpl(5);
		/*btree2.insert(2);
		btree2.insert(1);
		btree2.insert(8);
		btree2.insert(7);
		btree2.insert(6);
		btree2.insert(3);*/
		
		System.out.println("Same "+ btree.ifReplicaTo(btree.getRootNode(), btree2.getRootNode()));
		System.out.println("Similar "+ btree.ifSimilarTo(btree.getRootNode(), btree2.getRootNode()));
		System.out.println("Mirror "+ btree.ifMorrorTo(btree.getRootNode(), btree2.getRootNode()));
		
		btree.ldrTraversal(btree.getRootNode());
		System.out.println("--Seperator--");
		btree.lrdTraversal(btree.getRootNode());
		System.out.println("--Seperator--");
		btree.rldTraversal(btree.getRootNode());
		System.out.println("--Seperator--");
		btree.levelOrderTraversal(btree.getRootNode());
		System.out.println("Height"+btree.getHeight(btree.getRootNode()));
		System.out.println("Height"+btree2.getHeight(btree2.getRootNode()));
		btree.topView(btree.getRootNode());
		
		
		System.out.println("--Get Max ehight Seperator--");
		System.out.println(btree.getHeightWithoutRecursion(btree.getRootNode()));
		System.out.println("--Get Max ehight Seperator--");
		
		testMinDepthWithoutrecursion();
		testDiameter();
		
		
		List<Integer> nums = new ArrayList<Integer>();
		Integer i = 2;
		nums.add(i);
		Double d = 3.14;
//		nums.add(d);
		
		nums.stream().forEach(e -> System.out.println(e));
		
		testPrintPathTillLeaf();
		testPrintPathTillLeafWithSpecifiedSum();
		testVerticalOrderTraversal();
		testZigZagOrderTraversal();
	}

	private static void testZigZagOrderTraversal() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		
		
		System.out.println("--ZigZag--");
		impl.zigzagTraversal(root,true);
		System.out.println("--ZigZag--");
	}

	private static void testMinDepthWithoutrecursion() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		
		
		System.out.println("--Get Min height Seperator--");
		System.out.println(impl.getMinHeightWithoutRecursion(impl.getRootNode()));
		System.out.println("--Get Min height Seperator--");
	}
	
	
	private static void testDiameter() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		root.leftNode.leftNode.leftNode = new BinaryTreeNode(3);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		
		
		System.out.println("--Get dim Seperator--");
		System.out.println(impl.diameter(impl.getRootNode()));
		System.out.println("--Get dim Seperator--");
	}
	
	private static void testPrintPathTillLeaf() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		root.leftNode.leftNode.leftNode = new BinaryTreeNode(4);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		
		
		System.out.println("--Print path--");
		impl.printPathFromNode(root, new int[20], 0);
		System.out.println("--Print path--");
	}
	
	private static void testPrintPathTillLeafWithSpecifiedSum() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		root.leftNode.leftNode.leftNode = new BinaryTreeNode(4);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		
		
		System.out.println("--Print path--");
		impl.printPathFromNodeHavingSpecifiedSum(root, new int[20], 0,6);
		System.out.println("--Print path--");
	}
	
	private static void testVerticalOrderTraversal() {
		BinaryTreeImpl impl = new BinaryTreeImpl(1);
		BinaryTreeNode root = impl.getRootNode();
		root.leftNode = new BinaryTreeNode(2);
		root.leftNode.rightNode = new BinaryTreeNode(20);
		root.leftNode.leftNode = new BinaryTreeNode(3);
		root.leftNode.leftNode.leftNode = new BinaryTreeNode(4);
		BinaryTreeNode rightNode = new BinaryTreeNode(5);
		root.rightNode = rightNode;
		root.rightNode.leftNode = new BinaryTreeNode(31);
		
		
		System.out.println("--Print testVerticalOrderTraversal--");
		HashMap<Integer, List<Integer>> listMap = new HashMap<>();
		impl.traverseInVertivcalOrder(root, 0, listMap);
		listMap.entrySet().stream().forEach(e -> {System.out.println(e.getKey()+"Values "+e.getValue());});
		System.out.println("--Print testVerticalOrderTraversal--");
	}

}
