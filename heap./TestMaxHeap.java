package com.kunal.poc.heap;

import org.junit.Test;

import junit.framework.Assert;

public class TestMaxHeap {

	@Test
	public void testMax() {
		IHeap maxHeap = new ArrayMaxHeapImpl(5);
		maxHeap.insert(45);
		maxHeap.insert(35);
		maxHeap.insert(15);
		maxHeap.insert(95);
		Assert.assertEquals(95, maxHeap.extractMax());
	}

	@Test
	public void testMaxHeapAndLengthReduction() {
		IHeap maxHeap = new ArrayMaxHeapImpl(10);
		maxHeap.insert(45);
		maxHeap.insert(35);
		maxHeap.insert(15);
		maxHeap.insert(95);
		maxHeap.insert(115);
		maxHeap.insert(195);
		int size = maxHeap.size();
		Assert.assertEquals(195, maxHeap.extractMax());
		Assert.assertEquals(--size, maxHeap.size());
		Assert.assertEquals(115, maxHeap.extractMax());
		Assert.assertEquals(--size, maxHeap.size());
	}

}
