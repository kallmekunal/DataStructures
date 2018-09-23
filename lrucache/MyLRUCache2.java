package com.kunal.poc.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MyLRUCache2{

	private Map<Integer,Node> map;
	private int capacity;
	Node head = null;
	Node tail = null;

	public MyLRUCache2(int myCapacity) {
		map = new HashMap<>();
		this.capacity = myCapacity;
	}


	public void putNode(int key,int value) {
		Node node  = new Node(key, value);
		if(map.isEmpty()) 
		{
			map.put(key, node);
			setHead(node);
		}
		else 
		{
			if(map.containsKey(key)) 
			{
				//if(map.size() < capacity) {
				map.remove(key);
				removeNodeLinkedList(node);
				map.put(key, node);
				setHead(node);
			}
			else 
			{
				if(map.size() < capacity) 
				{
					map.put(key, node);
					setHead(node);
				}
				else 
				{
					map.remove(tail.key);
					removeNodeLinkedList(tail);
					map.put(key, node);
					setHead(node);
				}
			}

		}
	}

	public void removeNodeLinkedList(Node node) {
		if(node.pre != null) {
			node.pre.post = node.post;
		}
		else {
			head = node.post;
		}
		
		
		if(node.post != null) {
			node.pre.post = node.post;
			
		}else {
			tail = node.pre;
		}
	}


	public Node getNode(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			removeNodeLinkedList(node);
			setHead(node);
			return node;
		}else {
			return null;
		}
	}


	public void setHead(Node node) {
		node.post = head;
		node.pre = null;
		
		if(head == null) {
			head = node;
			tail = head;
		}else {
			head.pre = node;
		}
		head = node;
		/*if(tail ==null) {
			tail = head;
			
		}
*/
	}







	private void print() {
		System.out.println("----------Start-----------");
		Set<java.util.Map.Entry<Integer,Node>> entries = map.entrySet();
		entries.stream().forEach(e-> System.out.println("Key :"+ e.getKey()+" Value :"+ e.getValue().value));
		System.out.println("-----------End----------");
	}



	/*
	 * This class represents a node.
	 */
	private class Node{
		int key;
		int value;
		Node pre;
		Node post;


		Node(int key,int value){
			this.key = key;
			this.value = value;
		}
	}

	public static void main(String [] args) {
		MyLRUCache2 myLRUCache = new MyLRUCache2(4);
		myLRUCache.putNode(1, 21);
		myLRUCache.print();
		myLRUCache.putNode(2, 22);
		myLRUCache.print();
		myLRUCache.putNode(3, 23);
		myLRUCache.print();
		myLRUCache.putNode(4, 24);
		myLRUCache.putNode(5, 244);
		myLRUCache.putNode(6, 247);
		myLRUCache.print();
	}




}