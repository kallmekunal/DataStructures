package com.kunal.poc.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyLRUCache< K, V > extends LinkedHashMap < K, V > {
	
	private static final long serialVersionUID = 1L;
	int frameSize;
	
	public MyLRUCache(int frameSize) {
		super(frameSize+1, 1.0f, true); 
		this.frameSize = frameSize;
	}
	
	 protected boolean removeEldestEntry(Map.Entry<K,V> entry) {
	        return (size() > frameSize);
	    } 
	
	private void print() {
		System.out.println("----------Start-----------");
		Set<java.util.Map.Entry<K, V>> entries = this.entrySet();
		entries.stream().forEach(e-> System.out.println("Key :"+ e.getKey()+" Value :"+ e.getValue()));
		System.out.println("-----------End----------");
	}
	
	public static void main(String [] args) {
		MyLRUCache<Integer,Integer> myLRUCache = new MyLRUCache<Integer, Integer>(4);
		myLRUCache.put(1, 21);
		myLRUCache.put(2, 22);
		myLRUCache.put(3, 23);
		myLRUCache.get(1);
		myLRUCache.put(4, 24);
		myLRUCache.put(5, 244);
		myLRUCache.put(6, 247);
		myLRUCache.print();
	}
	
	

}
