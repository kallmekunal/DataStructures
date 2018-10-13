package com.kunal.poc.binarytree;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		BinaryTree  btree = new BinaryTreeImpl(5);
		btree.insert(1);
		btree.insert(2);
		btree.insert(3);

		
		btree.ldrTraversal(btree.getRootNode());
		System.out.println("--Seperator--");
		btree.lrdTraversal(btree.getRootNode());
		System.out.println("--Seperator--");
		btree.rldTraversal(btree.getRootNode());
		
		
		List<Integer> nums = new ArrayList<Integer>();
		Integer i = 2;
		nums.add(i);
		Double d = 3.14;
//		nums.add(d);
		
		nums.stream().forEach(e -> System.out.println(e));
	}

}