package com.kunal.poc.heap;

public interface IHeap {
	
	int parent(int postion);
	
	int leftChild(int position);
	
	int rightChild(int position);
	
	void insert(int toBeinserted);

	void maxHeapify(int posToHepify);
	
	public void print();
	
	public int extractMax();
	
	boolean isLeaf(int pos);
	
	void swap(int position1 ,int postion2);
	
	void heapSort();
	
	void unify(int arr1[],int arr2[]);
	
	int size();
	
}
