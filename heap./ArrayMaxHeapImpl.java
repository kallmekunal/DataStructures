package com.kunal.poc.heap;

public class ArrayMaxHeapImpl implements IHeap{

	public static void main(String[] args) {
		System.out.println("The Max Heap is "); 
		ArrayMaxHeapImpl maxHeap = new ArrayMaxHeapImpl(15); 
		int arr1[] = {1,34,76};
		int arr2[] = {4,9,8};
		maxHeap.unify(arr1, arr2);
		maxHeap.test();
		System.out.println("--");
		maxHeap.heapSort();
	}

	private  void test() {
		for(int i: heap) {
			System.out.println(i);
		}
	}
	
	int heap[];
	int size;
	int maxSize;
	
	public ArrayMaxHeapImpl(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		heap = new int[maxSize+1];
		heap[0] = Integer.MAX_VALUE;
	}

	@Override
	public int parent(int position) {
		return position/2;
	}

	@Override
	public int leftChild(int position) {
		return position*2;
	}

	@Override
	public int rightChild(int position) {
		return position*2+1;
	}

	@Override
	public void insert(int toBeinserted) {
		heap[++size] = toBeinserted; 
		  
	        // Traverse up and fix violated property 
	        int current = size; 
	        while (heap[current] > heap[parent(current)]) { 
	            swap(current, parent(current)); 
	            current = parent(current); 
	        } 
	}

	@Override
	public void maxHeapify(int posToHepify) {
		if(isLeaf(posToHepify)) {
			return;
		}
	
		if(heap[posToHepify]< heap[leftChild(posToHepify)]
				|| heap[posToHepify]< heap[rightChild(posToHepify)]) {
			
			 if (heap[leftChild(posToHepify)] > heap[rightChild(posToHepify)]) { 
	                swap(posToHepify, leftChild(posToHepify)); 
	                maxHeapify(leftChild(posToHepify)); 
	            } 
	            else { 
	                swap(posToHepify, rightChild(posToHepify)); 
	                maxHeapify(rightChild(posToHepify)); 
	            } 
		}
		
	}

	@Override
	public void print() {
		for(int i =1;i<= size/2;i++) {
			System.out.println("Parent : "+heap[i]+ " left child :"+ heap[leftChild(i)]+ " Right child "+ heap[rightChild(i)] );
		}
	}

	@Override
	public int extractMax() {
		 int popped = heap[1]; 
		 heap[1] = heap[size--]; 
	        maxHeapify(1); 
	        return popped; 
	}

	@Override
	public boolean isLeaf(int position) {
		
		if(position>=size/2 && position <=size && size/2 != position)
			return true;
		
		return false;
	}

	@Override
	public void swap(int position1, int position2) {
		int tmp = heap[position1];
		heap[position1] = heap[position2];
		heap[position2] = tmp;
	}

	@Override
	public void heapSort() {
		while(size !=0) {
			System.out.println(extractMax());
		}
	}

	@Override
	public void unify(int[] arr1, int[] arr2) {
		int arr[] = new int[arr1.length+arr2.length];
		int i =0;
		for( i=0;i<arr1.length;i++) {
			arr[i] = arr1[i];
		}
		
		for(int j = 0;j<arr2.length;j++) {
			arr[i++]=arr2[j];
		}
		System.out.println("--");
		System.arraycopy(arr, 0, heap, 1, arr.length);
		maxHeapify(1);
 	}

	@Override
	public int size() {
		return size;
	}

}
