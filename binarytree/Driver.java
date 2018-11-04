package com.kunal.poc.binarytree;

import java.util.ArrayList;
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
		
		
		List<Integer> nums = new ArrayList<Integer>();
		Integer i = 2;
		nums.add(i);
		Double d = 3.14;
//		nums.add(d);
		
		nums.stream().forEach(e -> System.out.println(e));
	}

}
